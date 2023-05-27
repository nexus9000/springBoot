package edu.itstep.albums.blockchain;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jboss.logging.Logger;

public class RunApp {
private static Logger logger = Logger.getLogger(RunApp.class);
 public static void main(String[]args) {
	 Security.addProvider(new BouncyCastleProvider());
	 Wallet georgi = new Wallet();
	 Wallet marto = new Wallet();
	 Wallet lender =  new Wallet();
	 Blockchain chain = new Blockchain();
	 Miner miner = new Miner();
	 Transaction genesisTransaction = new Transaction(
			 lender.getPublicKey(), georgi.getPublicKey(), 10_000, null);
	 genesisTransaction.generateSignature(lender.getPrivateKey());
	 genesisTransaction.setTransactionId("0");
	 genesisTransaction.outputs.add(
			 new TransactionOutput(genesisTransaction.getReceiver(),
					 genesisTransaction.getAmount(),
					 genesisTransaction.getTransactionId()));
	 Blockchain.UTXOs.put(genesisTransaction.outputs.get(0).getId(),
			 genesisTransaction.outputs.get(0));
	 Blockchain.UTXOs.size();
	 logger.info("Constructing the genesis block...."+genesisTransaction.outputs.get(0));
	 Block genesis = new Block(Constants.GENESIS_PREV_HASH);
	 genesis.addTransaction(genesisTransaction);
	 miner.mine(genesis, chain);
	 
	 Block block1 = new Block(genesis.getHash());
	 logger.info("georgi balance is: "+ georgi.calculateBalance());
	 logger.info("georgi is tries to send to marto ...");
	 block1.addTransaction(georgi.transferMoney(marto.getPublicKey(), 1_000));
	 miner.mine(block1, chain);
	 logger.info("Joro's balance: "+georgi.calculateBalance());
	 logger.info("Marto's balance: "+ marto.calculateBalance());
	 
	 Block block2 = new Block(block1.getHash());
	 block2.addTransaction(georgi.transferMoney(marto.getPublicKey(), 500));
	 miner.mine(block2, chain);
	 logger.info("Joro's balance: "+georgi.calculateBalance());
	 logger.info("Marto's balance: "+ marto.calculateBalance());
	 
	 Block block3 = new Block(block2.getHash());
	 block2.addTransaction(marto.transferMoney(georgi.getPublicKey(), 100));
	 logger.info("Joro's balance: "+georgi.calculateBalance());
	 logger.info("Marto's balance: "+ marto.calculateBalance());
	 miner.mine(block3, chain);
	 logger.info("Miner's reward: "+ miner.getReward());
 }
}

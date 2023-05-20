package edu.itstep.albums.blockchain;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class RunApp {
 public static void main(String[]args) {
	 Security.addProvider(new BouncyCastleProvider());
	 Wallet georgi = new Wallet();
	 Wallet marto = new Wallet();
	 Wallet lender =  new Wallet();
	 Blockchain chain = new Blockchain();
	 Miner miner = new Miner();
	 Transaction genesisTransaction = new Transaction(
			 lender.getPublicKey(), georgi.getPublicKey(), 1000, null);
	 genesisTransaction.generateSignature(lender.getPrivateKey());
	 genesisTransaction.setTransactionId("0");
	 
 }
}

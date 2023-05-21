package edu.itstep.albums.blockchain;

import org.jboss.logging.Logger;

public class Miner {
	private double reward;
	private Logger logger = Logger.getLogger(Miner.class);

	public void mine(Block block, Blockchain blockChain) {
        while(!isGoldenHash(block)) {
        	block.incrementNonce();
        	block.generateHash();
        }
        logger.info(block + " was mined.");
        logger.info("Hash is "+ block.getHash());
        blockChain.addBlock(block);
        reward += Constants.MINER_REWARD;
	}

	public boolean isGoldenHash(Block block) {
		String leadingZeros = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
		return block.getHash().substring(0, Constants.DIFFICULTY).equals(leadingZeros);
	}

	public double getReward() {
		return this.reward;
	}
}

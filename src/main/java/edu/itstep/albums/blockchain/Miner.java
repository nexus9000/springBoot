package edu.itstep.albums.blockchain;

public class Miner {
  private double reward;
  
  public void mine(Block block, Blockchain blockChain) {
	  
  }
  
  public boolean isGoldenHash(Block block) {
	  String leadingZeros = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');
	  return block.getHash().substring(0, Constants.DIFFICULTY).equals(leadingZeros);
  }
}

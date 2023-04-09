package edu.itstep.albums.blockchain;

import java.util.ArrayList;

public class BlockChainMain {
public final static ArrayList<Block> BLOCK_CHAIN = new ArrayList<>();	
public final static int DIFFICULTY = 5;
  public static void main(String...arg) {
	  Block b1 = new Block(0, null, "Our first Block");
	  b1.mineBlock(DIFFICULTY);
	  BLOCK_CHAIN.add(b1);
	  System.out.println(b1);
	  Block b2 = new Block(1, b1.getCurrentHash(), "Second block");
	  b2.mineBlock(DIFFICULTY);
	  BLOCK_CHAIN.add(b2);
	  System.out.println(b2);
  }
}

package edu.itstep.albums.blockchain;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class BlockChainMain {
	public final static ArrayList<Block> BLOCK_CHAIN = new ArrayList<>();
	public final static int DIFFICULTY = 3;

	public static void main(String... arg) {
		try {
			Wallet wallet = new Wallet();
			System.out.println("private key: "+wallet.getPrivateKey());
			System.out.println("public key: "+ wallet.getPublicKey());
			Block b1 = new Block(0, null, "Our first Block");// Genesis block
			b1.mineBlock(DIFFICULTY);
			BLOCK_CHAIN.add(b1);
			System.out.println(b1);
			System.out.println("Current Block Valid: " + validateBlock(b1, null));
			Block b2 = new Block(1, b1.getCurrentHash(), "Second block");
			b2.mineBlock(DIFFICULTY);
			BLOCK_CHAIN.add(b2);
			System.out.println(b2);
			System.out.println("Current Block Valid: " + validateBlock(b2, b1));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean validateBlock(Block newBlock, Block prevoiusBlock)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (prevoiusBlock == null) {
			if (newBlock.getIndex() != 0) {
				return false;
			} else if (newBlock.getPreviousHash() != null) {
				return false;
			} else if (newBlock.getCurrentHash() == null
					|| !(newBlock.calculateHash().equals(newBlock.getCurrentHash()))) {
				return false;
			}

			return true;
		}
		if (newBlock != null) {
			if ((prevoiusBlock.getIndex() + 1) != newBlock.getIndex()) {
				return false;
			} else if ((newBlock.getPreviousHash() == null)
					|| !(newBlock.getPreviousHash().equals(prevoiusBlock.getCurrentHash()))) {
				return false;
			} else if (newBlock.getCurrentHash() == null
					|| !(newBlock.calculateHash().equals(newBlock.getCurrentHash()))) {
				return false;

			} else {
				return true;
			}

		}
		return false;
	}

}

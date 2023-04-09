package edu.itstep.albums.blockchain;

import java.io.UnsupportedEncodingException;
import java.security.*;


public class Block {
	private final int index;
	private long timestamp;
	private String currentHash;
	private final String previousHash;
	private final String data;
	private int nonce;

	public Block(int index, String previousHash, String data) {
		this.index = index;
		this.previousHash = previousHash;
		this.data = data;
		nonce = 0;
	}

	public final String getCurrentHash() {
		try {
			String currentHash = calculateHash();
			return currentHash;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException exc) {
			throw new RuntimeException(exc);
		}
	}

	private final String calculateHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String input = index + timestamp + previousHash + data + nonce;
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(input.getBytes("UTF-8"));
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);

		}
		return hexString.toString();
	}

	public void mineBlock(int difficulty) {
		nonce = 0;
		String target = new String(new char[difficulty]).replace('\0', '0');
		currentHash = getCurrentHash();
		while (!currentHash.subSequence(0, difficulty).equals(target)) {
			nonce++;
			currentHash = getCurrentHash();
		}
	}

	@Override
	public String toString() {
		return "Block [index=" + index + ", timestamp=" + timestamp + ", currentHash=" + currentHash + ", previousHash="
				+ previousHash + ", data=" + data + ", nonce=" + nonce + "]";
	}

}

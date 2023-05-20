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
 }
}

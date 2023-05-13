package edu.itstep.albums.blockchain;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

public class Wallet {
	private PrivateKey privateKey;
	private PublicKey publicKey;

	public Wallet() {
		KeyPair keyPair = CryptographyHelper.ellipticCurveCrypto();
		privateKey = keyPair.getPrivate();
		publicKey = keyPair.getPublic();
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

}

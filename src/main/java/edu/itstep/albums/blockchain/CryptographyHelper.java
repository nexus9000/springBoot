package edu.itstep.albums.blockchain;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
public class CryptographyHelper {
	/**
	 * generate public key and private key
	 * private key: 256 bits long random integer
	 * public key: point on the elliptic curve
	 *(x,y) - both values are 256 bits long 
	 * @return
	 */
 public static KeyPair ellipticCurveCrypto() {
	 try {
	 KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(null);
	 return keyPairGenerator.generateKeyPair();
	 }catch(Exception e) {
		 throw new RuntimeException(e);
	 }
 }
}

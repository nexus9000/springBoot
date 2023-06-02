package edu.itstep.albums.blockchain;

import java.security.MessageDigest;

public class SHA256Helper {
   public static String hash(String data) {
	   try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(data.getBytes());
			StringBuilder hexaString = new StringBuilder();
			for(int i = 0; i < hash.length; i++ ) {
				String hex = Integer.toHexString(hash[i] & 0xff);
				if(hex.length() == 1)hexaString.append('0');
				hexaString.append(hex);
			}
			return hexaString.toString();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
   }
}

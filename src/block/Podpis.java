package block;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Podpis {
	
	public static String generiranjePodpisa(String podatek) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(podatek.getBytes("UTF-8"));	        
		StringBuffer hexString = new StringBuffer(); // 
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(0xff & hash[i]);
			if(hex.length() == 1) hexString.append('0');
			hexString.append(hex);
		}
		System.out.println("Podpis: "+ hexString.toString());
		return hexString.toString();
	}

}

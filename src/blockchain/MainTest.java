package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class MainTest {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	
		
		Block genesisBlock = new Block("Hi im the first block", "0");
		System.out.println("Hash for block 1 : " + genesisBlock.hash);
		
		Block secondBlock = new Block("Yo im the second block",genesisBlock.hash);
		System.out.println("Hash for block 2 : " + secondBlock.hash);
		
		Block thirdBlock = new Block("Hey im the third block",secondBlock.hash);
		System.out.println("Hash for block 3 : " + thirdBlock.hash);

	}
}
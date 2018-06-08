package block;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.google.gson.GsonBuilder;

import organizacijskaStruktura.MojNode;

public class MainTest {
	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
	public static int tezavnost = 0; //nastavi tezavnost na 0! 
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	
		blockchain.add(new Block(1,2,4, "0"));
		System.out.println("block 1... ");
		blockchain.get(0).rudarjenjeBloka(tezavnost);
		
		
		System.out.println("\nBlockchain je valid: " + validacija());
		
		String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
		System.out.println("\nThe block chain: ");
		System.out.println(blockchainJson);

	}
	
	public static Boolean validacija() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Block trenutniBlok; 
		Block prejsnjiBlok;
		
		
		for(int i=1; i < blockchain.size(); i++) {
			trenutniBlok = blockchain.get(i);
			prejsnjiBlok = blockchain.get(i-1);
			
			if(!trenutniBlok.getHash().equals(trenutniBlok.izracunHash()) ){
				System.out.println("Trenutni hash ni enak!");			
				return false;
			}
			
			if(!prejsnjiBlok.getHash().equals(trenutniBlok.izracunHash()) ) {
				System.out.println("prejsnji hash ni enak!");
				return false;
			}
		}
		return true;
	}
	
	public void test () {
		MojNode n = new MojNode();
		n.sestavi();
	}
}

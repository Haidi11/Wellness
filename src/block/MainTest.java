package block;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class MainTest {
	public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
	public static int tezavnost = 1;
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
	
		blockchain.add(new Block("Hi im the first block", "0"));
		System.out.println("Trying to Mine block 1... ");
		blockchain.get(0).rudarjenjeBloka(tezavnost);
		
		blockchain.add(new Block("Yo im the second block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 2... ");
		blockchain.get(1).rudarjenjeBloka(tezavnost);
		
		blockchain.add(new Block("Hey im the third block",blockchain.get(blockchain.size()-1).hash));
		System.out.println("Trying to Mine block 3... ");
		blockchain.get(2).rudarjenjeBloka(tezavnost);	
		
		System.out.println("\nBlockchain is Valid: " + validacija());
		
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
			
			if(!trenutniBlok.hash.equals(trenutniBlok.izracunHash()) ){
				System.out.println("Trenutni hash ni enak!");			
				return false;
			}
			
			if(!prejsnjiBlok.hash.equals(trenutniBlok.izracunHash()) ) {
				System.out.println("prejsnji hash ni enak!");
				return false;
			}
		}
		return true;
	}
}

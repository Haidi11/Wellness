package block;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
	
	private String podatek;
	String hash;
	private String prejsnjiHash;
	private long timeStamp;
	private int nonce;
	
	public Block (String podatek, String prejsnjiHash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.podatek = podatek;
		this.hash = izracunHash();
		this.prejsnjiHash = prejsnjiHash;
		this.timeStamp = new Date().getTime();
	}
	
	public String izracunHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String izracunanHash = Podpis.generiranjePodpisa(prejsnjiHash + Long.toString(timeStamp)+podatek);
		return izracunanHash;
	}
	
	public void rudarjenjeBloka(int tezavnost) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String tarca = new String(new char[tezavnost]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, tezavnost).equals(tarca)) {
			nonce ++;
			hash = izracunHash();
		}
		System.out.println("Rudarjenje uspelo!!! : " + hash);
	}
	
	public String getPodatek() {
		return podatek;
	}
	public void setPodatek(String podatek) {
		this.podatek = podatek;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPrejsnjiHash() {
		return prejsnjiHash;
	}
	public void setPrejsnjiHash(String prejsnjiHash) {
		this.prejsnjiHash = prejsnjiHash;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}

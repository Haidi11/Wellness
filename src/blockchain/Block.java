package blockchain;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
	
	private String podatek;
	private String hash;
	private String prejsnjiHash;
	private long timeStamp;
	
	public Block (String podatek, String hash, String prejsnjiHash) {
		this.podatek = podatek;
		this.hash = hash;
		this.prejsnjiHash = prejsnjiHash;
		this.timeStamp = new Date().getTime();
	}
	
	public String izracunHasha() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String izracunanHash = Podpis.generiranjePodpisa(prejsnjiHash + Long.toString(timeStamp)+podatek);
		return izracunanHash;
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

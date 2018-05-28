package block;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
	
	private int idTocke;
	private int idDogodek;
	private int idOSeba;
	private String podatek;
	String hash;
	private String prejsnjiHash;
	private long timeStamp;
	private int nonce;
	
	public Block() {}
	
	public Block (int id, int idOseba, int idDogodek, String prejsnjiHash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.idTocke = id;
		this.idOSeba = idOseba;
		this.idDogodek = idDogodek;
		this.hash = izracunHash();
		this.prejsnjiHash = prejsnjiHash;
		this.timeStamp = new Date().getTime();
	}
	
	public String pretvorbaVString(int id, int idDogodek, int idOseba) {
		return "Id: "+id+", id Dogodka: "+idDogodek+", id Osebe: "+idOseba;
	}
	
	public String izracunHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String izracunanHash = Podpis.generiranjePodpisa(prejsnjiHash + Long.toString(timeStamp)+Long.toString(idTocke)+Long.toString(idOSeba)+Long.toString(idDogodek));
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

	public int getIdTocke() {
		return idTocke;
	}

	public void setIdTocke(int idTocke) {
		this.idTocke = idTocke;
	}

	public int getIdDogodek() {
		return idDogodek;
	}

	public void setIdDogodek(int idDogodek) {
		this.idDogodek = idDogodek;
	}

	public int getIdOSeba() {
		return idOSeba;
	}

	public void setIdOSeba(int idOSeba) {
		this.idOSeba = idOSeba;
	}
}

package block;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Block {
	
	@Id
	@GeneratedValue
	private int idBlock;
	private int stTock;
	private int idDogodek;
	private int idOseba;
	private String hash;
	private String prejsnjiHash;
	private long timeStamp;
	
	public Block() {}
	
	public Block (int id, int idOseba, int idDogodek, String prejsnjiHash) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.stTock = id;
		this.idOseba = idOseba;
		this.idDogodek = idDogodek;
		this.hash = izracunHash();
		this.prejsnjiHash = prejsnjiHash;
		this.timeStamp = new Date().getTime();
	}
	
	public String izracunHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String izracunanHash = Podpis.generiranjePodpisa(prejsnjiHash + Long.toString(timeStamp)+Long.toString(stTock)+Long.toString(idOseba)+Long.toString(idDogodek));
		return izracunanHash;
	}
	
	public void rudarjenjeBloka(int tezavnost) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String tarca = new String(new char[tezavnost]).replace('\0', '0'); //Create a string with difficulty * "0" 
		while(!hash.substring( 0, tezavnost).equals(tarca)) {
			hash = izracunHash();
		}
		System.out.println("Rudarjenje uspelo!!! : " + hash);
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

	public int getIdDogodek() {
		return idDogodek;
	}

	public void setIdDogodek(int idDogodek) {
		this.idDogodek = idDogodek;
	}

	public int getIdOseba() {
		return idOseba;
	}

	public void setIdOSeba(int idOSeba) {
		this.idOseba = idOSeba;
	}

	public int getIdBlock() {
		return idBlock;
	}

	public void setIdBlock(int idBlock) {
		this.idBlock = idBlock;
	}

	public int getStTock() {
		return stTock;
	}

	public void setStTock(int stTock) {
		this.stTock = stTock;
	}
}

package orodja;

public class Oddelek {
	private String oddelek="";
	private int steviloOseb=0;
	
	public Oddelek(String novi) {
		
		this.oddelek=novi;
		plusEna();
		
	}

	public void plusEna() {
		steviloOseb++;
		
	}

	public String getOddelek() {
		return oddelek;
	}

	public void setOddelek(String oddelek) {
		this.oddelek = oddelek;
	}

	public int getSteviloOseb() {
		return steviloOseb;
	}

	public void setSteviloOseb(int steviloOseb) {
		this.steviloOseb = steviloOseb;
	}
	
	
	
}

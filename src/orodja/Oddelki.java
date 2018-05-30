package orodja;

import java.util.ArrayList;
import java.util.List;

import vao.Dogodek;
import vao.Oseba;

public class Oddelki {

	List<Oddelek> oddelki = new ArrayList<>();
	
	public String getStevila() {
		String temp="";
		for(Oddelek o : oddelki) {
			temp+=o.getSteviloOseb() + ", ";
			
		}
		
		return temp;
	}
public String getOddelki() {
	String temp="";
	for(Oddelek o:oddelki) {
		temp+="'" + o.getOddelek() + "', ";
		
	}
	return temp;
	
}
	public Oddelki(Dogodek d) {

		for (Oseba o : d.getUdelezenci()) {
			if (!vsebuje(o)) {
				oddelki.add(new Oddelek(o.getOddelek()));
			}

		}

	}

	private boolean vsebuje(Oseba os) {
		for (Oddelek o : oddelki) {
			if (o.getOddelek().equals(os.getOddelek())) {
				o.plusEna();
				return true;
			}

		}

		return false;

	}
}

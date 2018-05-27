package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import orodja.PaketZaprikazDogodkov;
import vao.Dogodek;
import vao.Oseba;

@Local
public interface DogodekVmesnik {
	void dodajDogodek(Dogodek dogodek);
	void odstraniDogodek(Dogodek dogodek);
	ArrayList<Dogodek> sezamDogodkov();
	void podrobnoDogodek(Dogodek dogodek);
	void izberiDogodek(Dogodek d, String uporabniskoIme);
	Oseba najdiPoUporabniskemImenu(String u);
	PaketZaprikazDogodkov sezamDogodkovZaUporabnika(String name);
}

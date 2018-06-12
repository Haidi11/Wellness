package vmesniki;

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
	Dogodek podrobnoDogodek(int dogodek);
	void podrobnoDogodek(Dogodek dogodek);
	void izberiDogodek(Dogodek d, String uporabniskoIme);
	Oseba najdiPoUporabniskemImenu(String u);
	PaketZaprikazDogodkov sezamDogodkovZaUporabnika(String name);
	List<Dogodek> vrniMojeDogodke(int id);
	Dogodek dogodek(int idDogodek);
	List<Oseba> vrniMojeUdelezence(int idDogodek);
	Dogodek vrniMojDogodek(int idDogodek);
	void potrdiUdelezbo(Dogodek izbranDogodek, Oseba o);
	void shraniObvestilo(int idOseba, int idDogodek);
	List<Dogodek> vrniNoveDogodke();

}

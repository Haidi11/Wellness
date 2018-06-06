package vmesniki;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import orodja.PaketZaPrikazNasvetov;
import vao.Nasvet;
import vao.Oseba;

@Local
public interface NasvetVmesnik {

	void brisiNasvet(Nasvet nasvet);

	void urediNasvet(int id, String popravljenNasvet);

	ArrayList<Nasvet> seznamVsehNasvetov();

	PaketZaPrikazNasvetov sezamDogodkovZaUporabnika(int id);

	List<Nasvet> getNasveteAvtorja(int id);

	int najdiIdAvtorja(String ime);

	void dodajNasvet(Nasvet nasvet);

	void dodajUrejenNasvet(Nasvet n);
	
	


}

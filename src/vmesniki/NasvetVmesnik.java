package vmesniki;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import orodja.PaketZaPrikazNasvetov;
import vao.Nasvet;
import vao.Oseba;

@Local
public interface NasvetVmesnik {
	void dodajNasvet(Nasvet nasvet);
	void brisiNasvet(Nasvet nasvet);
	void urediNasvet(Nasvet nasvet);
	ArrayList<Nasvet> seznamVsehNasvetov();
	PaketZaPrikazNasvetov sezamDogodkovZaUporabnika(int id);
	Nasvet najdiPoIdAvtorja(int id);
	List<Nasvet> getNasveteAvtorja(int id);
}

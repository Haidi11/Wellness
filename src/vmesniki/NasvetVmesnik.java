package vmesniki;


import java.util.ArrayList;

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
	Oseba najdiPoIdAvtorja(int id);
}

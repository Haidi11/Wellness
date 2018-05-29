package vmesniki;


import java.util.ArrayList;

import javax.ejb.Local;

import vao.Nasvet;

@Local
public interface NasvetVmesnik {
	void dodajNasvet(Nasvet nasvet);
	void brisiNasvet(Nasvet nasvet);
	void urediNasvet(Nasvet nasvet);
	ArrayList<Nasvet> seznamVsehNasvetov();
}

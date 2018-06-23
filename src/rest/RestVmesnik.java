package rest;

import javax.ejb.Local;

@Local
public interface RestVmesnik {

	int pridobiTocke(int id);
	void dodeliTocke(int id, int naloga);
	Naloge pridobiCakajoceOdobritve(int id);
	int pridobiTocke(int id, int storitev);
	
	
}

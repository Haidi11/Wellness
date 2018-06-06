package vmesniki;

import vao.Oseba;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OsebaVmesnik {

    void dodajOsebo(Oseba o);
    void odstraniOsebo(Oseba o);
    List<Oseba> vrniSeznamVsehOseb();
    List<Oseba> topUporabnik(); 
    List<Oseba> topMesecniUporanbik();
	Oseba najdiPoId(int id);
	boolean jeZasedeno(String o);
	void shraniUrejenoOsebo(Oseba oseba); 
	List<Oseba> vrniOsebeOddelek(String data); 
}

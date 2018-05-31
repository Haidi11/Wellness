package vmesniki;

import vao.Oseba;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OsebaVmesnik {

    void dodajOsebo(Oseba o);
    void odstraniOsebo(Oseba o);
    List<Oseba> vrniSeznamVsehOseb();
    Oseba topUporabnik(); 
    Oseba topMesecniUporanbik(); 
}

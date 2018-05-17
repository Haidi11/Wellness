package jsf;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.OsebaVmesnik;
import vao.Oseba;

@ManagedBean(name="osebe")
@SessionScoped
public class Osebe {

	@EJB
	OsebaVmesnik ejb;

	private Oseba novaOseba= new Oseba();
	
	public List<Oseba> vrniVseOsebe(){
		
		return ejb.vrniSeznamVsehOseb();
	}
	public void dodajOsebo() {
		ejb.dodajOsebo(novaOseba);
		
	}
	
	
	
}

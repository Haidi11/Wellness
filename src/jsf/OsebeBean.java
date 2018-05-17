package jsf;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.OsebaVmesnik;
import vao.Oseba;

@ManagedBean(name="osebe")
@SessionScoped
public class OsebeBean {

	@EJB
	OsebaVmesnik ejb;

	private Oseba novaOseba= new Oseba();
	
	public List<Oseba> getVrniVseOsebe(){
		
		return ejb.vrniSeznamVsehOseb();
	}
	public void dodajOsebo(String ime, String priimek, String email, boolean organizator, String spol, int tocke) {
		novaOseba.setIme(ime);
		novaOseba.setPriimek(priimek);
		novaOseba.setEmail(email);
		novaOseba.setOrgaizatorDoodkov(organizator);
		novaOseba.setSpol(spol);
		novaOseba.setTocke(0);
		ejb.dodajOsebo(novaOseba);	
	}
}

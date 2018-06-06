package jsf;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import vao.Oseba;
import vmesniki.BlockChainVmesnik;
import vmesniki.DogodekVmesnik;
import vmesniki.NasvetVmesnik;
import vmesniki.OsebaVmesnik;

@ManagedBean(name = "profil")
@RequestScoped
public class ProfilUporabnikaModel {
	ZaposleniModel zd = new ZaposleniModel();
	Oseba oseba;
	
	@EJB
	NasvetVmesnik nv;
	
	@EJB
	OsebaVmesnik ov;
	
	@EJB
	DogodekVmesnik dv;
	
	private Principal vrniUporabnika() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}
	
	
	@PostConstruct
	public void podatkiOsebe() {
		oseba =  dv.najdiPoUporabniskemImenu(vrniUporabnika().getName());
	}
	
	public void shraniUrejenoOseno( ) {
		ov.shraniUrejenoOsebo(oseba);
	}


	public Oseba getOseba() {
		return oseba;
	}

	public void setOseba(Oseba oseba) {
		this.oseba = oseba;
	}
}

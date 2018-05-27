package jsf;

import java.security.Principal;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.jboss.security.auth.spi.Users;
import org.wildfly.security._private.ElytronMessages;
import org.wildfly.security.auth.util.ElytronAuthenticator;
import org.wildfly.security.permission.ElytronPermission;

import ejb.DogodekVmesnik;
import vao.Dogodek;

@ManagedBean(name = "zaposleni")
@SessionScoped
public class ZaposleniModel {
	
	
	@EJB
	DogodekVmesnik dv;
	
	//uporabnik izbere dogodek, ta se doda na njegov seznam dogodkov
	public void izberiDogodek(Dogodek d) {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		Principal p = fc.getExternalContext().getUserPrincipal();
//		System.out.println(p.getName());
		dv.izberiDogodek(d, p.getName());
		
		
		
	}

}

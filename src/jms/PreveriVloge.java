package jms;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import jsf.ProfilUporabnikaModel;
import vao.Oseba;
import vmesniki.DogodekVmesnik;

@ManagedBean(name = "vlogaUporabnika")
@SessionScoped
public class PreveriVloge {
	Oseba oseba;
	private String vloga;

	@EJB
	DogodekVmesnik dv;

	private Principal vrniUporabnika() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getUserPrincipal();
	}

	@PostConstruct
	public void podatkiOsebe() {
		oseba = dv.najdiPoUporabniskemImenu(vrniUporabnika().getName());
		vloga = vlogaOsebe(oseba);
		if (vloga.equals("kadrovska")) {
			vloga = "<li><a href=\"zaposleni.xhtml\" id=\"about-link\"	class=\"skel-layers-ignoreHref\"><span class=\"icon fa-user\">Dodaj	Uporabnika</span></a></li>\r\n";
		} else if (vloga.equals("organizator")) {
			vloga = "<li><a href=\"dodajTekmovanje.xhtml\" id=\"portfolio-link\"class=\"skel-layers-ignoreHref\"><span class=\"icon fa-th\">Dodaj tekmovanja</span></a></li>"
					+ "<li><a href=\"dodajDogodek.xhtml\" id=\"portfolio-link\" class=\"skel-layers-ignoreHref\"><span class=\"icon fa-th\">Dodaj dogodek</span></a></li>"
					+ "<li><a href=\"mojiDogodki.xhtml\" id=\"portfolio-link\" class=\"skel-layers-ignoreHref\"><span class=\"icon fa-th\">Moji dogodki</span></a></li>";

		}
		
		else if (vloga.equals("zaposleni")) {
			vloga="";
		}

	}

	public String vlogaOsebe(Oseba oseba) {
		String vloga = oseba.getVloga();
		return vloga;
	}

	/*
	 * public String dodajDogodke() { String vloga = vloga;
	 * if(vloga.equals("kadrovska")) { return "dodajDogodek.xhtml"; }else { return
	 * "index.html"; } }
	 * 
	 * 
	 * public String mojiDogodki() { String vloga = vlogaOsebe();
	 * if(vloga.equals("uporabnik")) { return "mojiDogodki.xhtml"; }else { return
	 * "index.html"; } }
	 * 
	 * public String dodajTekmovanja() { String vloga = vlogaOsebe();
	 * if(vloga.equals("organizator")) { return "dodajTekmovanje.xhtml"; }else {
	 * return "index.html"; } }
	 * 
	 * public String dodajanjeUporabnika() { String vloga = vlogaOsebe();
	 * if(vloga.equals("kadrovska")) { return "zaposleni.xhtml"; }else
	 * if(vloga.equals("organizator")) { return "zaposleni.xhtml"; }else { return
	 * "index.html"; } }
	 */

	public String getVloga() {
		return vloga;
	}

	public void setVloga(String vloga) {
		this.vloga = vloga;
	}
}

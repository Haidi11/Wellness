package validatorji;

import java.security.Principal;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
			vloga = kadrovska();
		} else if (vloga.equals("organizator")) {
			vloga = organizator();

		}
		
		else if (vloga.equals("zaposleni")) {
			vloga="";
		}
		else if (vloga.equals("admin")) {
			vloga = organizator();
			vloga += kadrovska();
		}

	}
	
	private String kadrovska() {
		return "<li><a href=\"zaposleni.xhtml\" id=\"about-link\"	class=\"skel-layers-ignoreHref\"><span class=\"icon fa-user\">Dodaj	Uporabnika</span></a></li>\r\n";
		
	}
	private String organizator() {
		return "<li><a href=\"dodajTekmovanje.xhtml\" id=\"portfolio-link\"class=\"skel-layers-ignoreHref\"><span class=\"icon fa-th\">Dodaj tekmovanja</span></a></li>"
				+ "<li><a href=\"dodajDogodek.xhtml\" id=\"portfolio-link\" class=\"skel-layers-ignoreHref\"><span class=\"icon fa-th\">Dodaj dogodek</span></a></li>"
				+ "<li><a href=\"mojiDogodki.xhtml\" id=\"portfolio-link\" class=\"skel-layers-ignoreHref\"><span class=\"icon fa-th\">Moji dogodki</span></a></li>";
	}

	public String vlogaOsebe(Oseba oseba) {
		String vloga = oseba.getVloga();
		return vloga;
	}

	public String getVloga() {
		return vloga;
	}

	public void setVloga(String vloga) {
		this.vloga = vloga;
	}
}

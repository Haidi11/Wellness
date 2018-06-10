package validatorji;



import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import vmesniki.OsebaVmesnik;

@ManagedBean(name = "PreveriUporabniskoIme")
@SessionScoped
public class PreveriUporabniskoIme implements Validator {

	@EJB
	OsebaVmesnik ov;
	
	public void validate(FacesContext fc, UIComponent c, Object o) throws ValidatorException {
		// preveri ce je prazno
		if (o == null || "".equals((String) o)) {
			FacesMessage msg = new FacesMessage("Prosim vnesite uporabniško ime osebe v podjetju");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		
		if(ov.jeZasedeno((String) o)) {
			FacesMessage msg = new FacesMessage("Uporabniško ime je zasedeno");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
			
		}
	}
}

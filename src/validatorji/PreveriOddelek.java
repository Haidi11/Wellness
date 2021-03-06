package validatorji;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "PreveriOddelek")
@SessionScoped
public class PreveriOddelek {

	
	public void validate(FacesContext fc, UIComponent c, Object o) throws ValidatorException {
		// preveri ce je prazno
		if (o == null || "".equals((String) o)) {
			FacesMessage msg = new FacesMessage("Prosim izberite oddelek");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		
		
	}
	
}

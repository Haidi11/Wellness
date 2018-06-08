package jsf;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "passwordValidator")
@SessionScoped
public class PasswordValidator implements Validator {

    // Actions ------------------------------------------------------------------------------------

    public void validate(FacesContext context, UIComponent component, Object value)
        throws ValidatorException
    {
        
        String password = (String) value;

        // pridobi drugo geslo
        UIInput confirmComponent = (UIInput) component.getAttributes().get("confirm");
        String confirm = (String) confirmComponent.getSubmittedValue();

        // ce je prazno
        if (password == null || password.isEmpty() || confirm == null || confirm.isEmpty()) {
            return; // Let required="true" do its job.
        }

        // primerjaj geslo 
        if (!password.equals(confirm)) {
            confirmComponent.setValid(false); //nastavi na nepravilno
            throw new ValidatorException(new FacesMessage("Gesli se ne ujemata"));
        }

        
    }

}
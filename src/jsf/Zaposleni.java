package jsf;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jboss.security.auth.spi.Users;

@ManagedBean(name = "index")
@SessionScoped
public class Zaposleni {
	@Resource
	SessionContext s;
	
	

}

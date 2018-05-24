package jsf;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.jboss.security.auth.spi.Users;
import org.wildfly.security._private.ElytronMessages;
import org.wildfly.security.auth.util.ElytronAuthenticator;
import org.wildfly.security.permission.ElytronPermission;

@ManagedBean(name = "index")
@SessionScoped
public class Zaposleni {
	@Resource
	SessionContext s;
	
	public void test() {
	
		
	}

}

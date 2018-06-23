package rest;


import javax.ejb.Stateless;
import javax.json.bind.Jsonb; 
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

@Stateless
public class Rest implements RestVmesnik{
	private static String url = ".....";

	ResteasyWebTarget rt = (ResteasyWebTarget) ClientBuilder.newClient().target(url);
	VerigaBlokovVmesnik cv = rt.proxy(VerigaBlokovVmesnik.class);
	
	
	@Override
	public int pridobiTocke(int id) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void dodeliTocke(int id, int naloga) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Naloge pridobiCakajoceOdobritve(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int pridobiTocke(int id, int storitev) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
	
	
}
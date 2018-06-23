package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface VerigaBlokovVmesnik { //ki ga morejo se definirat 
	
	@GET
	@Path("/oseba/{id}")
	public Response pridobiTocke(@PathParam("id") int id);
	
	@POST
	@Path("/tocke")
	public Response dodeliTocke(int id,int naloga);
	
	@GET
	@Path("/odobritve")
	public Response pridobiCakajoceOdobritve(int id);
	
	@GET
	@Path("/storitev")
	public Response pridobiTocke(int id, int storitev);

}

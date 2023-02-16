package rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



@Path("greetings")
public class HelloRessources {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayhello(@QueryParam(value = "LastName" )String nom , @QueryParam(value = "FirstName") String lnom  ) {
		return "hello  " +nom +" " + lnom;
		
	}
	

}

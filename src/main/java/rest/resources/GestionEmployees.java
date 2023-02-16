package rest.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import rest.entities.Employees;

@Path("/emp")
@Api
public class GestionEmployees {
	
public  List<Employees> emplpyoees = new ArrayList<Employees>();

 public GestionEmployees() {
	// TODO Auto-generated constructor stub
	 emplpyoees.add(new Employees("test","jhghjgj","hgfhgjh"));
	 emplpyoees.add(new Employees("azertyu","hola","dfgh"));
}


	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
		public Response ajouterEmployer(Employees emp) {
			if (this.emplpyoees.add(emp))
			return Response.status(Status.CREATED).entity("add successful").build();
			
			return Response.status(Status.NOT_FOUND).entity("add failed").build();
		}
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get all")
	@ApiResponses({
		@ApiResponse(code = 200,message = "success")
	})
	public Response displayEmployeesList() {
		if(emplpyoees.size()!=0)
			return Response.status(Status.OK).entity(emplpyoees).build();

		return Response.status(Status.NOT_FOUND).entity("la liste not found").build();
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/getx")
	public List<Employees> displayEmployeesListxm() {
		return emplpyoees;
	}
	
	 @DELETE
	 @Produces(MediaType.APPLICATION_JSON)
	    @Path("/employe/{cin}")
	   public Response deleteEmployee(@PathParam("cin") String cin) {
		 
	    	   for(Employees E:emplpyoees) {
	    		   if(E.getCin().equals(cin)) {
	    			   emplpyoees.remove(E);
	    			   return Response.status(Status.FOUND).entity(emplpyoees).build(); 
	    		   }}
	    		   return Response.status(Status.NOT_FOUND).entity(false).build(); 
	    	   
	    		
	    }
	    @PUT
		@Consumes(MediaType.APPLICATION_XML)
	    //@Produces(MediaType.APPLICATION_ATOM_XML)
		public Response updateEmployee(Employees E) {
			int index = getIndexById(E.getCin());

			if (index != -1) {
				emplpyoees.set(index, E);
				return Response
				.status(200)
				.entity("update successful")
				.build();
			}else
			return Response
					.status(200)
					.entity("update unsuccessful")
					.build();
		}
		public int getIndexById(String cin) {
			for (Employees E : this.emplpyoees) {
				if (E.getCin().equals(cin))
					return this.emplpyoees.indexOf(E);
			}
			return -1;
		}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{ciin}")
	public Response searchEmployee(@PathParam("ciin")String cin)
	{
		for(Employees e: emplpyoees) {
			if(e.getCin().equals(cin)) {
				return Response.status(Status.FOUND).entity(e).build();}
			}
		return Response.status(Status.NOT_FOUND).entity("n'existe pas").build();
		}
	}


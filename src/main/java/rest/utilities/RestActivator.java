package rest.utilities;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import io.swagger.jaxrs.config.BeanConfig;
import rest.resources.GestionEmployees;



@ApplicationPath("rest")
public class RestActivator extends Application {
	 public RestActivator() {
		// TODO Auto-generated constructor stub
	
		  super();
		 
		  BeanConfig beanConfig = new BeanConfig();
		  beanConfig.setVersion("1.0.2");
		  beanConfig.setSchemes(new String[]{"http"});
		  beanConfig.setHost("localhost:8990");
		  beanConfig.setBasePath("Hellojax/rest");
		  beanConfig.setResourcePackage("io.swagger.resources");
		  beanConfig.setResourcePackage("rest.resources");
		  beanConfig.setScan(true);
		}
	 
	 
	 @Override
	 public Set<Class<?>> getClasses() {
	 Set<Class<?>> resources = new HashSet<>();
	 resources.add(GestionEmployees.class);
	 //resources.add(SecondResource.class);

	 resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
	 resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
	 return resources;
	 }

}

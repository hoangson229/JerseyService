package jerseyExample;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dto.User;

@Path("/test")
public class JerseyService {
	final static Logger LOGGER = Logger.getLogger(JerseyService.class.getName());

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}

	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDashboardInfo() throws Exception {

		LOGGER.info("START");

		User user = new User("sonhv", "Hoang Van Son", "0962209955");

		LOGGER.info("END");
		return Response.status(200).entity(user).build();
	}
}

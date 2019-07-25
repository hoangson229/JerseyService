package sonhv.com.service;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import sonhv.com.entity.Book;
import sonhv.com.entity.UserEntity;
import sonhv.com.hibernate.HibernateUtils;

@Path("/test")
public class JerseyService {
	final static Logger LOGGER = Logger.getLogger(JerseyService.class.getName());

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/user")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDashboardInfo() throws Exception {

		LOGGER.info("START");
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();

		List<UserEntity> employees = null;
		List<Book> books = null;
		

		try {

			session.getTransaction().begin();

			String sql = "Select  e from Book e where bookId = 1";

			// Tạo đối tượng Query.
			Query query = session.createQuery(sql);

			// Thực hiện truy vấn.
			books = query.getResultList();

			// UserDTO user = new UserDTO("sonhv", "Hoang Van Son",
			// "0962209955");

			LOGGER.info("END");

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
		}

		return Response.status(200).entity(books).build();

	}

}

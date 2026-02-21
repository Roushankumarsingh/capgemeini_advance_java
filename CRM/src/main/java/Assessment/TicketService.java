package Assessment;
import javax.persistence.*;
import java.util.*;

public class TicketService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ;
	public void register(SupportTicket st) {
		et.begin() ;
		em.persist(st);
		et.commit();
//		em.clear();
		em.close();
		emf.close();
		System.out.println("Inserted");
	}
}

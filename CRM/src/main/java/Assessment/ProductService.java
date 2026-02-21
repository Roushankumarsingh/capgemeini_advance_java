package Assessment;
import javax.persistence.*;
import java.util.*;

public class ProductService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ;
	public void register(Product p) {
		et.begin() ;
		em.persist(p);
		et.commit();
//		em.clear();
		em.close();
		emf.close();
		System.out.println("Inserted");
	}
}

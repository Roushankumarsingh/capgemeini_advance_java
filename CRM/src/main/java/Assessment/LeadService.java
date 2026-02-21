package Assessment;
import javax.persistence.*;
import java.util.*;

public class LeadService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ;
	public void register(Lead l) {
		et.begin() ;
		em.persist(l);
		et.commit();
//		em.clear();
		em.close();
		emf.close();
		System.out.println("Inserted");
	}
	public void update(int id , List<SalesEmployee> list ) {
		Lead l = em.find(Lead.class, id) ;
		if(l != null) {
			et.begin();
			l.setList(list);
			em.merge(l) ; 
			et.commit();
			System.out.println("Updated");
		}
	}
}

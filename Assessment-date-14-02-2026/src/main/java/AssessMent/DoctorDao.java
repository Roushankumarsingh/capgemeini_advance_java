package AssessMent;
import javax.persistence.*;

public class DoctorDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager()  ; 
	EntityTransaction et = em.getTransaction() ; 
	public void saveDoctor(Doctor d) {
		et.begin(); 
		em.persist(d);
		et.commit(); 
	}
	public Doctor findDoctor(int id) {
		Doctor d = em.find(Doctor.class, id) ;
		return d ;
	}
}

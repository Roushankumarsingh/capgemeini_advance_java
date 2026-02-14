package AssessMent;
import javax.persistence.*;

public class PatientDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ;
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ;
	public void savePatient(Patient p , MedicalRecord m) {
		et.begin(); 
		em.persist(p);
		em.persist(m);
		et.commit() ;
	}
	public void findPatient(int id) {
		Patient p = em.find(Patient.class, id) ;
		if(p != null) {
			System.out.println(p);
		}else {
			System.out.println("Null no object is there"); 
		}
	}
	public void updatePatient(int id , String contact) {
		Patient p = em.find(Patient.class, id) ; 
		if(p != null) {
			p.setContact(contact);
			et.begin(); 
			em.merge(p) ;
			et.commit(); 
			System.out.println("Updated");
		}
		else {
			System.out.println("Null");
		}
	}
	public void deletePatient(int id) {
		Patient p = em.find(Patient.class, id) ;
		if(p != null) {
			et.begin();
			String jpql = "update appointment set p_pid = NULL where p_pid = ?1" ; 
			Query query = em.createNativeQuery(jpql) ;
			query.setParameter(1, id) ; 
			query.executeUpdate() ; 
			p.setMedical(null);
			em.remove(p);
			et.commit();
		}
		else {
			System.out.println("Patient not found");
		}
	}
}

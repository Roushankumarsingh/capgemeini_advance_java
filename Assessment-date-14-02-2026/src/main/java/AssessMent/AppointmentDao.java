package AssessMent;
import javax.persistence.*;
import java.util.*;

public class AppointmentDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager()  ; 
	EntityTransaction et = em.getTransaction() ; 
	public void saveAppoint(Appointment a) {
		et.begin() ; 
		em.persist(a);
		et.commit() ; 
	}
	public void findAppointment(int id) {
		String sql = "select list_aid from doctor_appointment where doctor_id = ?1" ; 
		et.begin(); 
		Query query = em.createNativeQuery(sql) ; 
		query.setParameter(1,id) ;
		List<Integer> ids = query.getResultList() ; 
			String jpql = "select a from Appointment a where a.aid = ?1" ; 
			Query query1 = em.createQuery(jpql) ;
			query1.setParameter(1,ids.get(0)) ; 
			List<Appointment> list = query1.getResultList() ;
			for(Appointment ap : list) {
				System.out.println(ap);
			}
		et.commit(); 
	}
	public void updateFee(int id , double fee) {
		Appointment ad = em.find(Appointment.class, id) ; 
		et.begin();  
		ad.setFee(fee);
		em.merge(ad) ;
		et.commit(); 
	}
}

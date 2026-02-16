package Assessment;
import javax.persistence.*;

public class UserMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction() ;
		Passport p = new Passport() ; 
		p.setDob("24-02-2003");
		p.setName("Miller");
		p.setId(101); 
		
		Person person = new Person() ; 
		person.setEmail("abc@gmail.com");
		person.setName("Allen");
		person.setPhone("987654");
		person.setP(p); 
		p.setP(person);
		et.begin();  
		em.persist(person) ; 
		et.commit(); 
	}
}

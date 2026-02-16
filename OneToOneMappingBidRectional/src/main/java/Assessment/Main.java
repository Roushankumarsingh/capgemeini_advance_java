package Assessment;

import javax.persistence.*;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction() ;
		Passport p = em.find(Passport.class, 101) ; 
		System.out.println(p);
		System.out.println(p.getP());
	}
}

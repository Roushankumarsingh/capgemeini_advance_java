package ManyPack;

import javax.persistence.*; 


public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction(); 
//		Department d = new Department() ; 
//		d.setDid(1002);
//		d.setDname("Engineers");
//		d.setMname("Mukesh");
//		d.setEmpno(250);
//		et.begin(); 
//		em.persist(d);
//		et.commit();
		Employee e = new Employee() ; 
		Department d = em.find(Department.class, 1002) ; 
		e.setDepart(d);
		e.setEdesign("MEC");
		e.setEid(103);
		e.setEname("Roushan"); 
		e.setEsalary(300000.0);
		et.begin();  
		em.persist(e) ;
		et.commit(); 
		
	}
}

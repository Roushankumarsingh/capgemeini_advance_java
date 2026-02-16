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
//		Employee e = new Employee() ; 
//		Department d = em.find(Department.class, 1002) ; 
//		e.setDepart(d);
//		e.setEdesign("MEC");
//		e.setEid(103);
//		e.setEname("Roushan"); 
//		e.setEsalary(300000.0);
//		et.begin();  
//		em.persist(e) ;
//		et.commit(); 
		Department d = new Department() ; 
//		d.setDid(1005);
		d.setDname("DEv");
		d.setEmpno(150);
		d.setMname("Allen");
		Employee e1 = new Employee() ; 
		e1.setDepart(d);
		e1.setEdesign("ASE");
//		e1.setEid(106);
		e1.setEname("Harsha bandra");
		e1.setEsalary(12000.0);
		Employee e2 = new Employee();
		e2.setDepart(d);
		e2.setEdesign("Analyst");
		e2.setEsalary(1200.0);
		e2.setEname("Yusuf");
//		e2.setEid(107);
		et.begin();   
		em.persist(d);
		em.persist(e2);
		em.persist(e1);
		et.commit();
	}
}

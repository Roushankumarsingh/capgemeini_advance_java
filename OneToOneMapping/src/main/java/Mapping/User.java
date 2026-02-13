package Mapping;

import javax.persistence.Persistence;
import javax.persistence.*;
import java.util.*;
public class User {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ;
	EntityManager em = emf.createEntityManager() ;  
	EntityTransaction et = em.getTransaction() ; 
	public void findByCarId() {
		Car c = em.find(Car.class,102) ;
		System.out.println(c);
	}
	public void updateCar() {
		Car c = em.find(Car.class, 102) ; 
		c.setColor("Black") ; 
		c.setModelYear("2025");
		et.begin();
		em.merge(c); 
		et.commit();
	}
	public void insertCarAndEngine(String[] args) {
		
		
		Engine e = new Engine() ; 
		e.setId(101);
		e.setType("V8");
		e.setFuelType("Petrol");
		e.setMileage("12");
		e.setCc("3000") ; 
		
		Car c = new Car() ; 
		c.setId(102);
		c.setBrand("Volswagen"); 
		c.setModel("Polo GT10");
		c.setPrice(100000.0);
		c.setEngine(e); 
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
		
	}
	public void deleteEngine() {
		Engine e = em.find(Engine.class, 101) ; 
		String jqpl = "select c from Car c where c.engine.id = ?1" ; 
		Query query = em.createQuery(jqpl) ;
		query.setParameter(1, 101) ;
		List<Car> list = query.getResultList() ; 
		for(Car c : list) {
			c.setEngine(null);
		}
		et.begin();
		em.remove(e); 
		et.commit();
	}
	public static void main(String[] args) {
		User u = new User()  ; 
//		u.findByCarId();
//		u.updateCar();
		u.deleteEngine();
	}
}

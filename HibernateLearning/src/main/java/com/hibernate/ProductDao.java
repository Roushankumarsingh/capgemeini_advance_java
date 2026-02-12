package com.hibernate;
import java.util.*; 
import javax.persistence.*; 

public class ProductDao {
	public String insertData(Product p) {
		Scanner sc = new Scanner(System.in) ; 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres")  ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction(); 
		if(p != null) {
			et.begin() ; 
			em.persist(p); 
			et.commit(); 
			emf.close(); 
			return "Data inserted" ; 
		}
		else {
			return "Data cannot be inserted" ; 
		}
	}
	public Product deleteUser(int id) {
		Scanner sc = new Scanner(System.in) ; 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres")  ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction(); 
		Product p = em.find(Product.class,id) ; 
		if(p != null) {
			et.begin();
			em.remove(p); 
			et.commit(); 
			emf.close(); 
			return p ;
		}
		else {
			return null ; // not found 
		}
		
	}
	public Product updateUser(int id , int quantity) {
		Scanner sc = new Scanner(System.in) ; 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres")  ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction(); 
		Product p = em.find(Product.class,id) ; 
		if(p != null) {
			p.setQuan(quantity);
			et.begin();
			em.merge(p); 
			et.commit(); 
			emf.close(); 
			return p ;
		}
		else {
			return null ;
		}
	}
	public Product fetchById(int id) {
		Scanner sc = new Scanner(System.in) ; 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres")  ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction(); 
		Product p = em.find(Product.class,id) ; 
		if(p != null) {
			System.out.println("Product fetched") ;
			return p ; 
		}
		else {
			System.out.println("Product is not available"); 
			return null ;
		}
	}
	public String fetchAll() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres")  ; 
		EntityManager em = emf.createEntityManager() ; 
		EntityTransaction et = em.getTransaction(); 
		String fetch = "Select p from Product p" ; 
		Query query = em.createQuery(fetch) ;
		List<Product> list = query.getResultList() ; 
		for(Product p : list) {
			System.out.println(p);
		}
		return "Records are there" ; 
	}
}

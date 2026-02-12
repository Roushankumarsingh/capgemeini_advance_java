package com.hibernate;
import javax.persistence.* ; 

public class SqlQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
		EntityManager em = emf.createEntityManager(); 
		EntityTransaction et = em.getTransaction() ; 
		String sqlQuery = "update product_table set product_price = ?1 where product_price = ?2" ;
		et.begin();  
		Query query = em.createNativeQuery(sqlQuery) ;
		query.setParameter(1, 225000.0) ; 
		query.setParameter(2, 14520.0) ; 
		query.executeUpdate() ; 
		et.commit(); 
		// To execute we can do it like 
		// query -> em.createNativeQuery -> setParamater -> optional -> query.executeUpdate 
	}
}

package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hibernate.Product;
import com.hibernate.ProductDao;

public class ProductDaoTest {
	@Test
	public void findById() {
		ProductDao p = new ProductDao() ;
		int id = 101 ; 
		Product pr = p.fetchById(id) ; 
		assertNotNull(pr) ;  // if not null simply return it 
	}
	@Test
	public void findByIdNull() {
		ProductDao p = new ProductDao() ;
		int id = 5001 ; 
		Product pr = p.fetchById(id) ; 
		assertEquals(null,pr) ;  // if not null simply return it 
	}
	@Test 
	public void updateProduct() {
		ProductDao p = new ProductDao() ; 
		int id = 101 ; 
		int quantity = 500 ; 
		Product pr = p.updateUser(id, quantity) ; 
		assertNotNull(pr) ; // if not null test for it 
	}
	@Test
	public void updateProductNot() {
		ProductDao p = new ProductDao() ; 
		int id = 4001 ; 
		int quantity = 500 ; 
		Product pr = p.updateUser(id, quantity) ; 
		assertEquals(null,pr) ; // if not null test for it 
	}
	@Test
	public void deleteProduct() {
		ProductDao p = new ProductDao() ; 
		int id = 102 ; 
		Product pr  = p.deleteUser(id) ; 
		assertNotNull(pr) ;
	}
	@Test
	public void deleteProductNull() {
		ProductDao p = new ProductDao() ; 
		int id = 4021 ; 
		Product pr  = p.deleteUser(id) ; 
		assertEquals(null,pr) ;
	}
	@Test
	public void insertUser() {
		ProductDao p = new ProductDao() ; 
		int id = 5005890 ; 
		String name = "Laptop"  ; 
		int quantity = 560 ; 
		double price = 14520 ; 
		Product pr = new Product() ; 
		pr.setId(id) ; 
		pr.setName(name); 
		pr.setPrice(price); 
		pr.setQuan(quantity); 
		String value = p.insertData(pr) ;
		assertEquals("Data inserted" , value) ; 
	}
	@Test
	public void invalidUSer() {
		ProductDao p = new ProductDao() ; 
		int id = 500 ; 
		String name = "Laptop"  ; 
		int quantity = 560 ; 
		double price = 14520 ; 
		Product pr = new Product() ; 
		pr.setId(id) ; 
		pr.setName(name); 
		pr.setPrice(price); 
		pr.setQuan(quantity); 
		String value = p.insertData(null) ;
		assertEquals("Data cannot be inserted" , value) ; 
	}
	@Test
	public void fetchAll() {
		ProductDao p = new ProductDao() ; 
		String fetched = p.fetchAll() ; 
		assertEquals("Records are there" , fetched) ;
	} 
}

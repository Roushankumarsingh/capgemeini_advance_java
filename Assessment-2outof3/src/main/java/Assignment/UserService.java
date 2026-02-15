package Assignment;
import javax.persistence.*;  

import java.util.*;


public class UserService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction();
	Scanner sc = new Scanner(System.in) ;
	UserDao ud = new UserDao() ; 
	PaymentDao pd = new PaymentDao() ; 
	OrderDao od = new OrderDao() ;
	public void RegisterUser() {
		User u = new User() ; 
		u.setEmail("abc@gmail.com");
		u.setUserId(101);
		u.setName("abc");
		Profile p = new Profile() ; 
		p.setAdd("Sasaram");
		p.setPhone("987654321");
		p.setProfileId(1001);
		List<Purchase> list = new ArrayList<>() ; 
		Purchase p1 = new Purchase() ; 
		p1.setOrderDate("27-02-2026");
		p1.setPurchaseId(10001);
		p1.setTotalAmount(2500.0);
		Purchase p2 = new Purchase() ; 
		p2.setOrderDate("14-02-2026");
		p2.setPurchaseId(10002);
		p2.setTotalAmount(1200.0);
		list.add(p1) ; 
		list.add(p2);
		u.setList(list);
		u.setP(p);
		et.begin();
		em.persist(p1); // purchase p1 
		em.persist(p2); // purchase p2 
		em.persist(p); // profile
		System.out.println(ud.saveUser(u)) ;
		et.commit();
	}
	public void addPayment() {
		Payment p = new Payment() ; 
		p.setAmount(2500.0);
		p.setPaymentId(1);
		p.setMode("UPI");
		Purchase p1 = em.find(Purchase.class, 10001) ;
		p.setP(p1);
		System.out.println(pd.savePayment(p)) ;
	}
	public void fetchUserWithOrder() {
		int id = 10001 ;
		System.out.println(od.findOrder(id));
	}
	public void deleteUser() {
		int id = 101 ; 
		System.out.println(ud.deleteUser(id));
	}
	public void updateAmount(int id,double amount) {
		Purchase p = em.find(Purchase.class, 10001) ; 
		p.setTotalAmount(amount);
		et.begin(); 
		em.merge(p);
		et.commit();
	}
}

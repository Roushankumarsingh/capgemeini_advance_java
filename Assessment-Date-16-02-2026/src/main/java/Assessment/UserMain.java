package Assessment;
import javax.persistence.*;
import java.util.*;

public class UserMain {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres") ; 
	EntityManager em = emf.createEntityManager() ; 
	EntityTransaction et = em.getTransaction() ; 
	public void insertUser() {
		Users u = new Users() ; 
		u.setEmail("abc@gmail.com");
		u.setName("abc"); 
		u.setPassword("Rous@123");
		List<Comments> list = new ArrayList<>()  ; 
		List<Post> l = new ArrayList<>() ; 
		u.setL(list);
		u.setList(l);
		et.begin() ;
		em.persist(u);
		et.commit();
	}
	public void createPost() {
		Post p1 = new Post() ; 
		p1.setTitle("Daddies");
		p1.setContent("Hello ");
		Users u = em.find(Users.class, 2) ; 
		p1.setU(u);
		Post p2 = new Post() ; 
		p2.setTitle("Vishnu");
		p2.setContent("Hello y");
		p2.setU(u);
		List<Post> list = new ArrayList<>() ; 
		list.add(p1) ;
		list.add(p2) ; 
		et.begin();
		em.persist(p1);
		em.persist(p2);
		u.setList(list);
		em.merge(u) ; // update it 
		et.commit();
	}
	public void updatePost() {
		Post p = em.find(Post.class, 102) ; 
		p.setContent("Hello hello i am roushan");
		et.begin();
		em.persist(p);
		et.commit();
	}
	public void deletePost() {
		Post p = em.find(Post.class, 105) ; 
		p.setU(null);
		p.setComments(null);
		String sql = "delete from users_info_post where list_id = ?1" ;
		String sql1 = "delete from users_info_comments where l_id = ?1" ;
		et.begin();
		Query query = em.createNativeQuery(sql) ; 
		query.setParameter(1,105) ;
		Query query1 = em.createNativeQuery(sql1) ; 
		query1.setParameter(1, 105) ; 
		query.executeUpdate() ;
		query1.executeUpdate() ;
		em.remove(p);
		et.commit();
	}
	public void addComments() {
		Comments c1 = new Comments() ;
		c1.setContent("Beuatiful");
		Comments c2 = new Comments() ; 
		c2.setContent("Best");
		Users u1 = em.find(Users.class, 1) ;
		c1.setUser(u1);
		c2.setUser(u1);
		List<Comments> list = new ArrayList<>() ; 
		Post p1 = em.find(Post.class, 100)  ; 
		c1.setPost(p1);
		c2.setPost(p1);
		list.add(c2) ; 
		list.add(c1) ;
		et.begin();
		em.persist(c1);
		em.persist(c2);
		u1.setL(list);
		p1.setComments(list);
		em.merge(u1) ; 
		em.merge(p1) ;
		et.commit();
		
	}
	public void fetchComments() {
		// fetch the comments of post whose id is 100 
		String sql = "select p from Post p where p.id = ?1" ;
		et.begin(); 
		Query query = em.createQuery(sql) ;
		query.setParameter(1, 100) ; 
		List<Post> l = query.getResultList() ; 
		List<Comments> list = l.get(0).getComments() ;
		for(Comments c : list) {
			System.out.println(c);
		}
		et.commit(); 
	}
	public void fetchAllUser() {
		String sql = "select u from Users u where u.id = ?1" ; 
		et.begin();
		Query query = em.createQuery(sql) ;
		query.setParameter(1, 2) ; 
		List<Users> u = query.getResultList() ; 
		List<Post> list = u.get(0).getList() ;
		for(Post p : list) {
			System.out.println(p);
		}
		et.commit();
	}
	public static void main(String[] args) {
		UserMain u = new UserMain() ; 
//		u.insertUser(); 
//		u.createPost();
//		u.updatePost();
//		u.deletePost(); 
//		u.addComments(); 
//		u.fetchComments();
		u.fetchAllUser();
	}
}

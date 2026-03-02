package Assessment;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

public class CustomerDao {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	// Save
	public void save(Customer customer) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		if (customer.getCards() == null) {
			customer.setCards(new ArrayList<>());
		}

		em.persist(customer);
		et.commit();

	}

	// Find all customers
	public List<Customer> findAll() {

		EntityManager em = emf.createEntityManager();

		List<Customer> list = em.createQuery("SELECT c FROM Customer c", Customer.class).getResultList();

		em.close();
		return list;
	}

	// Find by Id
	public Customer findById(Long id) {

		EntityManager em = emf.createEntityManager();
		Customer customer = em.find(Customer.class, id);
		em.close();
		return customer;
	}
}
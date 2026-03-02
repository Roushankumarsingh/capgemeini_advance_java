package Assessment;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class BankAccountDao {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public void save(BankAccount account) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		em.persist(account);
		et.commit();

	}

	public BankAccount findById(Long id) {
		EntityManager em = emf.createEntityManager();
		BankAccount account = em.find(BankAccount.class, id);
		em.close();
		return account;
	}

	public BankAccount findByAccountNumber(String accountNumber) {
		EntityManager em = emf.createEntityManager();

		return em.createQuery("SELECT a FROM BankAccount a WHERE a.accountNumber = :num", BankAccount.class)
				.setParameter("num", accountNumber).getSingleResult();

	}

	public void linkToCustomer(Long accountId, Long customerId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		BankAccount account = em.find(BankAccount.class, accountId);
		Customer customer = em.find(Customer.class, customerId);

		account.setCustomer(customer);
		customer.setBankAccount(account);

		et.commit();

	}

	public void updateBalance(Long accountId, BigDecimal newBalance) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		BankAccount account = em.find(BankAccount.class, accountId);
		account.setBalance(newBalance);
		et.commit();

	}

	public List<BankAccount> findAll() {
		EntityManager em = emf.createEntityManager();

		List<BankAccount> list = em.createQuery("SELECT a FROM BankAccount a", BankAccount.class).getResultList();

		em.close();
		return list;
	}
}
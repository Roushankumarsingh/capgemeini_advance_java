package Assessment;
import java.util.List;

import javax.persistence.*;

public class TransactionDao {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public void save(Transaction txn, Long accountId) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		BankAccount account = em.find(BankAccount.class, accountId);

		if (account != null) {
			account.addTransaction(txn);
			em.persist(txn);
		}

		et.commit();

	}

	public List<Transaction> findByAccount(Long accountId) {

		EntityManager em = emf.createEntityManager();

		List<Transaction> list = em
				.createQuery("SELECT t FROM Transaction t WHERE t.bankAccount.accountId = :id", Transaction.class)
				.setParameter("id", accountId).getResultList();

		em.close();
		return list;
	}

	public List<Transaction> findByType(Long accountId, String type) {

		EntityManager em = emf.createEntityManager();

		List<Transaction> list = em.createQuery(
				"SELECT t FROM Transaction t WHERE t.bankAccount.accountId = ?1 AND t.txnType = ?2 ORDER BY t.txnDate DESC",
				Transaction.class).setParameter(1, accountId).setParameter(2, type).getResultList();

		em.close();
		return list;
	}
}
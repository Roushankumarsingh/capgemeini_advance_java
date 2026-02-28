package Assessment;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CardDao {

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

	public void issueCard(Card card, Long accountId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		BankAccount account = em.find(BankAccount.class, accountId);
		card.setBankAccount(account);

		em.persist(card);

		et.commit();

	}

	public void assignCardToCustomer(Long cardId, Long customerId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();

		Card card = em.find(Card.class, cardId);
		Customer customer = em.find(Customer.class, customerId);

		customer.getCards().add(card);
		em.merge(customer);

		et.commit();

	}

	public Card findById(Long id) {
		EntityManager em = emf.createEntityManager();
		Card card = em.find(Card.class, id);
		em.close();
		return card;
	}

	public List<Card> findAll() {
		EntityManager em = emf.createEntityManager();

		List<Card> list = em.createQuery("SELECT c FROM Card c", Card.class).getResultList();

		em.close();
		return list;
	}

	public void deactivateCard(Long cardId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		et.begin();
		Card card = em.find(Card.class, cardId);
		card.setIsActive(false);
		et.commit();

	}
}
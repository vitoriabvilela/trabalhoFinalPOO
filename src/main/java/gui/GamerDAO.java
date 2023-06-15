package gui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GamerDAO {
	
	public GamerDAO() {
		
	}

	public void salvarJogador(Gamer gamer) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("game-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		entityManager.persist(gamer);
		transaction.commit();
		if (transaction.isActive()) {
            transaction.rollback();
		}
		entityManager.close();
        entityManagerFactory.close();

	}

}

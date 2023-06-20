package jogador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class GamerDAO {

	public GamerDAO() {

	}

	// classe para persistir a classe Gamer no banco de dados
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

	public int obterMaiorPontuacao() {
		int maiorPontuacao = 0;

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("game-jpa");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			String hql = "SELECT MAX(g.pontos) FROM Gamer g";
			TypedQuery<Integer> query = entityManager.createQuery(hql, Integer.class);
			Integer resultado = query.getSingleResult();

			if (resultado != null) {
				maiorPontuacao = resultado;
			}
		} catch (Exception e) {
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		return maiorPontuacao;
	}

}

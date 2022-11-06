package br.com.simulador.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.simulador.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class LoginDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();

	@SuppressWarnings("unchecked")
	public static boolean validate(String user, String password) {

		EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();

		List<User> lista = new ArrayList<User>();

		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.clear();
		Query query = em.createQuery("SELECT u FROM User u WHERE u.username = :user and u.password = :password");
		query.setParameter("user", user);
		query.setParameter("password", password);
		lista = query.getResultList();

		em.close();

		if (lista.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void atualiza(User u) {
		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.clear();
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
		em.close();
	}

	public void deleta(User u) {
		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.clear();
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		em.close();
	}

	public void inclui(User u) {
		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.clear();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}

	public User getById(int id) {
		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.clear();
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.getTransaction().commit();
		em.close();
		return user;
	}

}
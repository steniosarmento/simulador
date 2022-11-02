package br.com.simulador.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.simulador.model.Solicitacao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 * DAO de Solicitaçãoo.
 * 
 * @author Stenio Sarmento
 * @version 1.0
 * @see br.com.simulador.dao
 * 
 */
public class SolicitacaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();

	public boolean ADM(String depe) {
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Solicitacao> listaSolicitacoes() {
		List<Solicitacao> lista = new ArrayList<Solicitacao>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -90);
		Date data90Dias = cal.getTime();
		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.clear();
		Query query = em
				.createQuery("SELECT s FROM Solicitacao s WHERE s.dataSolicitacao >= :data90Dias ORDER BY s.id DESC");
		query.setParameter("data90Dias", data90Dias);
		lista = query.getResultList();

		em.close();

		return lista;
	}

	public void atualiza(Solicitacao s) {
		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.clear();
		em.getTransaction().begin();
		em.merge(s);
		em.getTransaction().commit();
		em.close();
	}

	public void deleta(Solicitacao s) {
		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.clear();
		em.getTransaction().begin();
		em.remove(s);
		em.getTransaction().commit();
		em.close();
	}

	public void inclui(Solicitacao s) {
		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.clear();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public Solicitacao getById(int id) {
		em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();
		em.clear();
		em.getTransaction().begin();
		Solicitacao solicitacao = em.find(Solicitacao.class, id);
		em.getTransaction().commit();
		em.close();
		return solicitacao;
	}

}

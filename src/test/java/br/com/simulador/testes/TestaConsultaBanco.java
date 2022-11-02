package br.com.simulador.testes;

import java.util.List;

import br.com.simulador.dao.EntityManagerProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/**
 * Teste de Consulta BD.
 * 
 * 
 * @author Stenio Sarmento
 * @version 1.0
 * @see br.com.simulador.testes
 * 
 */
public class TestaConsultaBanco {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManager em = EntityManagerProvider.getEntityManagerFactory().createEntityManager();

		em.clear();

		em.getTransaction().begin();

		Query q = em.createNativeQuery("  SELECT T1.NR_DMD AS DEMANDA,            "
				+ "	     (COUNT(T1.ID_SLCT)) AS QUANTIDADE" + "    FROM PUBLIC.ATT_SLCT T1               "
				+ "   WHERE T1.NR_DMD NOT IN ('0')           " + "GROUP BY T1.NR_DMD                        "
				+ "ORDER BY QUANTIDADE DESC                  " + "FETCH FIRST 10 ROWS ONLY                  ");

		List<Object[]> solicitacoes = q.getResultList();

		for (Object[] a : solicitacoes) {
			System.out.println(a[0] + " " + a[1]);
		}

		em.close();

	}

}
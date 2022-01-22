package br.com.simulador.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Provedor de EM do Projeto.
 * 
 * @author Stenio Sarmento
 * @version 1.0
 * @see br.com.simulador.dao
 * 
 */
public class EntityManagerProvider {
	private static EntityManagerFactory emf = null;

	public EntityManagerProvider() {
	}

	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {

			emf = Persistence.createEntityManagerFactory("simulador");

		}
		return emf;
	}
}
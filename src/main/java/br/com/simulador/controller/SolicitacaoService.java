package br.com.simulador.controller;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.simulador.dao.SolicitacaoDAO;
import br.com.simulador.model.Solicitacao;

/**
 * Service de Solicitação.
 * 
 * @author Stenio Sarmento
 * @version 1.0
 * @see br.com.simulador.controller
 * 
 */
@Named
@ApplicationScoped
public class SolicitacaoService implements Serializable {

	private static final long serialVersionUID = 1L;

	SolicitacaoDAO dao = new SolicitacaoDAO();
	List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
	List<Object[]> resultado = new ArrayList<Object[]>();

	public List<Solicitacao> listaSolicitacoes() {
		solicitacoes = dao.listaSolicitacoes();
		return solicitacoes;
	}

	public void atualiza(Solicitacao s) {

		s.setEstadoProcessamento("S");

		dao.atualiza(s);
	}

	public void deleta(Solicitacao s) {
		dao.deleta(s);
	}

	public void inclui(Solicitacao s) {
		Timestamp dataHora;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		dataHora = new Timestamp(calendar.getTimeInMillis());

		s.setDataSolicitacao(dataHora);

		dao.inclui(s);

	}

	public Solicitacao getById(int id) {
		return dao.getById(id);
	}

}
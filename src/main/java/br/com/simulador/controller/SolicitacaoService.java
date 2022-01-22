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
import br.com.simulador.sso.api.bean.Usuario;

/**
 * Service de Solicita��o.
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
	Usuario usuario = new Usuario();
	String usu = "";
	String depe = "";
	String cargo = "";

	public List<Solicitacao> listaSolicitacoes() {
		solicitacoes = dao.listaSolicitacoes();
		return solicitacoes;
	}

	private void inicializaUsuarioLogado() {

		usuario.setChave("12345678");
		usuario.setEmail("gustavao@unimed.com.br");
		usuario.setNome("Gustavo Henrique Portugal Pires");
		usuario.setNomeGuerra("Gustavão");
		usuario.setTelefone("(31) 3451-1202");
		usuario.setCargo("Gerente");
		usuario.setPrefixoDiretoria("9999");
		usuario.setPrefixoDependencia("8888");
		usuario.setAvatar("teste");

	}

	public void atualiza(Solicitacao s) {

		s.setEstadoProcessamento("S");

		dao.atualiza(s);
	}

	public void deleta(Solicitacao s) {
		dao.deleta(s);
	}

	public void inclui(Solicitacao s) {
		inicializaUsuarioLogado();
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
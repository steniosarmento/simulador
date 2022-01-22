package br.com.simulador.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.simulador.controller.SolicitacaoService;
import br.com.simulador.model.Solicitacao;

/**
 * View de Solicita��o.
 * 
 * 
 * @author Stenio Sarmento
 * @version 1.0
 * @see br.com.simulador.view
 * 
 */
@Named
@ViewScoped
public class SolicitacaoView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Solicitacao selecionadoSolicitacao;
	private Solicitacao novoSolicitacao = new Solicitacao();
	private List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();

	@Inject
	private SolicitacaoService service;

	public void setService(SolicitacaoService service) {
		this.service = service;
	}

	public List<Solicitacao> getSolicitacoes() {
		solicitacoes = service.listaSolicitacoes();
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}

	public Solicitacao getSelecionadoSolicitacao() {
		return selecionadoSolicitacao;
	}

	public void setSelecionadoSolicitacao(Solicitacao selecionadoSolicitacao) {
		this.selecionadoSolicitacao = selecionadoSolicitacao;
	}

	public Solicitacao getNovoSolicitacao() {
		return novoSolicitacao;
	}

	public void setNovoSolicitacao(Solicitacao novoSolicitacao) {
		this.novoSolicitacao = novoSolicitacao;
	}

	public void atualizaAction(ActionEvent actionEvent) {
		service.atualiza(selecionadoSolicitacao);
		adicionaMenssagemInfo("O contato " + selecionadoSolicitacao.getId() + " foi atualizado!");
	}

	public void deletaAction(ActionEvent actionEvent) {
		service.deleta(selecionadoSolicitacao);
		adicionaMenssagemInfo("Solicitacao Excluida");
	}

	public void novoSolicitacaoAction(ActionEvent actionEvent) {
		/* Calculando o plano ideal pegando a idade do cliente + 100 */
		novoSolicitacao.setPlanoSugerido(novoSolicitacao.getIdadeCliente() + 100);
	}

	public String geradorSenha() {
		Random gerador = new Random();
		String senha = "";

		int n1 = gerador.nextInt(8) + 1;
		int n2 = gerador.nextInt(8) + 1;
		int n3 = gerador.nextInt(8) + 1;
		int n4 = gerador.nextInt(8) + 1;
		int n5 = gerador.nextInt(8) + 1;
		int n6 = gerador.nextInt(8) + 1;
		int n7 = gerador.nextInt(8) + 1;
		int n8 = gerador.nextInt(8) + 1;

		senha = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4) + String.valueOf(n5)
				+ String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8);

		return senha;
	}

	public void novoAction(ActionEvent actionEvent) {
		int idadeCliente = novoSolicitacao.getIdadeCliente();

		if (idadeCliente == 0) {
			adicionaMenssagemErro("É obrigatório informar uma idade acima de 0!");
		}

		else {
			service.inclui(novoSolicitacao);
			adicionaMenssagemInfo("Em breve entraremos em contato!");
		}
		novoSolicitacao = new Solicitacao();
	}

	public void adicionaMenssagemInfo(String summary) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "" + summary));
	}

	public void adicionaMenssagemErro(String summary) {
		FacesContext context = FacesContext.getCurrentInstance();

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "" + summary));
	}

}
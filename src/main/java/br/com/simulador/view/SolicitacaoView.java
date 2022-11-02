package br.com.simulador.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.simulador.controller.SolicitacaoService;
import br.com.simulador.model.Plano;
import br.com.simulador.model.Solicitacao;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * View de Solicitação.
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
		Plano plano = new Plano();

		if (novoSolicitacao.getIdadeCliente() % 2 == 0) {
			plano.setId(1);
			plano.setNome("Plano Idade Par");
			plano.setPreco(1600.50);
		} else {
			plano.setId(1);
			plano.setNome("Plano Idade Impar");
			plano.setPreco(1600.50);
		}

		/* Calculando o plano ideal pegando a idade do cliente + 100 */
		novoSolicitacao.setPlanoSugerido(novoSolicitacao.getIdadeCliente() + 100);
		novoSolicitacao.setPlano(plano);
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
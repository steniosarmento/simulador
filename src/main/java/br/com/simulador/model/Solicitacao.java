package br.com.simulador.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import br.com.simulador.util.ConstantsSimulador;

/**
 * Modelo de Solicitacao.
 * 
 * 
 * @author Stenio Sarmento.
 * @version 1.0
 * @see br.com.simulador.model
 * 
 */

@Entity
@Table(name = "att_slct")
public class Solicitacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_simul")
	@NotNull
	private int id;

	@Column(name = "ts_slct")
	private Timestamp dataSolicitacao;

	@Column(name = "nom_cli")
	private String nomeCliente;

	@Column(name = "idade_cli")
	private int idadeCliente = 35;

	@Column(name = "tel_cli")
	private String telefoneCliente;

	@Column(name = "plano_suger")
	private int planoSugerido;

	@Column(name = "est_prct")
	private String estadoProcessamento = "S";

	@Transient
	private Plano plano;

	public Solicitacao() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getEstadoProcessamento() {
		return estadoProcessamento;
	}

	public void setEstadoProcessamento(String estadoProcessamento) {
		this.estadoProcessamento = estadoProcessamento;
	}

	public Timestamp getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Timestamp dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public int getPlanoSugerido() {
		return planoSugerido;
	}

	public void setPlanoSugerido(int planoSugerido) {
		this.planoSugerido = planoSugerido;
	}

	public int getIdadeCliente() {
		return idadeCliente;
	}

	public void setIdadeCliente(int idadeCliente) {
		this.idadeCliente = idadeCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getEstadoProcessamentoExt() {
		if (estadoProcessamento.equals(ConstantsSimulador.ESTADO_S)) {
			return "Solicitado";
		} else if (estadoProcessamento.equals(ConstantsSimulador.ESTADO_P)) {
			return ConstantsSimulador.ESTADO_P_EXT;
		} else if (estadoProcessamento.equals(ConstantsSimulador.ESTADO_F)) {
			return ConstantsSimulador.ESTADO_F_EXT;
		} else if (estadoProcessamento.equals(ConstantsSimulador.ESTADO_E)) {
			return ConstantsSimulador.ESTADO_E_EXT;
		} else {
			return ConstantsSimulador.ESTADO_ERROR;
		}
	}

	public String getEstadoProcessamentoIco() {
		if (estadoProcessamento.equals(ConstantsSimulador.ESTADO_S)) {
			return "/img/solicitado.png";
		} else if (estadoProcessamento.equals(ConstantsSimulador.ESTADO_P)) {
			return "/img/em_processamento.gif";
		} else if (estadoProcessamento.equals(ConstantsSimulador.ESTADO_F)) {
			return "/img/finalizado.png";
		} else if (estadoProcessamento.equals(ConstantsSimulador.ESTADO_E)) {
			return "/img/processado_com_erro.png";
		} else {
			return "/img/solicitado.png";
		}
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

}
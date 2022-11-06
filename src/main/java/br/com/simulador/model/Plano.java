package br.com.simulador.model;

import java.io.Serializable;

public class Plano implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id = 0;
	private String nome = "Teste";
	private Double preco = 0.0;

	public Plano() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
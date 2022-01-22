package br.com.simulador.sso.api.bean;

public class Usuario {
	private String chave;
	private String email;
	private String nome;
	private String nomeGuerra;
	private String telefone;
	private String cargo;
	private String prefixoDiretoria;
	private String prefixoDependencia;
	private String avatar;

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeGuerra() {
		if (this.nomeGuerra.length() == 0) {
			this.nomeGuerra = this.nome;
		}
		return nomeGuerra.toLowerCase();
	}

	public void setNomeGuerra(String nomeGuerra) {
		this.nomeGuerra = nomeGuerra;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCargo() {
		return cargo.toLowerCase();
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPrefixoDiretoria() {
		return prefixoDiretoria;
	}

	public void setPrefixoDiretoria(String prefixoDiretoria) {
		this.prefixoDiretoria = prefixoDiretoria;
	}

	public String getPrefixoDependencia() {
		return prefixoDependencia;
	}

	public void setPrefixoDependencia(String prefixoDependencia) {
		this.prefixoDependencia = prefixoDependencia;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
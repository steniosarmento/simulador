package br.com.simulador.view;

import java.io.Serializable;

import br.com.simulador.sso.api.bean.Usuario;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

/**
 * View de Usuário.
 * 
 * 
 * @author Stenio Sarmento
 * @version 1.0
 * @see br.com.simulador.view
 * 
 */
@Named
@ViewScoped
public class UsuarioView implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usu = new Usuario();

	public Usuario getUsu() {
		usu.setChave("12345678");
		usu.setEmail("gustavao@unimed.com.br");
		usu.setNome("Gustavo Henrique Portugal Pires");
		usu.setNomeGuerra("Gustavão");
		usu.setTelefone("(31) 3451-1202");
		usu.setCargo("Gerente");
		usu.setPrefixoDiretoria("9999");
		usu.setPrefixoDependencia("8888");
		usu.setAvatar("teste");
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

}
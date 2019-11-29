package br.com.rh.controller;


import java.io.Serializable;





import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rh.model.Funcionario;
import br.com.rh.model.Usuario;
import br.com.rh.model.UsuarioDAO;

@Named("usuarioBean")
@SessionScoped
public class UsuarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuario usuario;
	
	private Usuario userRetorno;
	
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Usuario> user = new ArrayList<>();
	
	UIData tabelaUsuarios;
	
	
	public String adicionar(){
		
		usuarios.add(usuario);
		new UsuarioDAO().save(usuario);
		limpar();
		return null;
	}
	
public String atualizar(){
		
		usuarios.add(usuario);
		new UsuarioDAO().update(usuario);
		limpar();
		return null;
	}
	
public String selecionar(){
		
		user = new UsuarioDAO().list();
		return null;
	}

public String deletar(){
	Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(tabelaUsuarios.getVar());
	 new UsuarioDAO().delete(usuario);
	 return null;
}

public String selecionarPorId(){
	
	int id = usuario.getId();
	user = new UsuarioDAO().listById(id);
	return null;
}


	
	private void limpar(){
		usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	} 
	
	public Usuario getUserRetorno() {
		selecionar();
		return userRetorno;
	} 

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setUserRetorno( Usuario userRetorno) {
		this.userRetorno = userRetorno;
	}

	public List<Usuario> getUsuarios() {
		
		return usuarios;
	}
	
public List<Usuario> getUser() {
		selecionar();
		return user;
		
	}

public List<Usuario> getUserById() {
	selecionarPorId();
	return user;
}


	public void setUsuarios(List<Usuario> Usuarios, List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void setUser(List<Usuario> User, List<Usuario> user) {
		this.user = user;
	}
	
	
}

	
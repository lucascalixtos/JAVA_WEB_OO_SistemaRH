package br.com.rh.controller;


import java.io.Serializable;





import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;





import org.primefaces.context.RequestContext;

import br.com.rh.model.LoginDAO;
import br.com.rh.model.Funcionario;
import br.com.rh.model.FuncionarioDAO;
import br.com.rh.model.Login;

@Named("loginBean")
@SessionScoped
public class LoginMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Login login;
	
	private List<Login> logins = new ArrayList<>();
	private List<Login> loginRetorno;
	
	public String adicionar(){
		logins.add(login);
		new LoginDAO().save(login);
		limpar();
		return null;
	}
	
public String selecionar(){
		
		loginRetorno = new LoginDAO().list();
		return null;
	}

public String checarLogin(){
		
		String usuario = login.getUsuario();
		System.out.println("Usuario = "+usuario);
		String senha = login.getSenha();
		if(new LoginDAO().checkLogin(usuario, senha) != false){
			System.out.println("Logado!");
			return "listaFuncionarios.xhtml?faces-redirect=true";
		}else{
			System.out.println("Usuario ou senha incorretos!");
			RequestContext.getCurrentInstance().update("growl");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro","Usuário ou Senha inválidos!"));
			return "";
		}
}
	
	private void limpar(){
		login = new Login();
	}
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login Login) {
		this.login = Login;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> Logins, List<Login> logins) {
		this.logins = logins;
	}

	public List<Login> getLoginRetorno() {
		selecionar();
		return loginRetorno;
	}
	

}

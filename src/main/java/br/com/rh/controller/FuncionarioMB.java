package br.com.rh.controller;


import java.io.Serializable;





import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rh.model.Funcionario;
import br.com.rh.model.FuncionarioDAO;

@Named("funcionarioBean")
@SessionScoped
public class FuncionarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionario funcionario;
	
	private Funcionario funcRetorno;
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	private List<Funcionario> func = new ArrayList<>();
	
	
	
	
	public String adicionar(){
		
		funcionarios.add(funcionario);
		new FuncionarioDAO().save(funcionario);
		limpar();
		return null;
	}
	
public String atualizar(){
		
		funcionarios.add(funcionario);
		new FuncionarioDAO().update(funcionario);
		limpar();
		return null;
	}
	
public String selecionar(){
		
		func = new FuncionarioDAO().list();
		return null;
	}

public String selecionarPorId(){
	
	int id = funcionario.getId();
	func = new FuncionarioDAO().listById(id);
	return null;
}


	
	private void limpar(){
		funcionario = new Funcionario();
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	} 
	
	public Funcionario getFuncRetorno() {
		selecionar();
		return funcRetorno;
	} 

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void setFuncRetorno( Funcionario funcRetorno) {
		this.funcRetorno = funcRetorno;
	}

	public List<Funcionario> getFuncionarios() {
		
		return funcionarios;
	}
	
public List<Funcionario> getFunc() {
		selecionar();
		return func;
	}

public List<Funcionario> getFuncById() {
	selecionarPorId();
	return func;
}


	public void setFuncionarios(List<Funcionario> Funcionarios, List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public void setFunc(List<Funcionario> Func, List<Funcionario> func) {
		this.func = func;
	}
	
	
}

	
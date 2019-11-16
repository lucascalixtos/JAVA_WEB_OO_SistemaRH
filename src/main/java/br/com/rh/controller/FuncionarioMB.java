package br.com.rh.controller;


import java.io.Serializable;





import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rh.model.Funcionario;
import br.com.rh.model.Funcionario;

@Named("funcionarioBean")
@SessionScoped
public class FuncionarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Funcionario funcionario;
	
	private List<Funcionario> funcionarios = new ArrayList<>();
	
	public String adicionar(){
		funcionarios.add(funcionario);
		
		limpar();
		return null;
	}
	
	private void limpar(){
		funcionario = new Funcionario();
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario Funcionario) {
		this.funcionario = Funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> Funcionarios) {
		this.funcionarios = funcionarios;
	}

	

}

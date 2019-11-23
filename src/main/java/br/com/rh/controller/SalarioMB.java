package br.com.rh.controller;


import java.io.Serializable;





import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rh.model.Salario;
import br.com.rh.model.Salario;
import br.com.rh.model.SalarioDAO;
import br.com.rh.model.Funcionario;
import br.com.rh.model.FuncionarioDAO;

@Named("salarioBean")
@SessionScoped
public class SalarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Salario salario;
	
	private List<Salario> salarios = new ArrayList<>();
	private List<Salario> salarioRetorno;
	
	public String adicionar(){
		salarios.add(salario);
		new SalarioDAO().save(salario);
		limpar();
		return null;
	}
	
	public String selecionar(){
		
		 salarioRetorno = new SalarioDAO().list();
		return null;
	}
	
	public float calculaPagamento(){
		float pagamento = 0;
		int id = 0;
		
		float sal = new SalarioDAO().salarioFuncionario(id);
		
		return pagamento;
	}
	
	private void limpar(){
		salario = new Salario();
	}
	
	public Salario getSalario() {
		return salario;
	}

	public void setSalario(Salario Salario) {
		this.salario = Salario;
	}

	public List<Salario> getSalarios() {
		return salarios;
	}

	public void setSalarios(List<Salario> Salarios, List<Salario> salarios) {
		this.salarios = salarios;
	}

	public List<Salario> getSalarioRetorno() {
		selecionar();
		return salarioRetorno;
	}
	

}

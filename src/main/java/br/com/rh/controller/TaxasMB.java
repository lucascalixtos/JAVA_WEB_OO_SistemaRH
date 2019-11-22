package br.com.rh.controller;


import java.io.Serializable;





import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rh.model.Taxas;
import br.com.rh.model.Taxas;
import br.com.rh.model.TaxasDAO;
import br.com.rh.model.Funcionario;
import br.com.rh.model.FuncionarioDAO;

@Named("taxasBean")
@SessionScoped
public class TaxasMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Taxas taxas;
	
	private List<Taxas> taxass = new ArrayList<>();
	private List<Taxas> taxasRetorno;
	
	public String adicionar(){
		taxass.add(taxas);
		new TaxasDAO().save(taxas);
		limpar();
		return null;
	}
	
public String selecionar(){
		
		 taxasRetorno = new TaxasDAO().list();
		return null;
	}
	
	private void limpar(){
		taxas = new Taxas();
	}
	
	public Taxas getTaxas() {
		return taxas;
	}

	public void setTaxas(Taxas Taxas) {
		this.taxas = Taxas;
	}

	public List<Taxas> getTaxass() {
		return taxass;
	}

	public void setTaxass(List<Taxas> Taxass, List<Taxas> taxass) {
		this.taxass = taxass;
	}

	public List<Taxas> getTaxasRetorno() {
		selecionar();
		return taxasRetorno;
	}
	

}

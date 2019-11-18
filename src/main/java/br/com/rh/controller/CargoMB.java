package br.com.rh.controller;


import java.io.Serializable;





import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rh.model.Cargo;
import br.com.rh.model.Cargo;

@Named("cargoBean")
@SessionScoped
public class CargoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cargo cargo;
	
	private List<Cargo> cargos = new ArrayList<>();
	
	public String adicionar(){
		cargos.add(cargo);
		
		limpar();
		return null;
	}
	
	private void limpar(){
		cargo = new Cargo();
	}
	
	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo Cargo) {
		this.cargo = Cargo;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> Cargos) {
		this.cargos = cargos;
	}

	

}

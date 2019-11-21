package br.com.rh.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Salario {
	
	private int id;
	private float salario;
	private long dataAlteracao;
	private int fk_IdCargo;
	private int fk_IdFuncionario;
	
	
	public Salario(){
		
	}
	
	public Salario(int id, float salario, long dataAlteracao, int fk_IdCargo, int fk_IdFuncionario){
		this.id = id;
		this.salario = salario;
		this.dataAlteracao = dataAlteracao;
		this.fk_IdCargo = fk_IdCargo;
		this.fk_IdFuncionario = fk_IdFuncionario;
		
	}
	
	public void save() {
		SalarioDAO SalarioDAO = new SalarioDAO();
		SalarioDAO.save();
	}
	
	public void delete() {
		SalarioDAO SalarioDAO = new SalarioDAO();
		SalarioDAO.delete(this.getId());
	}
	
	public ArrayList<Salario> listAll() {
		SalarioDAO SalarioDAO = new SalarioDAO();
		return ( SalarioDAO.listAll());
	}
	
	public String[] toArray() {
		return(
		new String[] { 
				new Integer(  this.getId() ).toString(), 
			new Float( this.getSalario() ).toString(),
			new Timestamp(this.getDataAlteracao()) .toString(),
			new Integer(  this.getFk_IdFuncionario() ).toString(),
			new Integer(  this.getFk_IdCargo() ).toString()
		});
	}
	
	public String toString() {
		return(
				new Integer(  this.getId() ).toString() +
				new Float( this.getSalario() ).toString() +
				new Timestamp(this.getDataAlteracao()) .toString() +
				new Integer(  this.getFk_IdFuncionario() ).toString() +
				new Integer(  this.getFk_IdCargo() ).toString()
		);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public long getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(long timestamp) {
		this.dataAlteracao = timestamp;
	}

	public int getFk_IdCargo() {
		return fk_IdCargo;
	}

	public void setFk_IdCargo(int fk_IdCargo) {
		this.fk_IdCargo = fk_IdCargo;
	}

	public int getFk_IdFuncionario() {
		return fk_IdFuncionario;
	}

	public void setFk_IdFuncionario(int fk_IdFuncionario) {
		this.fk_IdFuncionario = fk_IdFuncionario;
	}

	
	
	
}

package br.com.rh.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Salario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private float salario;
	private long dataAlteracao;
	private int fk_IdCargo;
	private int fk_IdFuncionario;
	
	
	public Salario(){
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (dataAlteracao ^ (dataAlteracao >>> 32));
		result = prime * result + fk_IdCargo;
		result = prime * result + fk_IdFuncionario;
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(salario);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salario other = (Salario) obj;
		if (dataAlteracao != other.dataAlteracao)
			return false;
		if (fk_IdCargo != other.fk_IdCargo)
			return false;
		if (fk_IdFuncionario != other.fk_IdFuncionario)
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(salario) != Float
				.floatToIntBits(other.salario))
			return false;
		return true;
	}

	public Salario(int id, float salario, long dataAlteracao, int fk_IdCargo, int fk_IdFuncionario){
		this.id = id;
		this.salario = salario;
		this.dataAlteracao = dataAlteracao;
		this.fk_IdCargo = fk_IdCargo;
		this.fk_IdFuncionario = fk_IdFuncionario;
		
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

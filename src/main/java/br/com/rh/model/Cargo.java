package br.com.rh.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cargo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(salInicial);
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
		Cargo other = (Cargo) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(salInicial) != Float
				.floatToIntBits(other.salInicial))
			return false;
		return true;
	}

	private int id;
	private String nome;
	private float salInicial;
	
	public Cargo(){
		
	}
	
	public Cargo(int id, String nome, float salInicial){
		this.id = id;
		this.nome = nome;
		this.salInicial = salInicial;
	}
	
	public void save() {
		CargoDAO CargoDAO = new CargoDAO();
		CargoDAO.save();
	}
	
	public void delete() {
		CargoDAO CargoDAO = new CargoDAO();
		CargoDAO.delete(this.getId());
	}
	
	public ArrayList<Cargo> listAll() {
		CargoDAO CargoDAO = new CargoDAO();
		return ( CargoDAO.listAll());
	}
	
	public String[] toArray() {
		return(
		new String[] { 
				new Integer(  this.getId() ).toString(), 
				this.getNome(),
				new Float ( this.getSalInicial() ). toString()
		});
	}
	
	public String toString() {
		return(
				new Integer(  this.getId() ).toString()+ 
				this.getNome()+ 
				this.getSalInicial()
		);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSalInicial() {
		return salInicial;
	}

	public void setSalInicial(float salInicial) {
		this.salInicial = salInicial;
	}
	
}

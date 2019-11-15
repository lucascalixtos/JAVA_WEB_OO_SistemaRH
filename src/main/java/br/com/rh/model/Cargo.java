package br.com.rh.model;

import java.util.ArrayList;

public class Cargo {
	
	private int id;
	private String nome;
	private float salHoraInicial;
	
	public Cargo(){
		
	}
	
	public Cargo(int id, String nome, float salHoraInicial){
		this.id = id;
		this.nome = nome;
		this.salHoraInicial = salHoraInicial;
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
				new Float ( this.getSalHoraInicial() ). toString()
		});
	}
	
	public String toString() {
		return(
				new Integer(  this.getId() ).toString()+ 
				this.getNome()+ 
				this.getSalHoraInicial()
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

	public float getSalHoraInicial() {
		return salHoraInicial;
	}

	public void setSalHoraInicial(float salHoraInicial) {
		this.salHoraInicial = salHoraInicial;
	}
	
}

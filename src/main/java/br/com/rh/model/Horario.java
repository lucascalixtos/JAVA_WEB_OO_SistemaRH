package br.com.rh.model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Horario {
	
	private int id;
	private int fk_Funcionario;
	private long entrada;
	private long saida;
	
	public Horario(){
		
	}
	
	public Horario(int id, long entrada, long saida, int fk_Funcionario){
		this.id = id;
		this.entrada = entrada;
		this.saida = saida;
		this.fk_Funcionario = fk_Funcionario;
	}
	
	
	
	public void delete() {
		HorarioDAO HorarioDAO = new HorarioDAO();
		HorarioDAO.delete(this.getId());
	}
	
	public ArrayList<Horario> listAll() {
		HorarioDAO HorarioDAO = new HorarioDAO();
		return ( HorarioDAO.listAll());
	}
	
	public String[] toArray() {
		return(
		new String[] { 
				new Integer(  this.getId() ).toString(), 
				new Timestamp( this.getEntrada()) .toString(),
				new Timestamp( this.getSaida()) .toString(),
				new Integer ( this.getFk_Funcionario() ). toString()
		});
	}
	
	public String toString() {
		return(
				new Integer(  this.getId() ).toString()+
				new Timestamp( this.getEntrada()) .toString() +
				new Timestamp( this.getSaida()) .toString() +
				new Integer ( this.getFk_Funcionario() ). toString()
		);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFk_Funcionario() {
		return fk_Funcionario;
	}

	public void setFk_Funcionario(int fk_Funcionario) {
		this.fk_Funcionario = fk_Funcionario;
	}

	public long getEntrada() {
		return entrada;
	}

	public void setEntrada(long entrada) {
		this.entrada = entrada;
	}

	public long getSaida() {
		return saida;
	}

	public void setSaida(long saida) {
		this.saida = saida;
	}

	
	
}

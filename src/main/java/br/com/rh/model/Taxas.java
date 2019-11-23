package br.com.rh.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Taxas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private float valor;
	private long dataAlteracao;
	
	public Taxas(){
		
	}
	
	public Taxas(int id, String nome, float valor, long dataAlteracao){
		this.id = id;
		this.nome = nome;
		this.valor = valor;
		this.dataAlteracao = dataAlteracao;
	}
	
	
	public void delete() {
		TaxasDAO TaxasDAO = new TaxasDAO();
		TaxasDAO.delete(this.getId());
	}
	
	
	public ArrayList<Taxas> listAll() {
		TaxasDAO TaxasDAO = new TaxasDAO();
		return ( TaxasDAO.listAll());
	}
	
	public String[] toArray() {
		return(
		new String[] { 
				new Integer(  this.getId() ).toString(), 
				new String (  this.getNome() ).toString(),
				new Float ( this.getValor() ). toString(), 
				new Long ( this.getDataAlteracao() ). toString(),
		});
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (dataAlteracao ^ (dataAlteracao >>> 32));
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(valor);
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
		Taxas other = (Taxas) obj;
		if (dataAlteracao != other.dataAlteracao)
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}

	public String toString() {
		return(
				new Integer(  this.getId() ).toString() +
				new String (  this.getNome() ).toString() +
				new Float ( this.getValor() ). toString() + 
				new Long ( this.getDataAlteracao() ). toString()
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public long getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(long dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}

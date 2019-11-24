package br.com.rh.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Taxas implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private float fgts;
	private float inss;
	private float decimoTerceiro;
	private float ferias;
	
	public Taxas(){
		
	}
	
	public Taxas(int id, float fgts, float inss, float decimoTerceiro, float ferias){
		this.id = id;
		this.fgts = fgts;
		this.inss = inss;
		this.decimoTerceiro = decimoTerceiro;
		this.ferias = ferias;
	}
	
	
	public void delete() {
		TaxasDAO TaxasDAO = new TaxasDAO();
		TaxasDAO.delete(this.getId());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(decimoTerceiro);
		result = prime * result + Float.floatToIntBits(ferias);
		result = prime * result + Float.floatToIntBits(fgts);
		result = prime * result + id;
		result = prime * result + Float.floatToIntBits(inss);
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
		if (Float.floatToIntBits(decimoTerceiro) != Float
				.floatToIntBits(other.decimoTerceiro))
			return false;
		if (Float.floatToIntBits(ferias) != Float.floatToIntBits(other.ferias))
			return false;
		if (Float.floatToIntBits(fgts) != Float.floatToIntBits(other.fgts))
			return false;
		if (id != other.id)
			return false;
		if (Float.floatToIntBits(inss) != Float.floatToIntBits(other.inss))
			return false;
		return true;
	}

	public ArrayList<Taxas> listAll() {
		TaxasDAO TaxasDAO = new TaxasDAO();
		return ( TaxasDAO.listAll());
	}
	
	public String[] toArray() {
		return(
		new String[] { 
				new Integer(  this.getId() ).toString(), 
				new Float (  this.getFgts() ).toString(),
				new Float ( this.getInss() ). toString(), 
				new Float ( this.getDecimoTerceiro() ). toString(),
				new Float ( this.getFerias() ). toString()
		});
	}
	
	public String toString() {
		return(
				new Integer(  this.getId() ).toString() +  
				new Float (  this.getFgts() ).toString() +
				new Float ( this.getInss() ). toString() + 
				new Float ( this.getDecimoTerceiro() ). toString() +
				new Float ( this.getFerias() ). toString()
		);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getFgts() {
		return fgts;
	}

	public void setFgts(float fgts) {
		this.fgts = fgts;
	}

	public float getInss() {
		return inss;
	}

	public void setInss(float inss) {
		this.inss = inss;
	}

	public float getDecimoTerceiro() {
		return decimoTerceiro;
	}

	public void setDecimoTerceiro(float decimoTerceiro) {
		this.decimoTerceiro = decimoTerceiro;
	}

	public float getFerias() {
		return ferias;
	}

	public void setFerias(float ferias) {
		this.ferias = ferias;
	}

	
	
}

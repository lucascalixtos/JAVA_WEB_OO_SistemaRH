package br.com.rh.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import br.com.rh.model.Taxas;
import database.DBQuery;

public class TaxasDAO extends DBQuery {
	
	private  Taxas Taxas = null;
	
	public TaxasDAO(Taxas Taxas) {
		this.setTable	("Taxas");
		this.setFields	(new String[]{"id", "fgts", "inss", "decimoTercero", "ferias"});
		this.setKeyField("id");
		this.setTaxas(Taxas);
	}
	
	public TaxasDAO() {
		this.setTable	("Taxas");
		this.setFields	(new String[]{"id", "fgts", "inss", "decimoTercero", "ferias"});
		this.setKeyField("id");
	}
	
	public  ArrayList<Taxas> listById(String id) {
		
		ArrayList<Taxas> tempListTaxass = new ArrayList<Taxas>();
		try {
			ResultSet rs = select("id = "+id);
			while (rs.next()) {
				Taxas tempTaxas = new Taxas();
				tempTaxas.setId( rs.getInt("id"));
				tempTaxas.setFgts(rs.getFloat("fgts"));
				tempTaxas.setInss(rs.getFloat("inss"));
				tempTaxas.setDecimoTerceiro(rs.getFloat("decimoTerceiro"));
				tempTaxas.setFerias(rs.getFloat("ferias"));
				tempListTaxass.add(tempTaxas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListTaxass );
	}
	
	public  ArrayList<Taxas> listByEmail(String email) {
		ArrayList<Taxas> tempListTaxass = new ArrayList<Taxas>();
		try {
			ResultSet rs = select("email = "+ email);
			while (rs.next()) {
				Taxas tempTaxas = new Taxas();
				tempTaxas.setId( rs.getInt("id"));
				tempTaxas.setFgts(rs.getFloat("fgts"));
				tempTaxas.setInss(rs.getFloat("inss"));
				tempTaxas.setDecimoTerceiro(rs.getFloat("decimoTerceiro"));
				tempTaxas.setFerias(rs.getFloat("ferias"));
				tempListTaxass.add(tempTaxas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListTaxass );		
	}

	public ArrayList<Taxas> listAll() {
		ArrayList<Taxas> tempListTaxass = new ArrayList<Taxas>();
		try {
			ResultSet rs = select();
			while (rs.next()) {
				Taxas tempTaxas = new Taxas();
				tempTaxas.setId( rs.getInt("id"));
				tempTaxas.setFgts(rs.getFloat("fgts"));
				tempTaxas.setInss(rs.getFloat("inss"));
				tempTaxas.setDecimoTerceiro(rs.getFloat("decimoTerceiro"));
				tempTaxas.setFerias(rs.getFloat("ferias"));
				tempListTaxass.add(tempTaxas);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListTaxass );		
	}
	
	public boolean checkLogin(String user, String pass){
		try {
			ResultSet rs = select("login = '"+ user +"' AND pass = '"+pass+"'");
			return (rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( false );
	}
	
	public void save() {
		if ( this.getTaxas().getId() <= 0) {
			insert(this.getTaxas().toArray());
		}else {
			update(this.getTaxas().toArray());
		}
	}
	
	public void trash() {
		// delete( this.getTaxas().getId() );
		
		
	}

	public Taxas getTaxas() {
		return Taxas;
	}

	public void setTaxas(Taxas Taxas) {
		this.Taxas = Taxas;
	}
	
	
}

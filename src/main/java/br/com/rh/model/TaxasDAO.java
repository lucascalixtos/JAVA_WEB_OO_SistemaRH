package br.com.rh.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.rh.model.Taxas;
import database.DBConnection;
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
	
	public void save(Taxas taxa) {
		Connection conexao = DBConnection.getConnection();
		try {
			PreparedStatement ps = conexao.prepareCall("INSERT INTO salario (fgts, inss, decimoTerceiro, ferias) VALUES (?,?,?,?)");
			ps.setLong(1, (long) taxa.getFgts());
			ps.setLong(2, (long) taxa.getInss());
			ps.setLong(3, (long) taxa.getDecimoTerceiro());
			ps.setLong(4, (long) taxa.getFerias());
			
			ps.execute();
			conexao.close();
			System.out.println(ps);
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public ArrayList<Taxas> list() {
		ArrayList<Taxas> taxas = new ArrayList<Taxas>();
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from taxas");
			System.out.println(ps);
			while(rs.next()) {  
				Taxas t = new Taxas(); 
				t.setId( rs.getInt("id"));
				t.setId( rs.getInt("id"));
				t.setFgts(rs.getFloat("fgts"));
				t.setInss(rs.getFloat("inss"));
				t.setDecimoTerceiro(rs.getFloat("decimoTerceiro"));
				t.setFerias(rs.getFloat("ferias"));
				
				taxas.add(t); 
			}
			 } catch (SQLException e) {
				Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
			}
			return taxas;
			
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

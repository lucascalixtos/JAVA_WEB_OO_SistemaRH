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
		this.setFields	(new String[]{"id", "nome", "valor", "dataAlteracao"});
		this.setKeyField("id");
		this.setTaxas(Taxas);
	}
	
	public TaxasDAO() {
		this.setTable	("Taxas");
		this.setFields	(new String[]{"id", "nome", "valor", "dataAlteracao"});
		this.setKeyField("id");
	}
	
	public  ArrayList<Taxas> listById(String id) {
		
		ArrayList<Taxas> tempListTaxass = new ArrayList<Taxas>();
		try {
			ResultSet rs = select("id = "+id);
			while (rs.next()) {
				Taxas tempTaxas = new Taxas();
				tempTaxas.setId( rs.getInt("id"));
				tempTaxas.setNome(rs.getString("nome"));
				tempTaxas.setValor(rs.getFloat("valor"));
				tempTaxas.setDataAlteracao(rs.getLong("dataAlteracao"));
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
				tempTaxas.setNome(rs.getString("nome"));
				tempTaxas.setValor(rs.getFloat("valor"));
				tempTaxas.setDataAlteracao(rs.getLong("dataAlteracao"));
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
				tempTaxas.setNome(rs.getString("nome"));
				tempTaxas.setValor(rs.getFloat("valor"));
				tempTaxas.setDataAlteracao(rs.getLong("dataAlteracao"));
				tempListTaxass.add(tempTaxas);
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
			PreparedStatement ps = conexao.prepareCall("INSERT INTO taxas (nome, valor) VALUES (?,?)");
			ps.setString(1, taxa.getNome());
			ps.setFloat(2, taxa.getValor());
			
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
				t.setNome(rs.getString("nome"));
				t.setValor(rs.getFloat("valor"));
				t.setDataAlteracao(rs.getLong("dataAlteracao"));
				
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

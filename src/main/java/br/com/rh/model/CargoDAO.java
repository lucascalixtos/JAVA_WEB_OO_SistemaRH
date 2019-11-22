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

import br.com.rh.model.Cargo;
import database.DBConnection;
import database.DBQuery;

public class CargoDAO extends DBQuery {
	
	private  Cargo cargo = null;
	
	public CargoDAO(Cargo Cargo) {
		this.setTable	("Cargo");
		this.setFields	(new String[]{"id","nome", "salInicial"});
		this.setKeyField("id");
		this.setCargo(Cargo);
	}
	
	public CargoDAO() {
		this.setTable	("Cargo");
		this.setFields	(new String[]{"id","nome", "salInicial"});
		this.setKeyField("id");
	}
	
	public  ArrayList<Cargo> listById(String id) {
		
		ArrayList<Cargo> tempListCargos = new ArrayList<Cargo>();
		try {
			ResultSet rs = select("id = "+id);
			while (rs.next()) {
				Cargo tempCargo = new Cargo();
				tempCargo.setId( rs.getInt("id"));
				tempCargo.setNome( rs.getString("nome"));
				tempCargo.setSalInicial(rs.getFloat("salInicial"));
				tempListCargos.add(tempCargo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListCargos );
	}
	
	public  ArrayList<Cargo> listByEmail(String email) {
		ArrayList<Cargo> tempListCargos = new ArrayList<Cargo>();
		try {
			ResultSet rs = select("email = "+ email);
			while (rs.next()) {
				Cargo tempCargo = new Cargo();
				tempCargo.setId( rs.getInt("id"));
				tempCargo.setNome( rs.getString("nome"));
				tempCargo.setSalInicial (rs.getFloat("salInicial"));
				tempListCargos.add(tempCargo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListCargos );		
	}

	public ArrayList<Cargo> listAll() {
		ArrayList<Cargo> tempListCargos = new ArrayList<Cargo>();
		try {
			ResultSet rs = select();
			while (rs.next()) {
				Cargo tempCargo = new Cargo();
				tempCargo.setId( rs.getInt("id"));
				tempCargo.setNome( rs.getString("nome"));
				tempCargo.setSalInicial (rs.getFloat("salInicial"));
				tempListCargos.add(tempCargo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListCargos );		
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
	
	public void save(Cargo cargo) {
		Connection conexao = DBConnection.getConnection();
		try {
			PreparedStatement ps = conexao.prepareCall("INSERT INTO cargo (nomeCargo, salInicial) VALUES (?,?)");
			ps.setString(1, cargo.getNome());
			ps.setLong(2, (long) cargo.getSalInicial());
			
			ps.execute();
			conexao.close();
			System.out.println(ps);
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public ArrayList<Cargo> list() {
		ArrayList<Cargo> cargos = new ArrayList<Cargo>();
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from cargo");
			System.out.println(ps);
			while(rs.next()) {  
				Cargo c = new Cargo(); 
				c.setId(rs.getInt("id"));  
				c.setNome(rs.getString("nomeCargo"));
				c.setSalInicial(rs.getFloat("salInicial"));
				
				cargos.add(c);  
			}   
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return cargos;
		
	}
	
	public void trash() {
		// delete( this.getCargo().getId() );
		
		
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo Cargo) {
		this.cargo = Cargo;
	}
	
	
}

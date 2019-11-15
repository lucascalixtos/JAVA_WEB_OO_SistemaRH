package br.com.rh.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import br.com.rh.model.Cargo;
import database.DBQuery;

public class CargoDAO extends DBQuery {
	
	private  Cargo cargo = null;
	
	public CargoDAO(Cargo Cargo) {
		this.setTable	("Cargo");
		this.setFields	(new String[]{"id","nome", "salHoraInicial"});
		this.setKeyField("id");
		this.setCargo(Cargo);
	}
	
	public CargoDAO() {
		this.setTable	("Cargo");
		this.setFields	(new String[]{"id","nome", "salHoraInicial"});
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
				tempCargo.setSalHoraInicial(rs.getFloat("salHoraInicial"));
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
				tempCargo.setSalHoraInicial (rs.getFloat("salHoraInicial"));
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
				tempCargo.setSalHoraInicial (rs.getFloat("salHoraInicial"));
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
	
	public void save() {
		if ( this.getCargo().getId() <= 0) {
			insert(this.getCargo().toArray());
		}else {
			update(this.getCargo().toArray());
		}
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

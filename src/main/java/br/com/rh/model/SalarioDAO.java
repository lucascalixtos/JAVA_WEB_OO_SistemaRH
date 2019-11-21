package br.com.rh.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import br.com.rh.model.Salario;
import database.DBQuery;

public class SalarioDAO extends DBQuery {
	
	private  Salario Salario = null;
	
	public SalarioDAO(Salario Salario) {
		this.setTable	("Salario");
		this.setFields	(new String[]{"id", "fgts", "inss", "decimoTercero", "ferias"});
		this.setKeyField("id");
		this.setSalario(Salario);
	}
	
	public SalarioDAO() {
		this.setTable	("Salario");
		this.setFields	(new String[]{"id", "fgts", "inss", "decimoTercero", "ferias"});
		this.setKeyField("id");
	}
	
	public  ArrayList<Salario> listById(String id) {
		
		ArrayList<Salario> tempListSalarios = new ArrayList<Salario>();
		try {
			ResultSet rs = select("id = "+id);
			while (rs.next()) {
				Salario tempSalario = new Salario();
				tempSalario.setId( rs.getInt("id"));
				tempSalario.setSalario(rs.getFloat("salario"));
				tempSalario.setDataAlteracao(rs.getLong("dataAlteracao"));
				tempSalario.setFk_IdCargo(rs.getInt("fk_IdCargo"));
				tempSalario.setFk_IdFuncionario(rs.getInt("fk_IdFuncionario"));
				tempListSalarios.add(tempSalario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListSalarios );
	}
	
	public  ArrayList<Salario> listByEmail(String email) {
		ArrayList<Salario> tempListSalarios = new ArrayList<Salario>();
		try {
			ResultSet rs = select("email = "+ email);
			while (rs.next()) {
				Salario tempSalario = new Salario();
				tempSalario.setId( rs.getInt("id"));
				tempSalario.setSalario(rs.getFloat("salario"));
				tempSalario.setDataAlteracao(rs.getLong("dataAlteracao"));
				tempSalario.setFk_IdCargo(rs.getInt("fk_IdCargo"));
				tempSalario.setFk_IdFuncionario(rs.getInt("fk_IdFuncionario"));
				tempListSalarios.add(tempSalario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListSalarios );		
	}

	public ArrayList<Salario> listAll() {
		ArrayList<Salario> tempListSalarios = new ArrayList<Salario>();
		try {
			ResultSet rs = select();
			while (rs.next()) {
				Salario tempSalario = new Salario();
				tempSalario.setId( rs.getInt("id"));
				tempSalario.setSalario(rs.getFloat("salario"));
				tempSalario.setDataAlteracao(rs.getLong("dataAlteracao"));
				tempSalario.setFk_IdCargo(rs.getInt("fk_IdCargo"));
				tempSalario.setFk_IdFuncionario(rs.getInt("fk_IdFuncionario"));
				tempListSalarios.add(tempSalario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListSalarios );		
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
		if ( this.getSalario().getId() <= 0) {
			insert(this.getSalario().toArray());
		}else {
			update(this.getSalario().toArray());
		}
	}
	
	public void trash() {
		// delete( this.getSalario().getId() );
		
		
	}

	public Salario getSalario() {
		return Salario;
	}

	public void setSalario(Salario Salario) {
		this.Salario = Salario;
	}
	
	
}

package br.com.rh.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import br.com.rh.model.Horario;
import database.DBQuery;

public class HorarioDAO extends DBQuery {
	
	private  Horario Horario = null;
	
	public HorarioDAO(Horario Horario) {
		this.setTable	("Horario");
		this.setFields	(new String[]{"id", "entrada", "saida", "fk_Funcionario"});
		this.setKeyField("id");
		this.setHorario(Horario);
	}
	
	public HorarioDAO() {
		this.setTable	("Horario");
		this.setFields	(new String[]{"id", "entrada", "saida", "fk_Funcionario"});
		this.setKeyField("id");
	}
	
	public  ArrayList<Horario> listById(String id) {
		
		ArrayList<Horario> tempListHorarios = new ArrayList<Horario>();
		try {
			ResultSet rs = select("id = "+id);
			while (rs.next()) {
				Horario tempHorario = new Horario();
				tempHorario.setId( rs.getInt("id"));
				tempHorario.setEntrada( rs.getLong("entrada"));
				tempHorario.setSaida( rs.getLong("saida"));
				tempListHorarios.add(tempHorario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListHorarios );
	}
	
	public  ArrayList<Horario> listByEmail(String email) {
		ArrayList<Horario> tempListHorarios = new ArrayList<Horario>();
		try {
			ResultSet rs = select("email = "+ email);
			while (rs.next()) {
				Horario tempHorario = new Horario();
				tempHorario.setId( rs.getInt("id"));
				tempHorario.setEntrada( rs.getLong("entrada"));
				tempHorario.setSaida( rs.getLong("saida"));
				tempListHorarios.add(tempHorario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListHorarios );		
	}

	public ArrayList<Horario> listAll() {
		ArrayList<Horario> tempListHorarios = new ArrayList<Horario>();
		try {
			ResultSet rs = select();
			while (rs.next()) {
				Horario tempHorario = new Horario();
				tempHorario.setId( rs.getInt("id"));
				tempHorario.setEntrada( rs.getLong("entrada"));
				tempHorario.setSaida( rs.getLong("saida"));
				tempListHorarios.add(tempHorario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListHorarios );		
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
		if ( this.getHorario().getId() <= 0) {
			insert(this.getHorario().toArray());
		}else {
			update(this.getHorario().toArray());
		}
	}
	
	public void trash() {
		// delete( this.getHorario().getId() );
		
		
	}

	public Horario getHorario() {
		return Horario;
	}

	public void setHorario(Horario Horario) {
		this.Horario = Horario;
	}
	
	
}

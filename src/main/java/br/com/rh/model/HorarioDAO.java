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

import br.com.rh.model.Horario;
import database.DBConnection;
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
	
	public void save(Horario horario) {
		Connection conexao = DBConnection.getConnection();
		try {
			PreparedStatement ps = conexao.prepareCall("INSERT INTO horario (entrada, saida, fk_Funcionario) VALUES (?,?,?)");
			ps.setLong(1, horario.getEntrada());
			ps.setLong(2, (long) horario.getSaida());
			ps.setInt(3,  horario.getFk_Funcionario());
			
			ps.execute();
			conexao.close();
			System.out.println(ps);
			
		} catch (SQLException e) {
			Logger.getLogger(HorarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public ArrayList<Horario> list() {
		ArrayList<Horario> horarios = new ArrayList<Horario>();
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from cargo");
			System.out.println(ps);
			while(rs.next()) {  
				Horario h = new Horario(); 
				h.setId(rs.getInt("id"));  
				h.setFk_Funcionario(rs.getInt("fk_Funcionario"));
				h.setEntrada(rs.getLong("entrada"));
				h.setSaida(rs.getLong("saida"));
				
				horarios.add(h);  
			}   
			
		} catch (SQLException e) {
			Logger.getLogger(HorarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return horarios;
		
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

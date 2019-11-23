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

import br.com.rh.model.Salario;
import database.DBConnection;
import database.DBQuery;

public class SalarioDAO extends DBQuery {
	
	private  Salario Salario = null;
	
	public SalarioDAO(Salario Salario) {
		this.setTable	("Salario");
		this.setFields	(new String[]{"id", "salario","dataAlteracao"});
		this.setKeyField("id");
		this.setSalario(Salario);
	}
	
	public SalarioDAO() {
		this.setTable	("Salario");
		this.setFields	(new String[]{"id", "salario","dataAlteracao"});
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
	
	public void save(Salario salario) {
		Connection conexao = DBConnection.getConnection();
		try {
			PreparedStatement ps = conexao.prepareCall("INSERT INTO salario (salario, fk_idCargo, fk_idFuncionario) VALUES (?,?,?))");
			ps.setLong(1, (long) salario.getSalario());
			ps.setLong(2, salario.getFk_IdCargo());
			ps.setLong(3, salario.getFk_IdFuncionario());
			
			ps.execute();
			conexao.close();
			System.out.println(ps);
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public ArrayList<Salario> list() {
		ArrayList<Salario> salarios = new ArrayList<Salario>();
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from salario");
			System.out.println(ps);
			while(rs.next()) {  
				Salario s = new Salario(); 
				s.setId( rs.getInt("id"));
				s.setSalario(rs.getFloat("salario"));
				s.setDataAlteracao(rs.getLong("dataAlteracao"));
				s.setFk_IdCargo(rs.getInt("fk_IdCargo"));
				s.setFk_IdFuncionario(rs.getInt("fk_IdFuncionario"));
				salarios.add(s);  
			}   
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return salarios;
		
	}
	
	public float salarioFuncionario(int id) {
		float salario = 0;
		ArrayList<Salario> salarios = new ArrayList<Salario>();
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from salario where fk_idFuncionario ="+id);
			System.out.println(ps);
			while(rs.next()) {  
				Salario s = new Salario(); 
				s.setSalario(rs.getFloat("salario"));
				salario = s.getSalario();
				salarios.add(s);  
			}   
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return salario;
		
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

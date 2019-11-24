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

import br.com.rh.model.Login;
import database.DBConnection;
import database.DBQuery;

public class LoginDAO extends DBQuery {
	
	private  Login login = null;
	
	public LoginDAO(Login Login) {
		this.setTable	("Login");
		this.setFields	(new String[]{"id","usuario","senha"});
		this.setKeyField("id");
		this.setLogin(Login);
	}
	
	public LoginDAO() {
		this.setTable	("Login");
		this.setFields	(new String[]{"id","usuario","senha"});
		this.setKeyField("id");
	}
	
	
		
	
	
	
	public void save(Login login) {
		Connection conexao = DBConnection.getConnection();
		try {
			PreparedStatement ps = conexao.prepareCall("INSERT INTO usuario (usuario, senha) VALUES (?,?)");
			ps.setString(1, login.getUsuario());
			ps.setString(2, login.getSenha());
			
			ps.execute();
			conexao.close();
			System.out.println(ps);
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public ArrayList<Login> list() {
		ArrayList<Login> logins = new ArrayList<Login>();
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from login");
			System.out.println(ps);
			while(rs.next()) {  
				Login c = new Login(); 
				c.setId(rs.getInt("id"));  
				c.setUsuario(rs.getString("usuario"));
				c.setSenha(rs.getString("senha"));
				
				logins.add(c);  
			}   
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return logins;
		
	}
	
	public boolean checkLogin(String usuario, String senha) {
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from login where usuario = '"+usuario+"' AND senha = '"+senha+"'");
			System.out.println(ps);
			return (rs.next());
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return (false);
		
	}
	public void trash() {
		// delete( this.getLogin().getId() );
		
		
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login Login) {
		this.login = Login;
	}
	
	
}

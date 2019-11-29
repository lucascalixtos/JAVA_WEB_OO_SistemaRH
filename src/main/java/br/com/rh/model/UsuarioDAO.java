package br.com.rh.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.rh.model.Usuario;
import database.DBConnection;
import database.DBQuery;

public class UsuarioDAO extends DBQuery {
	
	private  Usuario usuario = null;
	
	public UsuarioDAO(Usuario Usuario) {
		this.setTable	("login");
		this.setFields	(new String[]{"id","usuario", "senha"});
		this.setKeyField("id");
		this.setUsuario(Usuario);
	}
	
	public UsuarioDAO() {
		this.setTable	("login");
		this.setFields	(new String[]{"id","usuario", "senha"});
		this.setKeyField("id");
	}
	
	public  ArrayList<Usuario> listByLogin(String login) {
		
		ArrayList<Usuario> tempListUsuarios = new ArrayList<Usuario>();
		try {
			ResultSet rs = select("login = "+login);
			while (rs.next()) {
				Usuario tempUser = new Usuario();
				tempUser.setId( rs.getInt("id"));
				tempUser.setUsuario( rs.getString("usuario"));
				tempUser.setSenha( rs.getString("senha"));
				
				tempListUsuarios.add(tempUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListUsuarios );
	}
	
	public  ArrayList<Usuario> listByEmail(String email) {
		ArrayList<Usuario> tempListUsuarios = new ArrayList<Usuario>();
		try {
			ResultSet rs = select("email = "+ email);
			while (rs.next()) {
				Usuario tempUser = new Usuario();
				tempUser.setId( rs.getInt("id"));
				tempUser.setUsuario( rs.getString("usuario"));
				tempUser.setSenha( rs.getString("senha"));
				
				tempListUsuarios.add(tempUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListUsuarios );		
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
	
	public void save(Usuario usuario) {
		Connection conexao = DBConnection.getConnection();
		try {
			PreparedStatement ps = conexao.prepareCall("INSERT INTO login (usuario, senha) VALUES (?,?)");
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getSenha());
			
			ps.execute();
			conexao.close();
			System.out.println(ps);
			
		} catch (SQLException e) {
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public void update(Usuario usuario) {
		Connection conexao = DBConnection.getConnection();
		try {
			PreparedStatement ps = conexao.prepareCall("UPDATE login SET usuario = ?, senha = ?,  WHERE id = ?");
			ps.setString(1, usuario.getUsuario());
			ps.setString(2, usuario.getSenha());
			ps.setInt(3, usuario.getId());
						ps.execute();
			conexao.close();
			System.out.println(ps);
			
		} catch (SQLException e) {
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public List<Usuario> delete(Usuario usuario) {
		Connection conexao = DBConnection.getConnection();
		try {
			PreparedStatement ps = conexao.prepareCall("DELETE from login where id = ?");
			ps.setInt(1, usuario.getId());
						ps.execute();
			conexao.close();
			System.out.println(ps);
			
		} catch (SQLException e) {
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
		return null;
	}
	
	public ArrayList<Usuario> list() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from login");
			System.out.println(ps);
			while(rs.next()) {  
				Usuario user = new Usuario(); 
				user.setId(rs.getInt("id"));  
				user.setUsuario(rs.getString("usuario"));  	
				user.setSenha(rs.getString("senha")); 
				
				usuarios.add(user);  
			}   
			
		} catch (SQLException e) {
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return usuarios;
		
	}
	
	public ArrayList<Usuario> listById(int id) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from login where id="+id);
			System.out.println(ps);
			while(rs.next()) {  
				Usuario user = new Usuario(); 
				user.setId(rs.getInt("id"));  
				user.setUsuario(rs.getString("usuario"));
				user.setSenha(rs.getString("senha"));
				
				usuarios.add(user);  
			}   
			
		} catch (SQLException e) {
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return usuarios;
		
	}
	

	public Usuario getUsuario() {
		
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}

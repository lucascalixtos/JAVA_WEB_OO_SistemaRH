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

import br.com.rh.model.Funcionario;
import database.DBConnection;
import database.DBQuery;

public class FuncionarioDAO extends DBQuery {
	
	private  Funcionario funcionario = null;
	
	public FuncionarioDAO(Funcionario Funcionario) {
		this.setTable	("Funcionario");
		this.setFields	(new String[]{"id","nome", "data_nascimento", "sexo", "telefone", "email", "cpf", "ctps",
				"tipo_contrato","status","rg","cep","num_residencia","cargo","horario_entrada","horario_saida"});
		this.setKeyField("id");
		this.setFuncionario(Funcionario);
	}
	
	public FuncionarioDAO() {
		this.setTable	("Funcionario");
		this.setFields	(new String[]{"id","nome", "data_nascimento", "sexo", "telefone", "email", "cpf", "ctps",
				"tipo_contrato","status","rg","cep","num_residencia","cargo","horario_entrada","horario_saida"});
		this.setKeyField("id");
	}
	
	public  ArrayList<Funcionario> listByLogin(String login) {
		
		ArrayList<Funcionario> tempListFuncionarios = new ArrayList<Funcionario>();
		try {
			ResultSet rs = select("login = "+login);
			while (rs.next()) {
				Funcionario tempUser = new Funcionario();
				tempUser.setId( rs.getInt("id"));
				tempUser.setNome( rs.getString("nome"));
				tempUser.setDataNascimento( rs.getString("dataNascimento"));
				tempUser.setSexo( rs.getString("sexo"));
				tempUser.setTelefone( rs.getString("telefone"));
				tempUser.setEmail( rs.getString("email") );	
				tempUser.setCpf( rs.getString("cpf"));
				tempUser.setCtps( rs.getString("ctps"));
				tempUser.setTipoContrato( rs.getString("tipoContrato"));
				tempUser.setStatus( rs.getString("status"));
				tempUser.setRg( rs.getString("rg"));
				tempUser.setCep( rs.getString("cep"));
				tempUser.setNumResidencial( rs.getString("numResidencial"));
				tempUser.setCargo (rs.getString("cargo"));
				tempUser.setHorarioEntrada( rs.getString("horarioEntrada"));
				tempUser.setHorarioSaida( rs.getString("horarioSaida"));
				tempListFuncionarios.add(tempUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListFuncionarios );
	}
	
	public  ArrayList<Funcionario> listByEmail(String email) {
		ArrayList<Funcionario> tempListFuncionarios = new ArrayList<Funcionario>();
		try {
			ResultSet rs = select("email = "+ email);
			while (rs.next()) {
				Funcionario tempUser = new Funcionario();
				tempUser.setId( rs.getInt("id"));
				tempUser.setNome( rs.getString("nome"));
				tempUser.setDataNascimento( rs.getString("dataNascimento"));
				tempUser.setSexo( rs.getString("sexo"));
				tempUser.setTelefone( rs.getString("telefone"));
				tempUser.setEmail( rs.getString("email") );	
				tempUser.setCpf( rs.getString("cpf"));
				tempUser.setCtps( rs.getString("ctps"));
				tempUser.setTipoContrato( rs.getString("tipoContrato"));
				tempUser.setStatus( rs.getString("status"));
				tempUser.setRg( rs.getString("rg"));
				tempUser.setCep( rs.getString("cep"));
				tempUser.setNumResidencial( rs.getString("numResidencial"));
				tempUser.setCargo (rs.getString("cargo"));
				tempUser.setHorarioEntrada( rs.getString("horarioEntrada"));
				tempUser.setHorarioSaida( rs.getString("horarioSaida"));
				tempListFuncionarios.add(tempUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListFuncionarios );		
	}

	/*public ArrayList<Funcionario> listAll() {
		ArrayList<Funcionario> tempListFuncionarios = new ArrayList<Funcionario>();
		try {
			ResultSet rs = select();
			while (rs.next()) {
				Funcionario tempUser = new Funcionario();
				tempUser.setId( rs.getInt("id"));
				tempUser.setNome( rs.getString("nome"));
				tempUser.setDataNascimento( rs.getString("dataNascimento"));
				tempUser.setSexo( rs.getString("sexo"));
				tempUser.setTelefone( rs.getString("telefone"));
				tempUser.setEmail( rs.getString("email") );	
				tempUser.setCpf( rs.getString("cpf"));
				tempUser.setCtps( rs.getString("ctps"));
				tempUser.setTipoContrato( rs.getString("tipoContrato"));
				tempUser.setStatus( rs.getString("status"));
				tempUser.setRg( rs.getString("rg"));
				tempUser.setCep( rs.getString("cep"));
				tempUser.setNumResidencial( rs.getString("numResidencial"));
				tempUser.setCargo (rs.getString("cargo"));
				tempUser.setHorarioEntrada( rs.getString("horarioEntrada"));
				tempUser.setHorarioSaida( rs.getString("horarioSaida"));
				tempListFuncionarios.add(tempUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( tempListFuncionarios );		
	}*/
	
	public boolean checkLogin(String user, String pass){
		try {
			ResultSet rs = select("login = '"+ user +"' AND pass = '"+pass+"'");
			return (rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ( false );
	}
	
	public void save(Funcionario funcionario) {
		Connection conexao = DBConnection.getConnection();
		try {
			PreparedStatement ps = conexao.prepareCall("INSERT INTO funcionario (nome, data_nascimento, sexo, telefone,"
					+ "email, cpf, ctps, tipo_contrato, status, rg, cep, num_residencia, cargo, horario_entrada, horario_saida, salario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getDataNascimento());
			ps.setString(3, funcionario.getSexo());
			ps.setString(4, funcionario.getTelefone());
			ps.setString(5, funcionario.getEmail());
			ps.setString(6, funcionario.getCpf());
			ps.setString(7, funcionario.getCtps());
			ps.setString(8, funcionario.getTipoContrato());
			ps.setString(9, "Ativo");
			ps.setString(10, funcionario.getRg());
			ps.setString(11, funcionario.getCep());
			ps.setString(12, funcionario.getNumResidencial());
			ps.setString(13, funcionario.getCargo());
			ps.setString(14, funcionario.getHorarioEntrada());
			ps.setString(15, funcionario.getHorarioSaida());
			ps.setFloat(16, funcionario.getSalario());
			ps.execute();
			conexao.close();
			System.out.println(ps);
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public void update(Funcionario funcionario) {
		Connection conexao = DBConnection.getConnection();
		try {
			PreparedStatement ps = conexao.prepareCall("UPDATE funcionario SET nome = ?, data_nascimento = ?, sexo = ?, telefone = ?,"
					+ "email = ?, cpf = ?, ctps = ?, tipo_contrato = ?, status = ?, rg = ?, cep = ?, num_residencia = ?, cargo = ?, horario_entrada = ?, horario_saida = ?, salario = ? WHERE id = ?");
			ps.setString(1, funcionario.getNome());
			ps.setString(2, funcionario.getDataNascimento());
			ps.setString(3, funcionario.getSexo());
			ps.setString(4, funcionario.getTelefone());
			ps.setString(5, funcionario.getEmail());
			ps.setString(6, funcionario.getCpf());
			ps.setString(7, funcionario.getCtps());
			ps.setString(8, funcionario.getTipoContrato());
			ps.setString(9, "Ativo");
			ps.setString(10, funcionario.getRg());
			ps.setString(11, funcionario.getCep());
			ps.setString(12, funcionario.getNumResidencial());
			ps.setString(13, funcionario.getCargo());
			ps.setString(14, funcionario.getHorarioEntrada());
			ps.setString(15, funcionario.getHorarioSaida());
			ps.setFloat(16, funcionario.getSalario());
			ps.setInt(17, funcionario.getId());
			ps.execute();
			conexao.close();
			System.out.println(ps);
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}
	
	public ArrayList<Funcionario> list() {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from funcionario");
			System.out.println(ps);
			while(rs.next()) {  
				Funcionario func = new Funcionario(); 
				func.setId(rs.getInt("id"));  
				func.setNome(rs.getString("nome"));  	
				func.setDataNascimento(rs.getString("data_nascimento")); 
				func.setSexo(rs.getString("sexo")); 
				func.setTelefone(rs.getString("telefone"));
				func.setEmail(rs.getString("email")); 
				func.setCpf(rs.getString("cpf")); 
				func.setCtps(rs.getString("ctps")); 
				func.setTipoContrato(rs.getString("tipo_contrato")); 
				func.setStatus(rs.getString("status")); 
				func.setRg(rs.getString("rg")); 
				func.setCep(rs.getString("cep")); 
				func.setNumResidencial(rs.getString("num_residencia"));
				func.setCargo(rs.getString("cargo")); 
				func.setHorarioEntrada(rs.getString("horario_entrada")); 
				func.setHorarioSaida(rs.getString("horario_saida")); 
				func.setSalario(rs.getFloat("salario")); 
				funcionarios.add(func);  
			}   
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return funcionarios;
		
	}
	
	public ArrayList<Funcionario> listById(int id) {
		ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
		Connection conexao = DBConnection.getConnection();
		try {
			Statement ps = conexao.createStatement();
			ResultSet rs = ps.executeQuery("select * from funcionario where id="+id);
			System.out.println(ps);
			while(rs.next()) {  
				Funcionario func = new Funcionario(); 
				func.setId(rs.getInt("id"));  
				func.setNome(rs.getString("nome"));  	
				func.setDataNascimento(rs.getString("data_nascimento")); 
				func.setSexo(rs.getString("sexo")); 
				func.setTelefone(rs.getString("telefone"));
				func.setEmail(rs.getString("email")); 
				func.setCpf(rs.getString("cpf")); 
				func.setCtps(rs.getString("ctps")); 
				func.setTipoContrato(rs.getString("tipo_contrato")); 
				func.setStatus(rs.getString("status")); 
				func.setRg(rs.getString("rg")); 
				func.setCep(rs.getString("cep")); 
				func.setNumResidencial(rs.getString("num_residencia"));
				func.setCargo(rs.getString("cargo")); 
				func.setHorarioEntrada(rs.getString("horario_entrada")); 
				func.setHorarioSaida(rs.getString("horario_saida"));
				func.setSalario(rs.getFloat("salario"));
				funcionarios.add(func);  
			}   
			
		} catch (SQLException e) {
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
		}
		return funcionarios;
		
	}
	
	public void trash() {
		// delete( this.getFuncionario().getId() );
		this.getFuncionario().setStatus("N");
		update(this.getFuncionario().toArray());
		
	}

	public Funcionario getFuncionario() {
		
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}

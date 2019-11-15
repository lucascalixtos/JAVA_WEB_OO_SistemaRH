package br.com.rh.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import br.com.rh.model.Funcionario;
import database.DBQuery;

public class FuncionarioDAO extends DBQuery {
	
	private  Funcionario Funcionario = null;
	
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

	public ArrayList<Funcionario> listAll() {
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
		if ( this.getFuncionario().getId() <= 0) {
			insert(this.getFuncionario().toArray());
		}else {
			update(this.getFuncionario().toArray());
		}
	}
	
	public void trash() {
		// delete( this.getFuncionario().getId() );
		this.getFuncionario().setStatus("N");
		update(this.getFuncionario().toArray());
		
	}

	public Funcionario getFuncionario() {
		return Funcionario;
	}

	public void setFuncionario(Funcionario Funcionario) {
		this.Funcionario = Funcionario;
	}
	
	
}

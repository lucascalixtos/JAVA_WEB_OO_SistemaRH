package br.com.rh.model;

import java.util.ArrayList;


public class Funcionario {
	


	private int    id;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String telefone;
	private String email;
	private String cpf;
	private String ctps;
	private String tipoContrato;
	private String status;
	private String rg;
	private String cep;
	private String numResidencial;
	private String cargo;
	private String horarioEntrada;
	private String horarioSaida;
	
	
	public Funcionario() {
	
	}
	
	public Funcionario(int id, String nome, String dataNascimento, String sexo, String telefone, String email, String cpf, String ctps, 
			String tipoContrato, String status, String rg, String cep, String numResidencial, String cargo, String horarioEntrada, String horarioSaida) {
		this.id =  id;
		this.nome =  nome;
		this.dataNascimento =  dataNascimento;
		this.sexo = sexo;
		this.telefone =  telefone;
		this.email =  email;
		this.cpf =  cpf;
		this.ctps = ctps;
		this.tipoContrato = tipoContrato;
		this.status = status;
		this.rg = rg;
		this.cep = cep;
		this.numResidencial = numResidencial;
		this.cargo = cargo;
		this.horarioEntrada = horarioEntrada;
		this.horarioSaida = horarioSaida;
		
		
	}
	
	
	public void save() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.save();
	}
	
	public void delete() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.delete(this.getId());
	}
	
	public ArrayList<Funcionario> listAll() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return ( funcionarioDAO.listAll());
	}
	
	/*public boolean checkLogin() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		return ( funcionarioDAO.checkLogin( this.getLogin(), this.getPass()));	
	}*/
	
	public String[] toArray() {
		return(
		new String[] { 
				new Integer(  this.getId() ).toString(), 
				this.getNome(),
				this.getDataNascimento(),
				this.getEmail(), 
				this.getSexo(),
				this.getTelefone(),
				this.getCpf(),
				this.getCtps(),
				this.getTipoContrato(),
				this.getStatus(),
				this.getRg(),
				this.getCep(),
				this.getNumResidencial(),
				this.getCargo(),
				this.getHorarioEntrada(),
				this.getHorarioSaida()	
		});
	}
	
	
	public String toString() {
		return(
				new Integer(  this.getId() ).toString()+ 
				this.getNome()+ 
				this.getDataNascimento()+
				this.getEmail()+ 
				this.getSexo()+ 
				this.getTelefone()+
				this.getCpf()+
				this.getCtps()+
				this.getTipoContrato()+
				this.getStatus()+
				this.getRg()+
				this.getCep()+
				this.getNumResidencial()+
				this.getCargo()+
				this.getHorarioEntrada()+
				this.getHorarioSaida()
		);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumResidencial() {
		return numResidencial;
	}

	public void setNumResidencial(String numResidencial) {
		this.numResidencial = numResidencial;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getHorarioEntrada() {
		return horarioEntrada;
	}

	public void setHorarioEntrada(String horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public String getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}
	
	
	
}

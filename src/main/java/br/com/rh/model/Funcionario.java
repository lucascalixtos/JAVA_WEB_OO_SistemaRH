package br.com.rh.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario implements Serializable, Base {
	
	
	@Override
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((ctps == null) ? 0 : ctps.hashCode());
		result = prime * result
				+ ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((horarioEntrada == null) ? 0 : horarioEntrada.hashCode());
		result = prime * result
				+ ((horarioSaida == null) ? 0 : horarioSaida.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((numResidencial == null) ? 0 : numResidencial.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result
				+ ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result
				+ ((tipoContrato == null) ? 0 : tipoContrato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (ctps == null) {
			if (other.ctps != null)
				return false;
		} else if (!ctps.equals(other.ctps))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (horarioEntrada == null) {
			if (other.horarioEntrada != null)
				return false;
		} else if (!horarioEntrada.equals(other.horarioEntrada))
			return false;
		if (horarioSaida == null) {
			if (other.horarioSaida != null)
				return false;
		} else if (!horarioSaida.equals(other.horarioSaida))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numResidencial == null) {
			if (other.numResidencial != null)
				return false;
		} else if (!numResidencial.equals(other.numResidencial))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (tipoContrato == null) {
			if (other.tipoContrato != null)
				return false;
		} else if (!tipoContrato.equals(other.tipoContrato))
			return false;
		return true;
	}

	private static final long serialVersionUID = 1L;
	/**
	*
	*/
	
	@Id
	@GeneratedValue
	@Column(name="codigo")
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
	
	
	/*public void save() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.save();
	}*/
	
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

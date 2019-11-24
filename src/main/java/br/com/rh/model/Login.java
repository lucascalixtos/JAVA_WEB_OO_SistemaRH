package br.com.rh.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Login implements Serializable {
	
	
	private int id;
	private String usuario;
	private String senha;
	
	public Login(){
		
	}
	
	public Login(int id, String usuario , String senha){
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	
	
	public void delete() {
		LoginDAO LoginDAO = new LoginDAO();
		LoginDAO.delete(this.getId());
	}
	
	public String[] toArray() {
		return(
		new String[] { 
				new Integer(  this.getId() ).toString(), 
				this.getUsuario(),
				this.getSenha()
		});
	}
	
	public String toString() {
		return(
				new Integer(  this.getId() ).toString()+
				this.getUsuario()+
				this.getSenha()
		);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Login other = (Login) obj;
		if (id != other.id)
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	
}

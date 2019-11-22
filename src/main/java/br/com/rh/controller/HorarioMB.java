package br.com.rh.controller;


import java.io.Serializable;





import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rh.model.Horario;
import br.com.rh.model.Horario;
import br.com.rh.model.HorarioDAO;
import br.com.rh.model.Funcionario;
import br.com.rh.model.FuncionarioDAO;

@Named("horarioBean")
@SessionScoped
public class HorarioMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Horario horario;
	
	private List<Horario> horarios = new ArrayList<>();
	private List<Horario> horarioRetorno;
	
	public String adicionar(){
		horarios.add(horario);
		new HorarioDAO().save(horario);
		limpar();
		return null;
	}
	
public String selecionar(){
		
		 horarioRetorno = new HorarioDAO().list();
		return null;
	}
	
	private void limpar(){
		horario = new Horario();
	}
	
	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario Horario) {
		this.horario = Horario;
	}

	public List<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<Horario> Horarios, List<Horario> horarios) {
		this.horarios = horarios;
	}

	public List<Horario> getHorarioRetorno() {
		selecionar();
		return horarioRetorno;
	}
	

}

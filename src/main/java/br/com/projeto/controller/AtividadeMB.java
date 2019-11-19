package br.com.projeto.controller;

import java.io.Serializable;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projeto.model.Atividade;
import br.com.projeto.model.TipoAtividade;

 @Named("AtividadeMB")
 @SessionScoped
 public class AtividadeMB implements Serializable{
	 
	 private static final long serialVersionUID = 1L;
	 @Inject
	 private Atividade atividade;
	 
	public TipoAtividade[] getAtividades() {
		return TipoAtividade.values();
	}
	
	public Atividade getAtividade() {
		return atividade;
	}
	
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
	 
	 
 }
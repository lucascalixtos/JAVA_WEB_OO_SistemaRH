package br.com.rh.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.rh.controller.Pessoa;

@SuppressWarnings("unused")
@Named("bean")
@ApplicationScoped
public class PessoaMB implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Inject
	private Pessoa pessoa;
	
	private List<Pessoa> pessoas = new ArrayList<>();
	
	public String adicionar(){
		pessoas.add(pessoa);
		
		limpar();
		
		return "paginas/Sucesso";
	}
	
	private void limpar(){
		
		pessoa = new Pessoa();
		
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	
	
}

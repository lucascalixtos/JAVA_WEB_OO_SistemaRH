package br.com.rh.model;

public enum TipoAtividade{
	APRESENTACAO("Apresentação"), CURSO("Curso"),MINUCURSO("Minicurso"),
	PALESTRA("Palestra"), SEMINARIO("Seminario"), SIMPOSIO("Simpósio"),
	OUTROS("Outras");
	
	private String descricao;
	
	TipoAtividade(String descricao){
		this.descricao = descricao;
		
	}
	public String getDescricao(){
		return this.descricao;
	}
	
}
package br.com.petshop.modelo;

public enum TipoUnidade {
	quilograma("kg"),
	grama("gr"),
	peca("Peça(s)"),
	pacote("Pacote(s)"),
	litro("Litro(s)"),
	mililitro("ml");
	
	private String descricao;
	
	TipoUnidade(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
}

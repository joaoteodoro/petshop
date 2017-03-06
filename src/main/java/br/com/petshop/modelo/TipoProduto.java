package br.com.petshop.modelo;

public enum TipoProduto {
	compra("Compra"),
	venda("Venda");
	
	private String descricao;
	
	TipoProduto(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
}

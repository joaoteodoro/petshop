package br.com.petshop.modelo;

public enum FormaPagamento {
	cartaoCredito("Cartão de Crédito"),
	cartaoDebito("Cartão de Débito"),
	aVista("A Vista"), //dinheiro
	boleto("Boleto Bancário"),
	cheque("Cheque"),
	parcelado("Parcelado"),
	aReceber("A Receber"); //notinha
	
	private String descricao;
	
	FormaPagamento(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao(){
		return descricao;
	}
}

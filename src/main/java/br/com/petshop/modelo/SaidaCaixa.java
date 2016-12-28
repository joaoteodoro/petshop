package br.com.petshop.modelo;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "saidaCaixa")
@ManagedBean(name = "saidaCaixa")
public class SaidaCaixa {

	@Id
	@Column(name = "idSaidaCaixa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSaidaCaixa;

	private Date dtSaida;
	private String descricao;
	private float valor;

	public int getIdSaidaCaixa() {
		return idSaidaCaixa;
	}

	public void setIdSaidaCaixa(int idSaidaCaixa) {
		this.idSaidaCaixa = idSaidaCaixa;
	}

	public Date getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Date dtSaida) {
		this.dtSaida = dtSaida;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

}

package br.com.petshop.modelo;

import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="telefone")
@ManagedBean(name="telefone")
public class Telefone {
	
	@Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Long numero;
	private boolean whatsapp;
	
	@ManyToOne
	private Pessoa pessoa;
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public boolean isWhatsapp() {
		return whatsapp;
	}
	public void setWhatsapp(boolean whatsapp) {
		this.whatsapp = whatsapp;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}

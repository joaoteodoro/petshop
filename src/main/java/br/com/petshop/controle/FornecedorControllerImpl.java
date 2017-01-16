package br.com.petshop.controle;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.dao.FornecedorDAO;
import br.com.petshop.modelo.Fornecedor;
import br.com.petshop.modelo.Telefone;

//@Service
//@Component
@ManagedBean(name = "fornecedorController")
//@RequestScoped
//@Transactional
//@Controller
//@SessionScoped
public class FornecedorControllerImpl implements FornecedorController {

	@Autowired
	FornecedorDAO fornecedorDao;
	
	//@Autowired
	private Fornecedor fornecedor;
	
	public FornecedorControllerImpl(){
		this.fornecedor = new Fornecedor();
	}
	
	//private List<Fornecedor> fornecedoresFiltrados;
	
//	@PostConstruct
//	public void inicializar() {
//		this.fornecedor = new Fornecedor();
//	}

//	public List<Fornecedor> getFornecedoresFiltrados() {
//		return fornecedoresFiltrados;
//	}
//
//	public void setFornecedoresFiltrados(List<Fornecedor> fornecedoresFiltrados) {
//		this.fornecedoresFiltrados = fornecedoresFiltrados;
//	}

	

	public void setFornecedorDao(FornecedorDAO fornecedorDao) {
		this.fornecedorDao = fornecedorDao;
	}

	public void adicionarFornecedor(Fornecedor f) {
		this.fornecedorDao.adicionarFornecedor(f);
	}

	public List<Fornecedor> listarFornecedores() {
		return this.fornecedorDao.listarFornecedores();
	}
	
	public String editaFornecedor(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
		this.fornecedor.setTelefones(Arrays.asList(new Telefone(), new Telefone()));
		return "fornecedor";
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorDAO getFornecedorDao() {
		return fornecedorDao;
	}
	
	@Override
	//@Transactional
	public String gravar() {
		fornecedorDao.gravar(this.fornecedor);
		return "fornecedores";
	}

}

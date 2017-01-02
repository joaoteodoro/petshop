package br.com.petshop.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.dao.FornecedorDAO;
import br.com.petshop.dao.UsuarioDAO;
import br.com.petshop.modelo.Fornecedor;
import br.com.petshop.modelo.Usuario;

//@Service
//@Component
@ManagedBean(name = "fornecedorController")
@RequestScoped
@Transactional
@Controller
public class FornecedorControllerImpl implements FornecedorController {

	@Autowired
	FornecedorDAO fornecedorDAO;

	public void setUsuarioDao(FornecedorDAO fornecedorDAO) {
		this.fornecedorDAO = fornecedorDAO;
	}

	@Override
	public void adicionarFornecedor(Fornecedor f) {
		this.fornecedorDAO.adicionarFornecedor(f);
	}

	@Override
	public List<Fornecedor> listarFornecedores() {
		return this.fornecedorDAO.listarFornecedores();
	}

}

package br.com.petshop.controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.EnderecoDAO;
import br.com.petshop.dao.EstadoDAO;
import br.com.petshop.dao.FornecedorDAO;
import br.com.petshop.dao.TelefoneDAO;
import br.com.petshop.modelo.Estado;
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
	
	@Autowired
	TelefoneDAO telefoneDao;
	
	@Autowired
	EnderecoDAO enderecoDao;
	
	@Autowired
	EstadoDAO estadoDao;	
	
	private Fornecedor fornecedor;
	
	public FornecedorControllerImpl(){
		this.fornecedor = new Fornecedor();
	}
	
	public void setFornecedorDao(FornecedorDAO fornecedorDao) {
		this.fornecedorDao = fornecedorDao;
	}

	public List<Fornecedor> listaFornecedores() {
		return this.fornecedorDao.listaFornecedores();
	}	
	
	public String editaFornecedor(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
		editaTelefones();
		
		return "fornecedor";
	}
	
	public void editaTelefones(){
		if(fornecedor.getTelefones() == null || fornecedor.getTelefones().isEmpty()){
			this.fornecedor.setTelefones(Arrays.asList(new Telefone(), new Telefone()));
		}else if(fornecedor.getTelefones() != null && fornecedor.getTelefones().size() == 1){
			this.fornecedor.getTelefones().add(new Telefone());
		}
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
	
	public TelefoneDAO getTelefoneDao() {
		return telefoneDao;
	}

	public void setTelefoneDao(TelefoneDAO telefoneDao) {
		this.telefoneDao = telefoneDao;
	}

	public EnderecoDAO getEnderecoDao() {
		return enderecoDao;
	}

	public void setEnderecoDao(EnderecoDAO enderecoDao) {
		this.enderecoDao = enderecoDao;
	}

	@Override
	public String grava() {
		validaEndereco();
		if(this.fornecedor.getIdPessoa() != 0){
			fornecedorDao.altera(this.fornecedor);
		}else{
			fornecedorDao.inclui(this.fornecedor);
		}
		validaTelefones();
		return "fornecedores";
	}
	
	private void validaTelefones(){
		//excluir registro em branco
		Telefone segundoTelefone = fornecedor.getTelefones().get(1);
		if(segundoTelefone.getNumero() == null || "".equals(segundoTelefone.getNumero())){
			if(segundoTelefone.getId() != 0){
				segundoTelefone.setPessoa(null);
				telefoneDao.remove(segundoTelefone);
			}
			this.fornecedor.getTelefones().remove(1);
		}
		
		//alterar ou incluir registros
		for (Telefone telefone : this.fornecedor.getTelefones()) {
			telefone.setPessoa(fornecedor);
			if(telefone.getId() != 0){
				telefoneDao.altera(telefone);
			}else{
				telefoneDao.inclui(telefone);
			}
			telefone.setPessoa(fornecedor);
		}
	}
	
	private void validaEndereco(){
		if(this.fornecedor.getEndereco().getId() != 0){
			enderecoDao.altera(fornecedor.getEndereco());
		}else{
			enderecoDao.inclui(fornecedor.getEndereco());
		}
	}
	
	public List<SelectItem> selectItensEstados(){
		List<SelectItem> itens = new ArrayList<>();
		for (Estado estado : estadoDao.listaEstados()) {
			itens.add(new SelectItem(estado.getId(), estado.getNome()));
		} 
		return itens;
	}

	@Override
	public String novo() {
		this.fornecedor = new Fornecedor();
		return "fornecedor";
	}

}

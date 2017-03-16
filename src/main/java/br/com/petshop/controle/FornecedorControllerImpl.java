package br.com.petshop.controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.EnderecoDAO;
import br.com.petshop.dao.EstadoDAO;
import br.com.petshop.dao.FornecedorDAO;
import br.com.petshop.dao.FornecedorDAOImpl;
import br.com.petshop.dao.TelefoneDAO;
import br.com.petshop.modelo.Endereco;
import br.com.petshop.modelo.Estado;
import br.com.petshop.modelo.Fornecedor;
import br.com.petshop.modelo.Telefone;
import br.com.petshop.utils.StringUtils;

@ManagedBean(name = "fornecedorController")
public class FornecedorControllerImpl implements FornecedorController {

	@Autowired
	FornecedorDAOImpl fornecedorDao;
	
	@Autowired
	TelefoneDAO telefoneDao;
	
	@Autowired
	EnderecoDAO enderecoDao;
	
	@Autowired
	EstadoDAO estadoDao;	
	
	private Fornecedor fornecedor;
	
	private List<Fornecedor> fornecedoresFiltrados;
	
	public FornecedorControllerImpl(){
		this.fornecedor = new Fornecedor();
	}

	public List<Fornecedor> listaFornecedores() {
		//return this.fornecedorDao.listaFornecedores();
		return this.fornecedorDao.getList();
	}
	
	public String novo() {
		this.fornecedor = new Fornecedor();
		return "fornecedor";
	}
	
	public String editaFornecedor(Fornecedor fornecedor){
		this.fornecedor = fornecedor;
		editaTelefones();
		
		return "fornecedor";
	}
	
	public String removeFornecedor(Fornecedor f){
		removerTelefones(f.getTelefones());
		//fornecedorDao.remove(f);
		fornecedorDao.remover((long) f.getIdPessoa());
		//fornecedorDao.remove(Fornecedor.class, (long) f.getIdPessoa());
		removerEndereco(f.getEndereco());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro excluído com sucesso!"));
		return "fornecedores";
	}
	
	public void removerTelefones(List<Telefone> telefones){
		for (Telefone telefone : telefones) {
			if(telefone != null && telefone.getId() != 0){
				telefoneDao.remove(telefone);
			}
		}
	}
	
	public void removerEndereco(Endereco e){
		enderecoDao.remove(e);
	}

	@Override
	public String grava() {
		boolean ehNovoRegistro = true;
		validaEndereco();
		if(this.fornecedor.getIdPessoa() != 0){
			ehNovoRegistro = false;
			validaTelefones();
		}
		fornecedor.setCnpj(StringUtils.somenteNumeros(fornecedor.getCnpj()));
		if(this.fornecedor.getIdPessoa() != 0){
			fornecedorDao.atualizar(this.fornecedor);
			//fornecedorDao.altera(this.fornecedor);
		}else{
			fornecedorDao.salvar(this.fornecedor);
			//fornecedorDao.inclui(this.fornecedor);
		}
		if(ehNovoRegistro){
			validaTelefones();
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro gravado com sucesso!"));
		
		//this.fornecedor = fornecedorDao.buscaPorId(this.fornecedor.getIdPessoa());
		this.fornecedor = (Fornecedor) fornecedorDao.encontrar((long)this.fornecedor.getIdPessoa());
		return editaFornecedor(fornecedor);
	}
	
	public void editaTelefones(){
		if(fornecedor.getTelefones() == null || fornecedor.getTelefones().isEmpty()){
			this.fornecedor.setTelefones(Arrays.asList(new Telefone(), new Telefone()));
		}else if(fornecedor.getTelefones() != null && fornecedor.getTelefones().size() == 1){
			this.fornecedor.getTelefones().add(new Telefone());
		}
	}
	
	private void validaTelefones(){
		//excluir registro em branco
		Telefone segundoTelefone = fornecedor.getTelefones().get(1);
		if(segundoTelefone.getNumero() == null || "".equals(segundoTelefone.getNumero())){
			if(segundoTelefone.getId() != 0){
				segundoTelefone.setPessoa(null);
				telefoneDao.remove(segundoTelefone);
			}
			this.fornecedor.getTelefones().set(1, null);
		}
		
		//alterar ou incluir registros
		for (Telefone telefone : this.fornecedor.getTelefones()) {
			if(telefone!= null ){
				telefone.setNumero(StringUtils.somenteNumeros(telefone.getNumero()));
				telefone.setPessoa(fornecedor);
				if(telefone.getId() != 0){
					telefoneDao.altera(telefone);
				}else{
					telefoneDao.inclui(telefone);
				}
			}
		}
	}
	
	private void validaEndereco(){
		fornecedor.getEndereco().setCep(StringUtils.somenteNumeros(fornecedor.getEndereco().getCep()));
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

	public void setFornecedorDao(FornecedorDAOImpl fornecedorDao) {
		this.fornecedorDao = fornecedorDao;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FornecedorDAOImpl getFornecedorDao() {
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

	public EstadoDAO getEstadoDao() {
		return estadoDao;
	}

	public void setEstadoDao(EstadoDAO estadoDao) {
		this.estadoDao = estadoDao;
	}

	public List<Fornecedor> getFornecedoresFiltrados() {
		return fornecedoresFiltrados;
	}

	public void setFornecedoresFiltrados(List<Fornecedor> fornecedoresFiltrados) {
		this.fornecedoresFiltrados = fornecedoresFiltrados;
	}

}

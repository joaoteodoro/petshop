package br.com.petshop.controle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.petshop.dao.EnderecoDAOImpl;
import br.com.petshop.dao.EstadoDAOImpl;
import br.com.petshop.dao.FornecedorDAOImpl;
import br.com.petshop.dao.TelefoneDAOImpl;
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
	TelefoneDAOImpl telefoneDao;
	
	@Autowired
	EnderecoDAOImpl enderecoDao;
	
	@Autowired
	EstadoDAOImpl estadoDao;	
	
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
		fornecedorDao.remover( f.getIdPessoa());
		//fornecedorDao.remove(Fornecedor.class,  f.getIdPessoa());
		removerEndereco(f.getEndereco());
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Registro excluído com sucesso!"));
		return "fornecedores";
	}
	
	public void removerTelefones(List<Telefone> telefones){
		for (Telefone telefone : telefones) {
			if(telefone != null && telefone.getId() != null){
				telefoneDao.remover(telefone.getId());
			}
		}
	}
	
	public void removerEndereco(Endereco e){
		enderecoDao.remover(e.getId());
	}

	@Override
	public String grava() {
		boolean ehNovoRegistro = true;
		validaEndereco();
		if(this.fornecedor.getIdPessoa() != null){
			ehNovoRegistro = false;
			validaTelefones();
		}
		fornecedor.setCnpj(StringUtils.somenteNumeros(fornecedor.getCnpj()));
		if(this.fornecedor.getIdPessoa() != null){
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
		this.fornecedor = (Fornecedor) fornecedorDao.encontrar(this.fornecedor.getIdPessoa());
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
			if(segundoTelefone.getId() != null){
				segundoTelefone.setPessoa(null);
				telefoneDao.remover(segundoTelefone.getId());
			}
			this.fornecedor.getTelefones().set(1, null);
		}
		
		//alterar ou incluir registros
		for (Telefone telefone : this.fornecedor.getTelefones()) {
			if(telefone!= null ){
				telefone.setNumero(StringUtils.somenteNumeros(telefone.getNumero()));
				telefone.setPessoa(fornecedor);
				if(telefone.getId() != null){
					telefoneDao.atualizar(telefone);
				}else{
					telefoneDao.salvar(telefone);
				}
			}
		}
	}
	
	private void validaEndereco(){
		fornecedor.getEndereco().setCep(StringUtils.somenteNumeros(fornecedor.getEndereco().getCep()));
		if(this.fornecedor.getEndereco().getId() != null){
			enderecoDao.atualizar(fornecedor.getEndereco());
		}else{
			enderecoDao.salvar(fornecedor.getEndereco());
		}
	}
	
	public List<SelectItem> selectItensEstados(){
		List<SelectItem> itens = new ArrayList<>();
		for (Estado estado : estadoDao.getList()) {
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

	public TelefoneDAOImpl getTelefoneDao() {
		return telefoneDao;
	}

	public void setTelefoneDao(TelefoneDAOImpl telefoneDao) {
		this.telefoneDao = telefoneDao;
	}

	public EnderecoDAOImpl getEnderecoDao() {
		return enderecoDao;
	}

	public void setEnderecoDao(EnderecoDAOImpl enderecoDao) {
		this.enderecoDao = enderecoDao;
	}

	public EstadoDAOImpl getEstadoDao() {
		return estadoDao;
	}

	public void setEstadoDao(EstadoDAOImpl estadoDao) {
		this.estadoDao = estadoDao;
	}

	public List<Fornecedor> getFornecedoresFiltrados() {
		return fornecedoresFiltrados;
	}

	public void setFornecedoresFiltrados(List<Fornecedor> fornecedoresFiltrados) {
		this.fornecedoresFiltrados = fornecedoresFiltrados;
	}

}

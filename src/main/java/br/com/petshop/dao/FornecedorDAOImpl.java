package br.com.petshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.Fornecedor;

@Repository
@Service
@Transactional
public class FornecedorDAOImpl implements FornecedorDAO{
	
	@PersistenceContext
	EntityManager entityManagerFactory;
	
	private static final Logger logger = LoggerFactory.getLogger(FornecedorDAOImpl.class);
	 
	public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}
	
	@Override
	public void adicionarFornecedor(Fornecedor f) {
		entityManagerFactory.persist(f);
	}

	@Override
	public List<Fornecedor> listarFornecedores() {
		List<Fornecedor> fornecedores =  entityManagerFactory.createQuery("from Fornecedor").getResultList();
        return fornecedores;
	}
	
	@Override
	public void gravar(Fornecedor f) {
		if(f.getIdPessoa() != 0){
			entityManagerFactory.merge(f);
		}else{
			entityManagerFactory.persist(f);
		}
	}
 
}

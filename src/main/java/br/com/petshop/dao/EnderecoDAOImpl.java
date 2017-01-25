package br.com.petshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.Endereco;

@Repository
@Service
@Transactional
public class EnderecoDAOImpl implements EnderecoDAO{
	
	@PersistenceContext
	EntityManager entityManagerFactory;
	
	//private static final Logger logger = LoggerFactory.getLogger(FornecedorDAOImpl.class);
	 
	public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<Endereco> listaEnderecos() {
		@SuppressWarnings("unchecked")
		List<Endereco> enderecos =  entityManagerFactory.createQuery("from Endereco").getResultList();
        return enderecos;
	}
	
	public void altera(Endereco e){
		entityManagerFactory.merge(e);
	}
	
	public void inclui(Endereco e) {
		entityManagerFactory.persist(e);
	}
 
}

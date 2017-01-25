package br.com.petshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.Endereco;
import br.com.petshop.modelo.Estado;

@Repository
@Service
@Transactional
public class EstadoDAOImpl implements EstadoDAO{
	
	@PersistenceContext
	EntityManager entityManagerFactory;
	
	//private static final Logger logger = LoggerFactory.getLogger(FornecedorDAOImpl.class);
	 
	public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<Estado> listaEstados() {
		@SuppressWarnings("unchecked")
		List<Estado> estados =  entityManagerFactory.createQuery("from Estado").getResultList();
        return estados;
	}
	
	public void altera(Estado e){
		entityManagerFactory.merge(e);
	}
	
	public void inclui(Estado e) {
		entityManagerFactory.persist(e);
	}
 
}

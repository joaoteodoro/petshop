package br.com.petshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.ProdutoCompra;

@Repository
@Service
@Transactional
public class ProdutoCompraDAOImpl implements ProdutoCompraDAO{
	
	@PersistenceContext
	EntityManager entityManagerFactory;
	
	//private static final Logger logger = LoggerFactory.getLogger(FornecedorDAOImpl.class);
	 
	public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public List<ProdutoCompra> listaProdutosCompra() {
		@SuppressWarnings("unchecked")
		List<ProdutoCompra> produtosCompra =  entityManagerFactory.createQuery("from ProdutoCompra").getResultList();
        return produtosCompra;
	}
	
	public void altera(ProdutoCompra pc){
		entityManagerFactory.merge(pc);
	}
	
	public void inclui(ProdutoCompra pc) {
		entityManagerFactory.persist(pc);
	}
	
	public ProdutoCompra buscaPorId(int idProduto){
		return entityManagerFactory.find(ProdutoCompra.class, idProduto);
	}
 
	public void remove(ProdutoCompra pc){
		entityManagerFactory.remove(entityManagerFactory.getReference(ProdutoCompra.class, pc.getIdProduto()));
	}
}

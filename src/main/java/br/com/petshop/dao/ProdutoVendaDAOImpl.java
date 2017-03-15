package br.com.petshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.ProdutoVenda;

@Repository
@Service
@Transactional
public class ProdutoVendaDAOImpl implements ProdutoVendaDAO{
	
	@PersistenceContext
	EntityManager entityManagerFactory;
	
	//private static final Logger logger = LoggerFactory.getLogger(FornecedorDAOImpl.class);
	 
	public void setEntityManagerFactory(EntityManager entityManagerFactory){
		this.entityManagerFactory = entityManagerFactory;
	}

	public List<ProdutoVenda> listaProdutosVenda() {
		@SuppressWarnings("unchecked")
		List<ProdutoVenda> produtosVenda =  entityManagerFactory.createQuery("from ProdutoVenda").getResultList();
        return produtosVenda;
	}
	
	public void altera(ProdutoVenda pv){
		entityManagerFactory.merge(pv);
	}
	
	public void inclui(ProdutoVenda pv) {
		entityManagerFactory.persist(pv);
	}
	
	public ProdutoVenda buscaPorId(int idProduto){
		return entityManagerFactory.find(ProdutoVenda.class, idProduto);
	}
 
	public void remove(ProdutoVenda pv){
		entityManagerFactory.remove(entityManagerFactory.getReference(ProdutoVenda.class, pv.getIdProdutoVenda()));
	}
}

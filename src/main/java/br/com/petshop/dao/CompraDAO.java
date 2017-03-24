package br.com.petshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.petshop.modelo.Compra;

@Repository
@Service
@Transactional
public class CompraDAO extends GenericDAO<Compra, Long> implements FornecedorDAO{
	 
	public CompraDAO(){
		super(Compra.class);
	}
}

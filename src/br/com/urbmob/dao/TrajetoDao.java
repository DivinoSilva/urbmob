package br.com.urbmob.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.com.urbmob.model.Trajeto;

@Repository
public class TrajetoDao {

	
	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void inserir(Trajeto trajeto){
		manager.persist(trajeto);
	}
	
	@Transactional
	public void excluir(Long idTrajeto){
		Trajeto trajeto= manager.find(Trajeto.class, idTrajeto);
		manager.remove(trajeto);
	}
	
	public List<Trajeto> listar() {
		EasyCriteria<Trajeto> easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager,Trajeto.class);
		return easyCriteria.getResultList();
	}
	
}

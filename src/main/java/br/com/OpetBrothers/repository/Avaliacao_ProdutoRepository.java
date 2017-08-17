package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dao.Avaliacao_ProdutoDAO;
import br.com.OpetBrothers.dto.Avaliacao_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.Avaliacao_ProdutoEntity;

public class Avaliacao_ProdutoRepository implements Avaliacao_ProdutoDAO{

	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public Avaliacao_ProdutoRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@Override
	public Avaliacao_ProdutoEntityDTO Cadastrar(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pAvaliacao_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new Avaliacao_ProdutoEntityDTO(true, "Cadastrado com sucesso!", pAvaliacao_ProdutoEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Avaliacao_ProdutoEntityDTO Atualizar(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pAvaliacao_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new Avaliacao_ProdutoEntityDTO(true, "Atualizado com sucesso!", pAvaliacao_ProdutoEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Avaliacao_ProdutoEntityDTO Excluir(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pAvaliacao_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new Avaliacao_ProdutoEntityDTO(true, "Excluido com sucesso!");
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Avaliacao_ProdutoEntityDTO GetAvaliacao_Produto(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<Avaliacao_ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM Avaliacao_ProdutoEntity p WHERE p.id_Avaliacao_Produto = :pId")
					.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new Avaliacao_ProdutoEntityDTO(true, "Recuperado com sucesso!", lista.get(0));
			}else{
				return new Avaliacao_ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Avaliacao_ProdutoEntityDTO TodasAvaliacao_Produto() {
		try{
			@SuppressWarnings("unchecked")
			List<Avaliacao_ProdutoEntity> lista = this.entityManager.createQuery("FROM Avaliacao_ProdutoEntity").getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new Avaliacao_ProdutoEntityDTO(true, "Recuperado com sucesso!", lista);
			}else{
				return new Avaliacao_ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Avaliacao_ProdutoEntityDTO TodasAvaliacoesProduto(int pIdProd) {
		try{
			@SuppressWarnings("unchecked")
			List<Avaliacao_ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM Avaliacao_ProdutoEntity p WHERE p.fk_Produto.id_Produto = :pIdProd")
					.setParameter("pIdProd", pIdProd).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new Avaliacao_ProdutoEntityDTO(true, "Recuperado com sucesso!", lista);
			}else{
				return new Avaliacao_ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}
	
	
	
}

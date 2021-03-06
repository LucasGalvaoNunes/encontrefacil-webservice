package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dao.Marca_ProdutoDAO;
import br.com.OpetBrothers.dto.Marca_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.Marca_ProdutoEntity;

public class Marca_ProdutoRepository implements Marca_ProdutoDAO{

	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public Marca_ProdutoRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@Override
	public Marca_ProdutoEntityDTO Cadastrar(Marca_ProdutoEntity pMarca_ProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pMarca_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new Marca_ProdutoEntityDTO(true, "Cadastrado com sucesso!", pMarca_ProdutoEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Marca_ProdutoEntityDTO Atualizar(Marca_ProdutoEntity pMarca_ProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pMarca_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new Marca_ProdutoEntityDTO(true, "Atualizado com sucesso!", pMarca_ProdutoEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Marca_ProdutoEntityDTO Excluir(Marca_ProdutoEntity pMarca_ProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pMarca_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new Marca_ProdutoEntityDTO(true, "Removido com sucesso!");
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Marca_ProdutoEntityDTO GetMarca_Produto(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<Marca_ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM Marca_ProdutoEntity p WHERE p.id_Marca_Produto = :pId")
					.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new Marca_ProdutoEntityDTO(true, "Recuperado com sucesso!", lista.get(0));
			}else{
				return new Marca_ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Marca_ProdutoEntityDTO TodasMarca_Produto() {
		try{
			@SuppressWarnings("unchecked")
			List<Marca_ProdutoEntity> lista = this.entityManager.createQuery("FROM Marca_ProdutoEntity").getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new Marca_ProdutoEntityDTO(true, "Recuperado com sucesso!", lista);
			}else{
				return new Marca_ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}
}

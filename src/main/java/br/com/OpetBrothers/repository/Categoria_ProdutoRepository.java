package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dao.Categoria_ProdutoDAO;
import br.com.OpetBrothers.dto.Categoria_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.Categoria_ProdutoEntity;

public class Categoria_ProdutoRepository implements Categoria_ProdutoDAO{
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public Categoria_ProdutoRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@Override
	public Categoria_ProdutoEntityDTO Cadastrar(Categoria_ProdutoEntity pCategoria_ProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pCategoria_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new Categoria_ProdutoEntityDTO(true, "Cadastrado com sucesso!", pCategoria_ProdutoEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Categoria_ProdutoEntityDTO Atualizar(Categoria_ProdutoEntity pCategoria_ProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pCategoria_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new Categoria_ProdutoEntityDTO(true, "Atualizado com sucesso!", pCategoria_ProdutoEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Categoria_ProdutoEntityDTO Excluir(Categoria_ProdutoEntity pCategoria_ProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pCategoria_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new Categoria_ProdutoEntityDTO(true, "Excluido com sucesso!");
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Categoria_ProdutoEntityDTO GetCategoria_Produto(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<Categoria_ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM Categoria_ProdutoEntity p WHERE p.id_Categoria_Produto = :pId")
					.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new Categoria_ProdutoEntityDTO(true, "Recuperado com sucesso!", lista.get(0));
			}else{
				return new Categoria_ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Categoria_ProdutoEntityDTO TodasCategorias_Produto() {
		try{
			@SuppressWarnings("unchecked")
			List<Categoria_ProdutoEntity> lista = this.entityManager.createQuery("FROM Categoria_ProdutoEntity").getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new Categoria_ProdutoEntityDTO(true, "Recuperados com sucesso!", lista);
			}else{
				return new Categoria_ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}
}

package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dto.Avaliacao_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.Avaliacao_ProdutoEntity;

public class Avaliacao_ProdutoRepository 
{	
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public Avaliacao_ProdutoRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public Avaliacao_ProdutoEntityDTO Salvar(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity)
	{
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pAvaliacao_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			return new Avaliacao_ProdutoEntityDTO(true, "Cadastrado com sucesso!");
		}catch (Exception e) {
			return new Avaliacao_ProdutoEntityDTO(false, "Erro no servidor, por favor tente novamente mais tarde!");
		}
	}
	
	public Avaliacao_ProdutoEntityDTO Alterar(Avaliacao_ProdutoEntity pAvaliacao_ProdutoEntity)
	{
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pAvaliacao_ProdutoEntity);
			this.entityManager.getTransaction().commit();
			return new Avaliacao_ProdutoEntityDTO(true, "Alterado com sucesso!");
		}catch (Exception e) {
			return new Avaliacao_ProdutoEntityDTO(false, "Erro no servidor, por favor tente novamente mais tarde! " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public Avaliacao_ProdutoEntityDTO PorProduto(int pIdProduto)
	{
		try{
			List<Avaliacao_ProdutoEntity> lista = this.entityManager.createQuery("SELECT a FROM Avaliacao_ProdutoEntity a WHERE a.fk_produto.id_produto = :pIdProduto ").setParameter("pIdProduto", pIdProduto).getResultList();
			if(lista  != null && lista.size() > 0)
			{
				return new Avaliacao_ProdutoEntityDTO(true, "Avaliacoes deste produto!", lista);
			}else{
				return new Avaliacao_ProdutoEntityDTO(false, "Nao possui nenhuma avaliacao ainda!");
			}
		}catch (Exception e) {
			return new Avaliacao_ProdutoEntityDTO(false, "Erro no servidor, por favor tente novamente mais tarde!");
		}
	}
}

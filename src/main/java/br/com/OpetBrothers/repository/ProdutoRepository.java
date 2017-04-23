package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dto.ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.ProdutoEntity;

public class ProdutoRepository 
{
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public ProdutoRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public ProdutoEntityDTO Salvar(ProdutoEntity pProdutoEntity){
 
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pProdutoEntity);
			this.entityManager.getTransaction().commit();
			return new ProdutoEntityDTO(true,"Cadastrado com sucesso!");
		}catch (Exception e) {
			return new ProdutoEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
		
	}
 
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public ProdutoEntityDTO Alterar(ProdutoEntity pProdutoEntity){
 
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pProdutoEntity);
			this.entityManager.getTransaction().commit();
			return new ProdutoEntityDTO(false,"Alterado com sucesso!");
		}
		catch (Exception e) {
			return new ProdutoEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
	}
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public ProdutoEntityDTO Excluir(ProdutoEntity pProdutoEntity){
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pProdutoEntity);
			this.entityManager.getTransaction().commit();
			return new ProdutoEntityDTO(false,"Excluido com sucesso!");
		}catch (Exception e) {
			return new ProdutoEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public ProdutoEntityDTO PorCategoria(String pCategoria){
		try{
			List<ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM ProdutoEntity p WHERE p.fk_categoria_produto.nome = :pCategoria").setParameter("pCategoria", pCategoria).getResultList();
			if(lista  != null && lista.size() > 0)
			{
				return new ProdutoEntityDTO(true, "Produtos!", lista);
			}else{
				return new ProdutoEntityDTO(false, "Nao existe produtos nesta categoria");
			}
		}catch (Exception e) {
			return new ProdutoEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public ProdutoEntityDTO PorMarca(String pMarca){
		try{
			List<ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM ProdutoEntity p WHERE p.fk_marca_produto.nome = :pMarca").setParameter("pMarca", pMarca).getResultList();
			if(lista  != null && lista.size() > 0)
			{
				return new ProdutoEntityDTO(true, "Produtos!", lista);
			}else{
				return new ProdutoEntityDTO(false, "Nao existe produtos desta marca");
			}
		}catch (Exception e) {
			return new ProdutoEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public ProdutoEntityDTO PorLoja(int pIdLoja){
		try{
			List<ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM ProdutoEntity p WHERE p.fk_loja.id_loja = :pIdLoja").setParameter("pIdLoja", pIdLoja).getResultList();
			if(lista  != null && lista.size() > 0)
			{
				return new ProdutoEntityDTO(true, "Produtos da Loja!", lista);
			}else{
				return new ProdutoEntityDTO(false, "Nao existe produtos nesta loja");
			}
		}catch (Exception e) {
			return new ProdutoEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public ProdutoEntityDTO Tudo(){
		try{
			List<ProdutoEntity> lista = this.entityManager.createQuery("FROM ProdutoEntity").getResultList();
			if(lista  != null && lista.size() > 0)
			{
				return new ProdutoEntityDTO(true, "Produtos!", lista);
			}else{
				return new ProdutoEntityDTO(false, "Nao existe produtos no banco!");
			}
		}catch (Exception e) {
			return new ProdutoEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
	}
	
}

package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dto.Categoria_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.Categoria_ProdutoEntity;

public class Categoria_ProdutoRepository 
{
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public Categoria_ProdutoRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public Categoria_ProdutoEntityDTO TodasCategorias(){
		try{
			List<Categoria_ProdutoEntity> lista = this.entityManager.createQuery("FROM Categoria_ProdutoEntity").getResultList();
			if(lista  != null && lista.size() > 0)
			{
				return new Categoria_ProdutoEntityDTO(true, "Categorias!", lista);
			}else{
				return new Categoria_ProdutoEntityDTO(false, "Nao existe categorias no banco!");
			}
		}catch (Exception e) {
			return new Categoria_ProdutoEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
	}
}

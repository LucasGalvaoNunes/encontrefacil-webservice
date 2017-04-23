package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dto.Marca_ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.Marca_ProdutoEntity;

public class Marca_ProdutoRepository 
{
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public Marca_ProdutoRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	@SuppressWarnings("unchecked")
	public Marca_ProdutoEntityDTO TodasMarcas(){
		try{
			List<Marca_ProdutoEntity> lista = this.entityManager.createQuery("FROM Marca_ProdutoEntity").getResultList();
			if(lista  != null && lista.size() > 0)
			{
				return new Marca_ProdutoEntityDTO(true, "Marcas!", lista);
			}else{
				return new Marca_ProdutoEntityDTO(false, "Nao existe marcas no banco!");
			}
		}catch (Exception e) {
			return new Marca_ProdutoEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
	}
 
}

package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dto.Categoria_LojaEntityDTO;
import br.com.OpetBrothers.repository.entity.Categoria_LojaEntity;

public class Categoria_LojaRepository
{

	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public Categoria_LojaRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	public Categoria_LojaEntityDTO TodasCategorias(){
		try{
			List<Categoria_LojaEntity> lista = this.entityManager.createQuery("FROM Categoria_LojaEntity").getResultList();
			if(lista  != null && lista.size() > 0)
			{
				return new Categoria_LojaEntityDTO(true, "Categorias!", lista);
			}else{
				return new Categoria_LojaEntityDTO(false, "Nao existe categorias no banco!");
			}
		}catch (Exception e) {
			return new Categoria_LojaEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
	}
}

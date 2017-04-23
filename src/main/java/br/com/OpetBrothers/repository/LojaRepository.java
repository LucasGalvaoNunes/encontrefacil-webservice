package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dto.LojaEntityDTO;
import br.com.OpetBrothers.repository.entity.LojaEntity;

public class LojaRepository {
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public LojaRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public LojaEntityDTO Salvar(LojaEntity pLojaEntity)
	{
		try{
			entityManager.getTransaction().begin();
			entityManager.persist(pLojaEntity.getFk_localizacao());
			entityManager.persist(pLojaEntity);
			entityManager.getTransaction().commit();
			return new LojaEntityDTO(true, "Loja cadastrada com sucesso!");
			
		}catch (Exception e) {
			return new LojaEntityDTO(true, "Erro no servidor, Tente novamente mais tarde!");
		}
	}
	
	public LojaEntityDTO Alterar(LojaEntity pLojaEntity)
	{
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(pLojaEntity.getFk_localizacao());
			entityManager.merge(pLojaEntity);
			entityManager.getTransaction().commit();
			return new LojaEntityDTO(true, "Loja alterada com sucesso!");
			
		}catch (Exception e) {
			return new LojaEntityDTO(true, "Erro no servidor, Tente novamente mais tarde!");
		}
	}
	
	public LojaEntityDTO Excluir(LojaEntity pLojaEntity)
	{
		try{
			entityManager.getTransaction().begin();
			entityManager.remove(pLojaEntity);
			entityManager.remove(pLojaEntity.getFk_localizacao());			
			entityManager.getTransaction().commit();
			return new LojaEntityDTO(true, "Loja removida com sucesso!");
			
		}catch (Exception e) {
			return new LojaEntityDTO(true, "Erro no servidor, Tente novamente mais tarde!");
		}
	}
	
	@SuppressWarnings("unchecked")
	public LojaEntityDTO LojasPorUsuario(int pIdUsuario){
		try{
			List<LojaEntity> lista = this.entityManager.createQuery("SELECT l FROM LojaEntity l WHERE l.fk_usuario.id_usuario = :pIdUsuario ").setParameter("pIdUsuario", pIdUsuario).getResultList();
			if(lista  != null && lista.size() > 0)
			{
				return new LojaEntityDTO(true, "Lojas deste usuario!", lista);
			}else{
				return new LojaEntityDTO(false, "Nao possui nenhuma loja!");
			}
		}catch (Exception e) {
			return new LojaEntityDTO(false,"Erro no Servidor!, Desculpe tente novamente mais tarde!");
		}
	}
	
}

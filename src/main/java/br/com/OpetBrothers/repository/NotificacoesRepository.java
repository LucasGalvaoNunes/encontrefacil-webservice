package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dao.NotificacoesDAO;
import br.com.OpetBrothers.dto.NotificacoesEntityDTO;
import br.com.OpetBrothers.repository.entity.NotificacoesEntity;

public class NotificacoesRepository implements NotificacoesDAO{
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public NotificacoesRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@Override
	public NotificacoesEntityDTO Cadastrar(NotificacoesEntity pNotificacoesEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pNotificacoesEntity);
			this.entityManager.getTransaction().commit();
			
			return new NotificacoesEntityDTO(true, "Cadastrado com sucesso!", pNotificacoesEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public NotificacoesEntityDTO Atualizar(NotificacoesEntity pNotificacoesEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pNotificacoesEntity);
			this.entityManager.getTransaction().commit();
			
			return new NotificacoesEntityDTO(true, "Atualizado com sucesso!", pNotificacoesEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public NotificacoesEntityDTO Excluir(NotificacoesEntity pNotificacoesEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pNotificacoesEntity);
			this.entityManager.getTransaction().commit();
			
			return new NotificacoesEntityDTO(true, "Excluido com sucesso!");
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public NotificacoesEntityDTO GetNotificacoes(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<NotificacoesEntity> lista = this.entityManager.createQuery("SELECT p FROM NotificacoesEntity p WHERE p.id_Notificacoes = :pId")
					.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new NotificacoesEntityDTO(true, "Recuperado com sucesso!", lista.get(0));
			}else{
				return new NotificacoesEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public NotificacoesEntityDTO TodasNotificacoes() {
		try{
			@SuppressWarnings("unchecked")
			List<NotificacoesEntity> lista = this.entityManager.createQuery("FROM NotificacoesEntity")
					.getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new NotificacoesEntityDTO(true, "Recuperado com sucesso!", lista);
			}else{
				return new NotificacoesEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}
}

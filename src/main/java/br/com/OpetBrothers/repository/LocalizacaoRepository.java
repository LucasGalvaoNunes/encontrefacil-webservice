package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.OpetBrothers.dao.LocalizacaoDAO;
import br.com.OpetBrothers.dto.LocalizacaoEntityDTO;
import br.com.OpetBrothers.repository.entity.LocalizacaoEntity;

public class LocalizacaoRepository implements LocalizacaoDAO {

	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public LocalizacaoRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@Override
	public LocalizacaoEntityDTO Cadastrar(LocalizacaoEntity pLocalizacaoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pLocalizacaoEntity);
			this.entityManager.getTransaction().commit();
			
			return new LocalizacaoEntityDTO(true, "Cadastrado com sucesso!", pLocalizacaoEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public LocalizacaoEntityDTO Atualizar(LocalizacaoEntity pLocalizacaoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pLocalizacaoEntity);
			this.entityManager.getTransaction().commit();
			
			return new LocalizacaoEntityDTO(true, "Atualizado com sucesso!", pLocalizacaoEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public LocalizacaoEntityDTO Excluir(LocalizacaoEntity pLocalizacaoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pLocalizacaoEntity);
			this.entityManager.getTransaction().commit();
			
			return new LocalizacaoEntityDTO(true, "Excluido com sucesso!");
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public LocalizacaoEntityDTO GetLocalizacao(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<LocalizacaoEntity> lista = this.entityManager.createQuery("SELECT p FROM LocalizacaoEntity p WHERE p.id_Localizacao = :pId")
					.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0){
				return new LocalizacaoEntityDTO(true, "Dado recuperado com sucesso!", lista.get(0));
			}else{
				return new LocalizacaoEntityDTO(false, "Nenhuma dado encontrado para este ID");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public LocalizacaoEntityDTO TodasLocalizacao() {
		try{
			@SuppressWarnings("unchecked")
			List<LocalizacaoEntity> lista = this.entityManager.createQuery("FROM LocalizacaoEntity").getResultList();
			if(lista != null && lista.size() > 0){
				return new LocalizacaoEntityDTO(true, "Dados recuperados com sucesso!", lista);
			}else{
				return new LocalizacaoEntityDTO(false, "Nenhum dado encontrado");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}
	
}

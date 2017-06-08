package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dao.FavoritosPessoaFisicaDAO;
import br.com.OpetBrothers.dto.FavoritosPessoaFisicaEntityDTO;
import br.com.OpetBrothers.repository.entity.FavoritosPessoaFisicaEntity;

public class FavoritosPessoaFisicaRepository implements FavoritosPessoaFisicaDAO{
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public FavoritosPessoaFisicaRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@Override
	public FavoritosPessoaFisicaEntityDTO Cadastrar(FavoritosPessoaFisicaEntity pFavoritosPessoaFisicaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pFavoritosPessoaFisicaEntity);
			this.entityManager.getTransaction().commit();
			
			return new FavoritosPessoaFisicaEntityDTO(true, "Cadastrado com sucesso!", pFavoritosPessoaFisicaEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public FavoritosPessoaFisicaEntityDTO Atualizar(FavoritosPessoaFisicaEntity pFavoritosPessoaFisicaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pFavoritosPessoaFisicaEntity);
			this.entityManager.getTransaction().commit();
			
			return new FavoritosPessoaFisicaEntityDTO(true, "Atualizado com sucesso!", pFavoritosPessoaFisicaEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public FavoritosPessoaFisicaEntityDTO Excluir(FavoritosPessoaFisicaEntity pFavoritosPessoaFisicaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pFavoritosPessoaFisicaEntity);
			this.entityManager.getTransaction().commit();
			
			return new FavoritosPessoaFisicaEntityDTO(true, "Excluido com sucesso!");
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public FavoritosPessoaFisicaEntityDTO GetFavoritosPessoaFisica(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<FavoritosPessoaFisicaEntity> lista = this.entityManager.createQuery("SELECT p FROM FavoritosPessoaFisicaEntity p WHERE p.id_Favoritos = :pId")
					.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new FavoritosPessoaFisicaEntityDTO(true, "Recuperado com sucesso!", lista.get(0));
			}else{
				return new FavoritosPessoaFisicaEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public FavoritosPessoaFisicaEntityDTO TodasFavoritos() {
		try{
			@SuppressWarnings("unchecked")
			List<FavoritosPessoaFisicaEntity> lista = this.entityManager.createQuery("FROM FavoritosPessoaFisicaEntity").getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new FavoritosPessoaFisicaEntityDTO(true, "Recuperado com sucesso!", lista);
			}else{
				return new FavoritosPessoaFisicaEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}
}

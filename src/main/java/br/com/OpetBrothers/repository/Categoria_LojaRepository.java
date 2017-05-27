package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dao.Categoria_LojaDAO;
import br.com.OpetBrothers.dto.Categoria_LojaEntityDTO;
import br.com.OpetBrothers.repository.entity.Categoria_LojaEntity;

public class Categoria_LojaRepository implements Categoria_LojaDAO{
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public Categoria_LojaRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@Override
	public Categoria_LojaEntityDTO Cadastrar(Categoria_LojaEntity pCategoria_LojaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pCategoria_LojaEntity);
			this.entityManager.getTransaction().commit();
			
			return new Categoria_LojaEntityDTO(true, "Cadastrado com sucesso!", pCategoria_LojaEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Categoria_LojaEntityDTO Atualizar(Categoria_LojaEntity pCategoria_LojaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pCategoria_LojaEntity);
			this.entityManager.getTransaction().commit();
			
			return new Categoria_LojaEntityDTO(true, "Atualizado com sucesso!", pCategoria_LojaEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Categoria_LojaEntityDTO Excluir(Categoria_LojaEntity pCategoria_LojaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pCategoria_LojaEntity);
			this.entityManager.getTransaction().commit();
			
			return new Categoria_LojaEntityDTO(true, "Excluido com sucesso!");
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Categoria_LojaEntityDTO GetCategoria_Loja(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<Categoria_LojaEntity> lista = this.entityManager.createQuery("FROM Categoria_LojaEntity p WHERE p.Id_Categoria_Loja = :pId")
			.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new Categoria_LojaEntityDTO (true, "Recuperado com sucesso!", lista.get(0));
			}else{
				return new Categoria_LojaEntityDTO (false, "Não há dado cadastrado ainda!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public Categoria_LojaEntityDTO TodasCategorias_Loja() {
		try{
			@SuppressWarnings("unchecked")
			List<Categoria_LojaEntity> lista = this.entityManager.createQuery("FROM Categoria_LojaEntity")
			.getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new Categoria_LojaEntityDTO (true, "Recuperado com sucesso!", lista);
			}else{
				return new Categoria_LojaEntityDTO (false, "Não há dado cadastrado ainda!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}
}

package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dao.PessoaFisicaDAO;
import br.com.OpetBrothers.dto.PessoaFisicaEntityDTO;
import br.com.OpetBrothers.repository.entity.PessoaFisicaEntity;

public class PessoaFisicaRepository implements PessoaFisicaDAO{
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public PessoaFisicaRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@Override
	public PessoaFisicaEntityDTO Cadastrar(PessoaFisicaEntity pPessoaFisicaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pPessoaFisicaEntity.getFk_Pessoa());
			this.entityManager.persist(pPessoaFisicaEntity);
			this.entityManager.getTransaction().commit();
			
			return new PessoaFisicaEntityDTO(true, "Cadastrado com sucesso!", pPessoaFisicaEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaFisicaEntityDTO Atualizar(PessoaFisicaEntity pPessoaFisicaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pPessoaFisicaEntity.getFk_Pessoa());
			this.entityManager.merge(pPessoaFisicaEntity);
			this.entityManager.getTransaction().commit();
			
			return new PessoaFisicaEntityDTO(true, "Atualizado com sucesso!", pPessoaFisicaEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaFisicaEntityDTO Excluir(PessoaFisicaEntity pPessoaFisicaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pPessoaFisicaEntity);
			this.entityManager.getTransaction().commit();
			
			return new PessoaFisicaEntityDTO(true, "Removido com sucesso!", pPessoaFisicaEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	
	
	@Override
	public PessoaFisicaEntityDTO GetPessoaFisica(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<PessoaFisicaEntity> lista = this.entityManager.createQuery("SELECT p FROM PessoaFisicaEntity p WHERE p.id_PessoaFisica = :pId")
					.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new PessoaFisicaEntityDTO(true, "Recuperado com sucesso!", lista.get(0));
			}else{
				return new PessoaFisicaEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaFisicaEntityDTO TodasPessoas() {
		try{
			@SuppressWarnings("unchecked")
			List<PessoaFisicaEntity> lista = this.entityManager.createQuery("FROM PessoaFisicaEntity").getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new PessoaFisicaEntityDTO(true, "Recuperado com sucesso!", lista);
			}else{
				return new PessoaFisicaEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaFisicaEntityDTO BuscaIDFacebook(String pId) {
		try{
			@SuppressWarnings("unchecked")
			List<PessoaFisicaEntity> lista = this.entityManager.createQuery("SELECT p FROM PessoaFisicaEntity p WHERE p.id_facebook = :pId")
					.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new PessoaFisicaEntityDTO(true, "Recuperado com sucesso!", lista.get(0));
			}else{
				return new PessoaFisicaEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

}

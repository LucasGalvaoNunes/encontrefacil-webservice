package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dao.PessoaDAO;
import br.com.OpetBrothers.dto.PessoaEntityDTO;
import br.com.OpetBrothers.repository.entity.PessoaEntity;

public class PessoaRepository implements PessoaDAO{

	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public PessoaRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	@Override
	public PessoaEntityDTO Cadastrar(PessoaEntity pPessoaEntity) {
		try{
			/**
			 * Inicia a transacao com o BD
			 */
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pPessoaEntity);
			this.entityManager.getTransaction().commit();
			
			/**
			 * Terminado de commitar, retorna-se os dados para o cliente
			 */
			return new PessoaEntityDTO(true,"Cadastrado com sucesso!", pPessoaEntity);
		}catch (Exception e) {
			return null;
		}finally {
			/**
			 * Apos ter feito tudo,finaliza a transacao do banco
			 */
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaEntityDTO Atualizar(PessoaEntity pPessoaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pPessoaEntity);
			this.entityManager.getTransaction().commit();
			return new PessoaEntityDTO(true,"Atualizado com sucesso!", pPessoaEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaEntityDTO Excluir(PessoaEntity pPessoaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pPessoaEntity);
			this.entityManager.getTransaction().commit();
			return new PessoaEntityDTO(true,"Excluido com sucesso!");
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	
	@Override
	public PessoaEntityDTO GetPessoa(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<PessoaEntity> pessoa = this.entityManager.createQuery("FROM PessoaEntity p WHERE p.Id_Pessoa = :pId ")
					.setParameter("pId", pId)
					.getResultList();
			if(pessoa != null && pessoa.size() > 0)
			{
				return new PessoaEntityDTO(true,"Pessoa recuperada!", pessoa.get(0));
			}else{
				return new PessoaEntityDTO(true,"Nenhum dado encontrado para este id!");
			}
			
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaEntityDTO TodasPessoas() {
		try{
			@SuppressWarnings("unchecked")
			List<PessoaEntity> pessoas = this.entityManager.createQuery("FROM PessoaEntity")
					.getResultList();
			if(pessoas != null && pessoas.size() > 0)
			{
				return new PessoaEntityDTO(true,"Lista recuperada!", pessoas);
			}else{
				return new PessoaEntityDTO(true,"Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

}

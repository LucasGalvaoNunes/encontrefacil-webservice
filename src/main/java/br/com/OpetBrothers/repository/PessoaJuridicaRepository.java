package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dao.PessoaJuridicaDAO;
import br.com.OpetBrothers.dto.PessoaJuridicaEntityDTO;
import br.com.OpetBrothers.repository.entity.PessoaJuridicaEntity;
/**
 * Classe responsavel por fazer o CRUD no Banco de dados
 */
public class PessoaJuridicaRepository implements PessoaJuridicaDAO
{
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public PessoaJuridicaRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@Override
	public PessoaJuridicaEntityDTO Cadastrar(PessoaJuridicaEntity pPessoaJuridicaEntity) {
		try{
			/**
			 * Inicia a transacao com o BD
			 */
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pPessoaJuridicaEntity);
			this.entityManager.getTransaction().commit();
			
			/**
			 * Terminado de commitar, retorna-se os dados para o cliente
			 */
			return new PessoaJuridicaEntityDTO(true,"Cadastrado com sucesso!", pPessoaJuridicaEntity);
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
	public PessoaJuridicaEntityDTO Atualizar(PessoaJuridicaEntity pPessoaJuridicaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pPessoaJuridicaEntity);
			this.entityManager.getTransaction().commit();
			return new PessoaJuridicaEntityDTO(true,"Atualizado com sucesso!", pPessoaJuridicaEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaJuridicaEntityDTO Excluir(PessoaJuridicaEntity pPessoaJuridicaEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.remove(pPessoaJuridicaEntity);
			this.entityManager.getTransaction().commit();
			return new PessoaJuridicaEntityDTO(true,"Removido com sucesso!");
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaJuridicaEntityDTO Login(PessoaJuridicaEntity pPessoaJuridicaEntity) {
		try{
			@SuppressWarnings("unchecked")
			List<PessoaJuridicaEntity> emailOk = this.entityManager.createQuery("FROM PessoaJuridicaEntity p WHERE p.Fk_Pessoa.Email = :pEmail")
			.setParameter("pEmail", pPessoaJuridicaEntity.getFk_Pessoa().getEmail())
			.getResultList();
			if(emailOk != null && emailOk.size() > 0)
			{
				@SuppressWarnings("unchecked")
				List<PessoaJuridicaEntity> senhaeEmailOk = this.entityManager.createQuery("FROM PessoaJuridicaEntity p WHERE p.Fk_Pessoa.Email = :pEmail AND p.Senha = :pSenha ")
						.setParameter("pEmail", pPessoaJuridicaEntity.getFk_Pessoa().getEmail())
						.setParameter("pSenha", pPessoaJuridicaEntity.getSenha())
						.getResultList();
				if(senhaeEmailOk != null && senhaeEmailOk.size() > 0)
				{
					return new PessoaJuridicaEntityDTO (true, "Logado com sucesso!", senhaeEmailOk.get(0));
				}else{
					return new PessoaJuridicaEntityDTO (false, "Senha Incorreta!");
				}
				
			}else{
				return new PessoaJuridicaEntityDTO (false, "Email Incorreto!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaJuridicaEntityDTO GetPessoaJuridica(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<PessoaJuridicaEntity> lista = this.entityManager.createQuery("FROM PessoaJuridicaEntity p WHERE p.Id_PessoaJuridica = :pId ").setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new PessoaJuridicaEntityDTO (true, "Recuperado com sucesso!", lista);
			}else{
				return new PessoaJuridicaEntityDTO (false, "Não há dado cadastrado ainda!");
			}
		
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public PessoaJuridicaEntityDTO TodasLojas() {
		try{
			@SuppressWarnings("unchecked")
			List<PessoaJuridicaEntity> lista = this.entityManager.createQuery("SELECT p FROM PessoaJuridicaEntity p ORDER BY p.Id_PessoaJuridica").getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new PessoaJuridicaEntityDTO (true, "Recuperados com sucesso!", lista);
			}else{
				return new PessoaJuridicaEntityDTO (false, "Não há dados cadastrados ainda!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}
	
	
	
}

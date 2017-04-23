package br.com.OpetBrothers.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dto.UsuarioEntityDTO;
import br.com.OpetBrothers.repository.entity.UsuarioEntity;

public class UsuarioRepository
{
	
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public UsuarioRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public UsuarioEntityDTO Salvar(UsuarioEntity pUsuarioEntity){
		
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pUsuarioEntity.getFk_localizacao());
			this.entityManager.persist(pUsuarioEntity);
			this.entityManager.getTransaction().commit();
			return new UsuarioEntityDTO(true, "Cadastrado com sucesso!");
		}catch (Exception e) {
			return new UsuarioEntityDTO(false, "Erro no servidor, Desculpe, tente novamente mais tarde!");
		}
		
	}
 
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public UsuarioEntityDTO Alterar(UsuarioEntity pUsuarioEntity){

		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(pUsuarioEntity.getFk_localizacao());
			this.entityManager.merge(pUsuarioEntity);
			this.entityManager.getTransaction().commit();
			return new UsuarioEntityDTO(true, "Alterado com sucesso!");
		}catch(Exception e)
		{
			return new UsuarioEntityDTO(false, "Erro no servidor, Desculpe, tente novamente mais tarde!");
		}
		
		
	}
 
 
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public UsuarioEntityDTO Excluir(UsuarioEntity pUsuarioEntity){
		try{
			this.entityManager.getTransaction().begin();		
			System.out.println(pUsuarioEntity.getEmail() + "\n" + pUsuarioEntity.getId_usuario());
			this.entityManager.remove(pUsuarioEntity);
			this.entityManager.remove(pUsuarioEntity.getFk_localizacao());
			this.entityManager.getTransaction().commit();
			return new UsuarioEntityDTO(true, "Usuario excluido com sucesso!");
		}catch (Exception e) {
			return new UsuarioEntityDTO(false, e.getMessage());
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public UsuarioEntityDTO Logar(UsuarioEntity pUsuarioEntity){

		try{
			List<UsuarioEntity> lista = this.entityManager.createQuery("SELECT p FROM UsuarioEntity p WHERE p.email = :email AND p.senha = :senha").setParameter("email", pUsuarioEntity.getEmail()).setParameter("senha", pUsuarioEntity.getSenha()).getResultList();
			if(lista  != null && lista.size() > 0)
			{
				return new UsuarioEntityDTO(true, "Usuario Logado!", lista.get(0));
			}else{
				return new UsuarioEntityDTO(false, "Usuario ou senha incorreto!");
			}
		
		}catch (Exception e) {
			return new UsuarioEntityDTO(false, "Erro no servidor, Desculpe, tente novamente mais tarde!");
		}
	}
	
	
	
}

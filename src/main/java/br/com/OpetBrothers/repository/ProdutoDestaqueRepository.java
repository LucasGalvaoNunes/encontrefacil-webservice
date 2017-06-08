package br.com.OpetBrothers.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.OpetBrothers.dao.ProdutoDestaqueDAO;
import br.com.OpetBrothers.dto.ProdutoDestaqueEntityDTO;
import br.com.OpetBrothers.repository.entity.NotificacoesEntity;
import br.com.OpetBrothers.repository.entity.ProdutoDestaqueEntity;

public class ProdutoDestaqueRepository implements ProdutoDestaqueDAO{
	
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public ProdutoDestaqueRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	
	
	@Override
	public ProdutoDestaqueEntityDTO PorLocalidade(String pBairro, String pCidade, String pEstado) {
		try{
			@SuppressWarnings("unchecked")
			List<ProdutoDestaqueEntity> lista = this.entityManager.createQuery("SELECT p FROM ProdutoDestaqueEntity p WHERE "
					+ " p.fk_produto.fk_Pessoa_Juridica.fk_Localizacao.bairro = :pBairro"
					+ " AND"
					+ " p.fk_produto.fk_Pessoa_Juridica.fk_Localizacao.cidade = :pCidade"
					+ " AND"
					+ " p.fk_produto.fk_Pessoa_Juridica.fk_Localizacao.estado = :pEstado")
					.setParameter("pBairro", pBairro)
					.setParameter("pCidade", pCidade)
					.setParameter("pEstado", pEstado)
					.getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new ProdutoDestaqueEntityDTO(true, "Recuperado com sucesso!", lista);
			}else{
				return new ProdutoDestaqueEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}



	@Override
	public ProdutoDestaqueEntityDTO Cadastrar(ProdutoDestaqueEntity pProdutoDestaqueEntity) {
		try{
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(pProdutoDestaqueEntity);
			this.entityManager.getTransaction().commit();
			return new ProdutoDestaqueEntityDTO(true, "Cadastrado com sucesso!", pProdutoDestaqueEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}



	@Override
	public ProdutoDestaqueEntityDTO ExcluirProdutosExpirados() {
		try{
			@SuppressWarnings("unchecked")
			List<ProdutoDestaqueEntity> listaExpiraDestaque = this.entityManager.createQuery("SELECT p FROM ProdutoDestaqueEntity WHERE CURRENT_TIMESTAMP >= p.data_saida AND p.fk_produto.is_active = 1")
					.getResultList();
			
			if(listaExpiraDestaque != null && listaExpiraDestaque.size() > 0)
			{
				this.entityManager.getTransaction().begin();
				for(ProdutoDestaqueEntity p : listaExpiraDestaque){
					NotificacoesEntity noti = new NotificacoesEntity();
					noti.setDetalhes("Acabou o impulso do seu produtos " + p.getFk_produto().getNome());
					noti.setFk_Pessoa_Juridica(p.getFk_produto().getFk_Pessoa_Juridica());
					noti.setFk_Produto(p.getFk_produto());
					this.entityManager.persist(noti);
					this.entityManager.remove(p);
				}
				this.entityManager.getTransaction().commit();
			}
			return new ProdutoDestaqueEntityDTO(true, "Ok!");
		}catch (Exception e) {
			return null;
		}
	}
	
}

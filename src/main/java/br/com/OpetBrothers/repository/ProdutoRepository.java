package br.com.OpetBrothers.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.OpetBrothers.dao.ProdutoDAO;
import br.com.OpetBrothers.dto.ProdutoEntityDTO;
import br.com.OpetBrothers.repository.entity.Categoria_ProdutoEntity;
import br.com.OpetBrothers.repository.entity.LocalizacaoEntity;
import br.com.OpetBrothers.repository.entity.Marca_ProdutoEntity;
import br.com.OpetBrothers.repository.entity.NotificacoesEntity;
import br.com.OpetBrothers.repository.entity.ProdutoEntity;


public class ProdutoRepository implements  ProdutoDAO{
	private final EntityManagerFactory entityManagerFactory;
	 
	private final EntityManager entityManager;
 
	public ProdutoRepository(){
 
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("EncontreFacilWs");
 
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	@Override
	public ProdutoEntityDTO Cadastrar(ProdutoEntity pProdutoEntity) {
		
		try{
			this.entityManager.getTransaction().begin();
			@SuppressWarnings("unchecked")
			List<Categoria_ProdutoEntity> listaCategoria = this.entityManager.createQuery("FROM Categoria_ProdutoEntity p WHERE SOUNDEX(p.nome) = SOUNDEX(:pNome)")
					.setParameter("pNome", pProdutoEntity.getFk_Categoria_Produto().getNome()).getResultList();
			if(listaCategoria != null && listaCategoria.size() > 0)
			{
				pProdutoEntity.setFk_Categoria_Produto(listaCategoria.get(0));
			}else{
				this.entityManager.persist(pProdutoEntity.getFk_Categoria_Produto());
			}
			
			@SuppressWarnings("unchecked")
			List<Marca_ProdutoEntity> listaMarca = this.entityManager.createQuery("FROM Marca_ProdutoEntity p WHERE SOUNDEX(p.nome) = SOUNDEX(:pNome)")
					.setParameter("pNome", pProdutoEntity.getFk_Marca_Produto().getNome()).getResultList();
			if(listaMarca != null && listaMarca.size() > 0)
			{
				pProdutoEntity.setFk_Marca_Produto(listaMarca.get(0));
			}else{
				this.entityManager.persist(pProdutoEntity.getFk_Marca_Produto());
			}
			pProdutoEntity.setData_Publicacao(new Timestamp(System.currentTimeMillis()));
			pProdutoEntity.setIs_active(1);
			this.entityManager.persist(pProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new ProdutoEntityDTO(true,"Cadastrado com sucesso!", pProdutoEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public ProdutoEntityDTO Atualizar(ProdutoEntity pProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			pProdutoEntity.setIs_active(1);
			this.entityManager.merge(pProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new ProdutoEntityDTO(true,"Atualizado com sucesso!", pProdutoEntity);
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public ProdutoEntityDTO Excluir(ProdutoEntity pProdutoEntity) {
		try{
			this.entityManager.getTransaction().begin();
			pProdutoEntity.setIs_active(0);
			this.entityManager.merge(pProdutoEntity);
			this.entityManager.getTransaction().commit();
			
			return new ProdutoEntityDTO(true,"Excluido com sucesso!");
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public ProdutoEntityDTO GetProduto(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM ProdutoEntity p WHERE p.id_Produto = :pId AND p.is_active = 1")
					.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				int qtd = lista.get(0).getQtd_visita();
				lista.get(0).setQtd_visita(qtd + 1);	
				this.entityManager.getTransaction().begin();
				this.entityManager.merge(lista.get(0));
				this.entityManager.getTransaction().commit();
				
				return new ProdutoEntityDTO(true, "Recuperado com sucesso!", lista.get(0));
			}else{
				return new ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public ProdutoEntityDTO BuscarPorNome(LocalizacaoEntity pLocalizacao, String pNome) {
		pNome= pNome.replace("_", " ");
		try{
			@SuppressWarnings("unchecked")
			List<ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM ProdutoEntity p WHERE "
				+ "SOUNDEX(NOME) LIKE CONCAT('%',SOUNDEX(:pNome),'%')"
				+ " AND"
				+ " p.fk_Pessoa_Juridica.fk_Localizacao.bairro = :pBairro"
				+ " AND"
				+ " p.fk_Pessoa_Juridica.fk_Localizacao.cidade = :pCidade"
				+ " AND"
				+ " p.fk_Pessoa_Juridica.fk_Localizacao.estado = :pEstado"
				+ " AND p.is_active = 1")
				.setParameter("pNome", pNome)
				.setParameter("pBairro", pLocalizacao.getBairro())
				.setParameter("pCidade", pLocalizacao.getCidade())
				.setParameter("pEstado", pLocalizacao.getEstado())
				.getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new ProdutoEntityDTO(true, "Recuperado com sucesso!", lista);
			}
			else{
				return new ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}	
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public ProdutoEntityDTO BuscarPorCategoria(LocalizacaoEntity pLocalizacao, int pId) {
		
		try{
			@SuppressWarnings("unchecked")
			List<ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM ProdutoEntity p WHERE "
					+ "p.fk_Categoria_Produto.id_Categoria_Produto = :pId"
					+ " AND"
					+ " p.fk_Pessoa_Juridica.fk_Localizacao.bairro = :pBairro"
					+ " AND"
					+ " p.fk_Pessoa_Juridica.fk_Localizacao.cidade = :pCidade"
					+ " AND"
					+ " p.fk_Pessoa_Juridica.fk_Localizacao.estado = :pEstado"
					+ " AND p.is_active = 1")
					.setParameter("pId", pId)
					.setParameter("pBairro", pLocalizacao.getBairro())
					.setParameter("pCidade", pLocalizacao.getCidade())
					.setParameter("pEstado", pLocalizacao.getEstado())
					.getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new ProdutoEntityDTO(true, "Recuperado com sucesso!", lista);
			}else{
				return new ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}
			
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public ProdutoEntityDTO RelatorioLoja(int pId) {
			try{
				@SuppressWarnings("unchecked")
				List<ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM ProdutoEntity p WHERE p.fk_Pessoa_Juridica.id_PessoaJuridica = :pId AND p.is_active = 1")
						.setParameter("pId", pId).getResultList();
				if(lista != null && lista.size() > 0)
				{
					return new ProdutoEntityDTO(true, "Recuperado com sucesso!", lista);
				}else{
					return new ProdutoEntityDTO(false, "Nao contem dados");
				}
			
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public ProdutoEntityDTO GetProdutodaLoja(int pId) {
		try{
			@SuppressWarnings("unchecked")
			List<ProdutoEntity> lista = this.entityManager.createQuery("SELECT p FROM ProdutoEntity p WHERE p.id_Produto = :pId AND p.is_active = 1")
					.setParameter("pId", pId).getResultList();
			if(lista != null && lista.size() > 0)
			{
				return new ProdutoEntityDTO(true, "Recuperado com sucesso!", lista.get(0));
			}else{
				return new ProdutoEntityDTO(false, "Nenhum dado encontrado!");
			}
		}catch (Exception e) {
			return null;
		}finally {
			this.entityManager.close();
			this.entityManagerFactory.close();
		}
	}

	@Override
	public ProdutoEntityDTO ExcluirProdutosExpirados() {
		try{
			@SuppressWarnings("unchecked")
			List<ProdutoEntity> listaExpirada = this.entityManager.createQuery("SELECT p FROM ProdutoEntity WHERE CURRENT_TIMESTAMP >= ProdutoEntity.data_Publicacao + 30 AND p.is_active = 1")
					.getResultList();
			@SuppressWarnings("unchecked")
			List<ProdutoEntity> listaASerExpirada = this.entityManager.createQuery("SELECT p FROM ProdutoEntity WHERE CURRENT_TIMESTAMP >= ProdutoEntity.data_Publicacao + 25 AND p.is_active = 1")
					.getResultList();
			if(listaExpirada != null && listaExpirada.size() > 0)
			{
				this.entityManager.getTransaction().begin();
				for(ProdutoEntity p : listaExpirada){
					NotificacoesEntity noti = new NotificacoesEntity();
					noti.setDetalhes("Expirou a data do Produto " + p.getNome() + " atualize as informações para que ele volte a aparecer no sistema!");
					noti.setFk_Pessoa_Juridica(p.getFk_Pessoa_Juridica());
					noti.setFk_Produto(p);
					this.entityManager.persist(noti);
					p.setIs_active(0);
					this.entityManager.merge(p);
				}
				this.entityManager.getTransaction().commit();
			}
			if(listaASerExpirada != null && listaASerExpirada.size() > 0)
			{
				this.entityManager.getTransaction().begin();
				for(ProdutoEntity p : listaExpirada){
					NotificacoesEntity noti = new NotificacoesEntity();
					noti.setDetalhes("O Produto " + p.getNome() + " será retirado do sistema dentre 5 dias, atualize suas informações para que ele continue aqui!");
					noti.setFk_Pessoa_Juridica(p.getFk_Pessoa_Juridica());
					noti.setFk_Produto(p);
					this.entityManager.persist(noti);
					p.setIs_active(0);
					this.entityManager.merge(p);
				}
				this.entityManager.getTransaction().commit();
			}
			return new ProdutoEntityDTO(true, "Ok!");
		}catch (Exception e) {
			return null;
		}
	}	
}

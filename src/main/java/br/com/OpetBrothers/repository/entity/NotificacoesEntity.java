package br.com.OpetBrothers.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="NOTIFICACOES")
@XmlRootElement
public class NotificacoesEntity {

	@Id
	@Column(name="ID_NOTIFICACOES")
	@GeneratedValue(generator="Id_Notificacoes")
    @GenericGenerator(name="Id_Notificacoes", strategy = "increment")
	private int Id_Notificacoes;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PRODUTO")
	private ProdutoEntity Fk_Produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PESSOA_JURIDICA")
	private PessoaJuridicaEntity Fk_Pessoa_Juridica;
	
	@Column(name="DETALHES")
	private String Detalhes;

	public int getId_Notificacoes() {
		return Id_Notificacoes;
	}

	public void setId_Notificacoes(int id_Notificacoes) {
		Id_Notificacoes = id_Notificacoes;
	}

	public ProdutoEntity getFk_Produto() {
		return Fk_Produto;
	}

	public void setFk_Produto(ProdutoEntity fk_Produto) {
		Fk_Produto = fk_Produto;
	}

	public PessoaJuridicaEntity getFk_Pessoa_Juridica() {
		return Fk_Pessoa_Juridica;
	}

	public void setFk_Pessoa_Juridica(PessoaJuridicaEntity fk_Pessoa_Juridica) {
		Fk_Pessoa_Juridica = fk_Pessoa_Juridica;
	}

	public String getDetalhes() {
		return Detalhes;
	}

	public void setDetalhes(String detalhes) {
		Detalhes = detalhes;
	}
	
	
	
	
}

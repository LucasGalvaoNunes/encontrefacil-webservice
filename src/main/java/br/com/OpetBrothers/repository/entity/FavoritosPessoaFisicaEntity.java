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
@Table(name="FAVORITOS_PESSOA_FISICA")
@XmlRootElement
public class FavoritosPessoaFisicaEntity {

	
	@Id
	@Column(name="ID_FAVORITOS")
	@GeneratedValue(generator="Id_Favoritos")
    @GenericGenerator(name="Id_Favoritos", strategy = "increment")
	private int id_Favoritos;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PESSOA_FISICA")
	private PessoaFisicaEntity fk_Pessoa_Fisica;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PRODUTO")
	private ProdutoEntity fk_Produto;

	public int getId_Favoritos() {
		return id_Favoritos;
	}

	public void setId_Favoritos(int id_Favoritos) {
		this.id_Favoritos = id_Favoritos;
	}

	public PessoaFisicaEntity getFk_Pessoa_Fisica() {
		return fk_Pessoa_Fisica;
	}

	public void setFk_Pessoa_Fisica(PessoaFisicaEntity fk_Pessoa_Fisica) {
		this.fk_Pessoa_Fisica = fk_Pessoa_Fisica;
	}

	public ProdutoEntity getFk_Produto() {
		return fk_Produto;
	}

	public void setFk_Produto(ProdutoEntity fk_Produto) {
		this.fk_Produto = fk_Produto;
	}

	
	
}

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
@Table(name="AVALIACAO_PRODUTO")
@XmlRootElement
public class Avaliacao_ProdutoEntity 
{
	@Id
	@Column(name="ID_AVALIACAO_PRODUTO")
	@GeneratedValue(generator="id_avaliacao_produto")
    @GenericGenerator(name="id_avaliacao_produto", strategy = "increment")
	private int id_Avaliacao_Produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PRODUTO")
	private ProdutoEntity fk_Produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PESSOA_FISICA")
	private PessoaFisicaEntity fk_Pessoa_Fisica;
	
	@Column(name="COMENTARIO")
	private String comentario;
	
	@Column(name="NOTA")
	private int nota;

	public int getId_Avaliacao_Produto() {
		return id_Avaliacao_Produto;
	}

	public void setId_Avaliacao_Produto(int id_Avaliacao_Produto) {
		this.id_Avaliacao_Produto = id_Avaliacao_Produto;
	}

	public ProdutoEntity getFk_Produto() {
		return fk_Produto;
	}

	public void setFk_Produto(ProdutoEntity fk_Produto) {
		this.fk_Produto = fk_Produto;
	}

	public PessoaFisicaEntity getFk_Pessoa_Fisica() {
		return fk_Pessoa_Fisica;
	}

	public void setFk_Pessoa_Fisica(PessoaFisicaEntity fk_Pessoa_Fisica) {
		this.fk_Pessoa_Fisica = fk_Pessoa_Fisica;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	
}

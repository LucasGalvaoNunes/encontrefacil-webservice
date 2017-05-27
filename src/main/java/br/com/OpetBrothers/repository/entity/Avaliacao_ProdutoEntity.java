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
	private int Id_Avaliacao_Produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PRODUTO")
	private ProdutoEntity Fk_Produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PESSOA_FISICA")
	private PessoaFisicaEntity Fk_Pessoa_Fisica;
	
	@Column(name="COMENTARIO")
	private String Comentario;
	
	@Column(name="NOTA")
	private int Nota;

	public int getId_Avaliacao_Produto() {
		return Id_Avaliacao_Produto;
	}

	public void setId_Avaliacao_Produto(int id_Avaliacao_Produto) {
		Id_Avaliacao_Produto = id_Avaliacao_Produto;
	}

	public ProdutoEntity getFk_Produto() {
		return Fk_Produto;
	}

	public void setFk_Produto(ProdutoEntity fk_Produto) {
		Fk_Produto = fk_Produto;
	}

	public PessoaFisicaEntity getFk_Pessoa_Fisica() {
		return Fk_Pessoa_Fisica;
	}

	public void setFk_Pessoa_Fisica(PessoaFisicaEntity fk_Pessoa_Fisica) {
		Fk_Pessoa_Fisica = fk_Pessoa_Fisica;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	public int getNota() {
		return Nota;
	}

	public void setNota(int nota) {
		Nota = nota;
	}
	
	
}

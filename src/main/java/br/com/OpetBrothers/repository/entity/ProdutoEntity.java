package br.com.OpetBrothers.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PRODUTO")
@XmlRootElement
public class ProdutoEntity {
	@Id
	@Column(name="ID_PRODUTO")
	@GeneratedValue(generator="id_produto")
    @GenericGenerator(name="id_produto", strategy = "increment")
	private int id_produto;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_MARCA_PRODUTO")
	private Marca_ProdutoEntity fk_marca_produto;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_CATEGORIA_PRODUTO")
	private Categoria_ProdutoEntity fk_categoria_produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_LOJA")
	private LojaEntity fk_loja;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="PRECO")
	private String preco;
	
	@Lob
	@Column(name = "FOTO")
	private byte[] foto;

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public Marca_ProdutoEntity getFk_marca_produto() {
		return fk_marca_produto;
	}

	public void setFk_marca_produto(Marca_ProdutoEntity fk_marca_produto) {
		this.fk_marca_produto = fk_marca_produto;
	}

	public Categoria_ProdutoEntity getFk_categoria_produto() {
		return fk_categoria_produto;
	}

	public void setFk_categoria_produto(Categoria_ProdutoEntity fk_categoria_produto) {
		this.fk_categoria_produto = fk_categoria_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public LojaEntity getFk_loja() {
		return fk_loja;
	}

	public void setFk_loja(LojaEntity fk_loja) {
		this.fk_loja = fk_loja;
	}

	
	
	
}

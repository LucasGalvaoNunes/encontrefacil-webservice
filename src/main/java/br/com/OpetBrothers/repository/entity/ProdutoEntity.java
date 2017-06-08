package br.com.OpetBrothers.repository.entity;

import java.sql.Timestamp;

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
	private int id_Produto;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_CATEGORIA_PRODUTO")
	private Categoria_ProdutoEntity fk_Categoria_Produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_MARCA_PRODUTO")
	private Marca_ProdutoEntity fk_Marca_Produto;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PESSOA_JURIDICA")
	private PessoaJuridicaEntity fk_Pessoa_Juridica;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@Column(name="PRECO")
	private String preco;
	
	@Lob
	@Column(name = "FOTO")
	private byte[] foto;
	
	@Column(name = "DATA_PUBLICACAO")
	private Timestamp data_Publicacao;
	
	@Column(name = "QTD_VISITA")
	private int qtd_visita;
	
	@Column(name = "IS_ACTIVE")
	private int is_active;

	public int getId_Produto() {
		return id_Produto;
	}

	public void setId_Produto(int id_Produto) {
		this.id_Produto = id_Produto;
	}

	public Categoria_ProdutoEntity getFk_Categoria_Produto() {
		return fk_Categoria_Produto;
	}

	public void setFk_Categoria_Produto(Categoria_ProdutoEntity fk_Categoria_Produto) {
		this.fk_Categoria_Produto = fk_Categoria_Produto;
	}

	public Marca_ProdutoEntity getFk_Marca_Produto() {
		return fk_Marca_Produto;
	}

	public void setFk_Marca_Produto(Marca_ProdutoEntity fk_Marca_Produto) {
		this.fk_Marca_Produto = fk_Marca_Produto;
	}
	

	public PessoaJuridicaEntity getFk_Pessoa_Juridica() {
		return fk_Pessoa_Juridica;
	}

	public void setFk_Pessoa_Juridica(PessoaJuridicaEntity fk_Pessoa_Juridica) {
		this.fk_Pessoa_Juridica = fk_Pessoa_Juridica;
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

	public Timestamp getData_Publicacao() {
		return data_Publicacao;
	}

	public void setData_Publicacao(Timestamp data_Publicacao) {
		this.data_Publicacao = data_Publicacao;
	}

	public int getQtd_visita() {
		return qtd_visita;
	}

	public void setQtd_visita(int qtd_visita) {
		this.qtd_visita = qtd_visita;
	}

	public int getIs_active() {
		return is_active;
	}

	public void setIs_active(int is_active) {
		this.is_active = is_active;
	}

}

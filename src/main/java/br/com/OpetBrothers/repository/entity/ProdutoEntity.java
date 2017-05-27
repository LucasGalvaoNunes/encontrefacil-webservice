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
	private int Id_Produto;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_CATEGORIA_PRODUTO")
	private Categoria_ProdutoEntity Fk_Categoria_Produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_MARCA_PRODUTO")
	private Marca_ProdutoEntity Fk_Marca_Produto;

	
	@Column(name="NOME")
	private String Nome;
	
	@Column(name="DESCRICAO")
	private String Descricao;
	
	@Column(name="PRECO")
	private String Preco;
	
	@Lob
	@Column(name = "FOTO")
	private byte[] Foto;
	
	@Column(name = "DATA_PUBLICACAO")
	private Timestamp Data_Publicacao;

	public int getId_Produto() {
		return Id_Produto;
	}

	public void setId_Produto(int id_Produto) {
		Id_Produto = id_Produto;
	}

	public Categoria_ProdutoEntity getFk_Categoria_Produto() {
		return Fk_Categoria_Produto;
	}

	public void setFk_Categoria_Produto(Categoria_ProdutoEntity fk_Categoria_Produto) {
		Fk_Categoria_Produto = fk_Categoria_Produto;
	}

	public Marca_ProdutoEntity getFk_Marca_Produto() {
		return Fk_Marca_Produto;
	}

	public void setFk_Marca_Produto(Marca_ProdutoEntity fk_Marca_Produto) {
		Fk_Marca_Produto = fk_Marca_Produto;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getPreco() {
		return Preco;
	}

	public void setPreco(String preco) {
		Preco = preco;
	}

	public byte[] getFoto() {
		return Foto;
	}

	public void setFoto(byte[] foto) {
		Foto = foto;
	}

	public Timestamp getData_Publicacao() {
		return Data_Publicacao;
	}

	public void setData_Publicacao(Timestamp data_Publicacao) {
		Data_Publicacao = data_Publicacao;
	}

	
	
	
}

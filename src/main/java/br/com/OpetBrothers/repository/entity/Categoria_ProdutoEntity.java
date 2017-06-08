package br.com.OpetBrothers.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CATEGORIA_PRODUTO")
@XmlRootElement
public class Categoria_ProdutoEntity {
	@Id
	@Column(name="ID_CATEGORIA_PRODUTO")
	@GeneratedValue(generator="id_categoria_produto")
    @GenericGenerator(name="id_categoria_produto", strategy = "increment")
	private int id_Categoria_Produto;
	
	@Column(name="NOME")
	private String nome;

	public int getId_Categoria_Produto() {
		return id_Categoria_Produto;
	}

	public void setId_Categoria_Produto(int id_Categoria_Produto) {
		this.id_Categoria_Produto = id_Categoria_Produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}

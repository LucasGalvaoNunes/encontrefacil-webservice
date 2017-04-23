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
	private int id_categoria_produto;
	
	@Column(name="NOME")
	private String nome;
	
	public int getId_categoria_produto() {
		return id_categoria_produto;
	}
	public void setId_categoria_produto(int id_categoria_produto) {
		this.id_categoria_produto = id_categoria_produto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

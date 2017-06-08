package br.com.OpetBrothers.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="MARCA_PRODUTO")
@XmlRootElement
public class Marca_ProdutoEntity {
	@Id
	@Column(name="ID_MARCA_PRODUTO")
	@GeneratedValue(generator="id_marca_produto")
    @GenericGenerator(name="id_marca_produto", strategy = "increment")
	private int id_Marca_Produto;
	
	@Column(name="NOME")
	private String nome;

	public int getId_Marca_Produto() {
		return id_Marca_Produto;
	}

	public void setId_Marca_Produto(int id_Marca_Produto) {
		this.id_Marca_Produto = id_Marca_Produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	

	
}

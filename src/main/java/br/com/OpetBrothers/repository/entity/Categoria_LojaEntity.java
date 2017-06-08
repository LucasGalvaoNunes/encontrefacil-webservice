package br.com.OpetBrothers.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CATEGORIA_LOJA")
@XmlRootElement
public class Categoria_LojaEntity {
	@Id
	@Column(name="ID_CATEGORIA_LOJA")
	@GeneratedValue(generator="categoria_loja")
    @GenericGenerator(name="categoria_loja", strategy = "increment")
	private int id_Categoria_Loja;
	
	@Column(name="NOME")
	private String nome;

	public int getId_Categoria_Loja() {
		return id_Categoria_Loja;
	}

	public void setId_Categoria_Loja(int id_Categoria_Loja) {
		this.id_Categoria_Loja = id_Categoria_Loja;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}

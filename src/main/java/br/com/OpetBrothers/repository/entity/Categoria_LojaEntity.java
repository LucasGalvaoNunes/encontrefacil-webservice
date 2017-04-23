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
	private int categoria_loja;
	
	@Column(name="NOME")
	private String nome;
	
	public int getCategoria_loja() {
		return categoria_loja;
	}
	public void setCategoria_loja(int categoria_loja) {
		this.categoria_loja = categoria_loja;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

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
	private int id_avaliacao_produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PRODUTO")
	private ProdutoEntity fk_produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_USUARIO")
	private UsuarioEntity fk_usuario;
	
	@Column(name="COMENTARIO")
	private String comentario;
	
	@Column(name="NOTA")
	private int nota;
	
	
	public int getId_avaliacao_produto() {
		return id_avaliacao_produto;
	}
	public void setId_avaliacao_produto(int id_avaliacao_produto) {
		this.id_avaliacao_produto = id_avaliacao_produto;
	}
	public ProdutoEntity getFk_produto() {
		return fk_produto;
	}
	public void setFk_produto(ProdutoEntity fk_produto) {
		this.fk_produto = fk_produto;
	}
	public UsuarioEntity getFk_usuario() {
		return fk_usuario;
	}
	public void setFk_usuario(UsuarioEntity fk_usuario) {
		this.fk_usuario = fk_usuario;
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

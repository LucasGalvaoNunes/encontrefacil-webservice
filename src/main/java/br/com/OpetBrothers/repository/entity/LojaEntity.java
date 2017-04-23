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
@Table(name="LOJA")
@XmlRootElement
public class LojaEntity {
	@Id
	@Column(name="ID_LOJA")
	@GeneratedValue(generator="id_loja")
    @GenericGenerator(name="id_loja", strategy = "increment")
	private int id_loja;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_LOCALIZACAO")
	private LocalizacaoEntity fk_localizacao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_USUARIO")
	private UsuarioEntity fk_usuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_CATEGORIA_LOJA")
	private Categoria_LojaEntity fk_categoria_loja;
	
	@Column(name="NOME")
	private String nome;
	
	@Lob
	@Column(name = "FOTO")
	private byte[] foto;

	public int getId_loja() {
		return id_loja;
	}

	public void setId_loja(int id_loja) {
		this.id_loja = id_loja;
	}

	public LocalizacaoEntity getFk_localizacao() {
		return fk_localizacao;
	}

	public void setFk_localizacao(LocalizacaoEntity fk_localizacao) {
		this.fk_localizacao = fk_localizacao;
	}

	public UsuarioEntity getFk_usuario() {
		return fk_usuario;
	}

	public void setFk_usuario(UsuarioEntity fk_usuario) {
		this.fk_usuario = fk_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria_LojaEntity getFk_categoria_loja() {
		return fk_categoria_loja;
	}

	public void setFk_categoria_loja(Categoria_LojaEntity fk_categoria_loja) {
		this.fk_categoria_loja = fk_categoria_loja;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	
}

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
@Table(name="USUARIO")
@XmlRootElement
public class UsuarioEntity {
	@Id
	@Column(name="ID_USUARIO")
	@GeneratedValue(generator="id_usuario")
    @GenericGenerator(name="id_usuario", strategy = "increment")
	private int id_usuario;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_LOCALIZACAO")
	private LocalizacaoEntity fk_localizacao;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="SOBRENOME")
	private String sobrenome;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="SENHA")
	private String senha;

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public LocalizacaoEntity getFk_localizacao() {
		return fk_localizacao;
	}

	public void setFk_localizacao(LocalizacaoEntity fk_localizacao) {
		this.fk_localizacao = fk_localizacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}

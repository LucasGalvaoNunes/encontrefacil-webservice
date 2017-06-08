package br.com.OpetBrothers.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="PESSOA")
@XmlRootElement
public class PessoaEntity {
	@Id
	@Column(name="ID_PESSOA")
	@GeneratedValue(generator="id_pessoa")
    @GenericGenerator(name="id_pessoa", strategy = "increment")
	private int id_Pessoa;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="SOBRENOME")
	private String sobrenome;
	
	@Column(name="TELEFONE")
	private String telefone;
	
	@Lob
	@Column(name="FOTO")
	private byte[] foto;
	
	@Column(name="EMAIL")
	private String email;

	public int getId_Pessoa() {
		return id_Pessoa;
	}

	public void setId_Pessoa(int id_Pessoa) {
		this.id_Pessoa = id_Pessoa;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

		
	
}

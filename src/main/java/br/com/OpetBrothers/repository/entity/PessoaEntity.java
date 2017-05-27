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
	private int Id_Pessoa;
	
	@Column(name="NOME")
	private String Nome;
	
	@Column(name="SOBRENOME")
	private String Sobrenome;
	
	@Column(name="TELEFONE")
	private String Telefone;
	
	@Lob
	@Column(name="FOTO")
	private byte[] Foto;
	
	@Column(name="EMAIL")
	private String Email;

	public int getId_Pessoa() {
		return Id_Pessoa;
	}

	public void setId_Pessoa(int id_Pessoa) {
		Id_Pessoa = id_Pessoa;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public byte[] getFoto() {
		return Foto;
	}

	public void setFoto(byte[] foto) {
		Foto = foto;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
	
}

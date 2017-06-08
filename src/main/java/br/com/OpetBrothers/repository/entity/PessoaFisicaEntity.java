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
@Table(name="PESSOA_FISICA")
@XmlRootElement
public class PessoaFisicaEntity {
	@Id
	@Column(name="ID_PESSOA_FISICA")
	@GeneratedValue(generator="Id_PessoaFisica")
    @GenericGenerator(name="Id_PessoaFisica", strategy = "increment")
	private int id_PessoaFisica;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PESSOA")
	private PessoaEntity fk_Pessoa;
	
	@Column(name="CPF")
	private String cpf;
	
	@Column(name="ID_FACEBOOK",columnDefinition="LONGVARCHAR")
	private String id_facebook;

	public int getId_PessoaFisica() {
		return id_PessoaFisica;
	}

	public void setId_PessoaFisica(int id_PessoaFisica) {
		this.id_PessoaFisica = id_PessoaFisica;
	}

	public PessoaEntity getFk_Pessoa() {
		return fk_Pessoa;
	}

	public void setFk_Pessoa(PessoaEntity fk_Pessoa) {
		this.fk_Pessoa = fk_Pessoa;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getId_facebook() {
		return id_facebook;
	}

	public void setId_facebook(String id_facebook) {
		this.id_facebook = id_facebook;
	}

	
	
}

package br.com.OpetBrothers.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private int Id_PessoaFisica;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PESSOA")
	private PessoaEntity Fk_Pessoa;
	
	@Column(name="CPF")
	private String Cpf;

	public int getId_PessoaFisica() {
		return Id_PessoaFisica;
	}

	public void setId_PessoaFisica(int id_PessoaFisica) {
		Id_PessoaFisica = id_PessoaFisica;
	}

	public PessoaEntity getFk_Pessoa() {
		return Fk_Pessoa;
	}

	public void setFk_Pessoa(PessoaEntity fk_Pessoa) {
		Fk_Pessoa = fk_Pessoa;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}
	
	
	
	
}

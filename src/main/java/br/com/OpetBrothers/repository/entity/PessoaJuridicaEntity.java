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
@Table(name="PESSOA_JURIDICA")
@XmlRootElement
public class PessoaJuridicaEntity {

	@Id
	@Column(name="ID_PESSOA_JURIDICA")
	@GeneratedValue(generator="Id_PessoaJuridica")
    @GenericGenerator(name="Id_PessoaJuridica", strategy = "increment")
	private int Id_PessoaJuridica;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PESSOA")
	private PessoaEntity Fk_Pessoa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_CATEGORIA_LOJA")
	private Categoria_LojaEntity Fk_Categoria_Loja;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_LOCALIZACAO")
	private LocalizacaoEntity Fk_Localizacao;
	
	
	@Column(name="SENHA")
	private String Senha;
	
	@Column(name="RAZAO_SOCIAL")
	private String Razao_Social;
	
	@Column(name="CNPJ")
	private String Cnpj;

	public int getId_PessoaJuridica() {
		return Id_PessoaJuridica;
	}

	public void setId_PessoaJuridica(int id_PessoaJuridica) {
		Id_PessoaJuridica = id_PessoaJuridica;
	}

	public PessoaEntity getFk_Pessoa() {
		return Fk_Pessoa;
	}

	public void setFk_Pessoa(PessoaEntity fk_Pessoa) {
		Fk_Pessoa = fk_Pessoa;
	}

	public Categoria_LojaEntity getFk_Categoria_Loja() {
		return Fk_Categoria_Loja;
	}

	public void setFk_Categoria_Loja(Categoria_LojaEntity fk_Categoria_Loja) {
		Fk_Categoria_Loja = fk_Categoria_Loja;
	}

	public LocalizacaoEntity getFk_Localizacao() {
		return Fk_Localizacao;
	}

	public void setFk_Localizacao(LocalizacaoEntity fk_Localizacao) {
		Fk_Localizacao = fk_Localizacao;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getRazao_Social() {
		return Razao_Social;
	}

	public void setRazao_Social(String razao_Social) {
		Razao_Social = razao_Social;
	}

	public String getCnpj() {
		return Cnpj;
	}

	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}
	
	

}

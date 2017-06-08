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
	private int id_PessoaJuridica;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PESSOA")
	private PessoaEntity fk_Pessoa;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_CATEGORIA_LOJA")
	private Categoria_LojaEntity fk_Categoria_Loja;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_LOCALIZACAO")
	private LocalizacaoEntity fk_Localizacao;
	
	
	@Column(name="SENHA")
	private String senha;
	
	@Column(name="RAZAO_SOCIAL")
	private String razao_Social;
	
	@Column(name="CNPJ")
	private String cnpj;
	
	@Column(name="CODIGO_VERIFICACAO")
	private String codigo_verificacao;

	public int getId_PessoaJuridica() {
		return id_PessoaJuridica;
	}

	public void setId_PessoaJuridica(int id_PessoaJuridica) {
		this.id_PessoaJuridica = id_PessoaJuridica;
	}

	public PessoaEntity getFk_Pessoa() {
		return fk_Pessoa;
	}

	public void setFk_Pessoa(PessoaEntity fk_Pessoa) {
		this.fk_Pessoa = fk_Pessoa;
	}

	public Categoria_LojaEntity getFk_Categoria_Loja() {
		return fk_Categoria_Loja;
	}

	public void setFk_Categoria_Loja(Categoria_LojaEntity fk_Categoria_Loja) {
		this.fk_Categoria_Loja = fk_Categoria_Loja;
	}

	public LocalizacaoEntity getFk_Localizacao() {
		return fk_Localizacao;
	}

	public void setFk_Localizacao(LocalizacaoEntity fk_Localizacao) {
		this.fk_Localizacao = fk_Localizacao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRazao_Social() {
		return razao_Social;
	}

	public void setRazao_Social(String razao_Social) {
		this.razao_Social = razao_Social;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCodigo_verificacao() {
		return codigo_verificacao;
	}

	public void setCodigo_verificacao(String codigo_verificacao) {
		this.codigo_verificacao = codigo_verificacao;
	}

	
	
}

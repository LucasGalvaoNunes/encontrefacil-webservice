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
@Table(name="FAVORITOS_PESSOA_FISICA")
@XmlRootElement
public class FavoritosPessoaFisicaEntity {

	
	@Id
	@Column(name="ID_FAVORITOS")
	@GeneratedValue(generator="Id_Favoritos")
    @GenericGenerator(name="Id_Favoritos", strategy = "increment")
	private int Id_Favoritos;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PESSOA_FISICA")
	private PessoaFisicaEntity Fk_Pessoa_Fisica;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PRODUTO")
	private ProdutoEntity Fk_Produto;
	
}

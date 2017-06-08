package br.com.OpetBrothers.repository.entity;

import java.sql.Timestamp;

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
@Table(name="PRODUTOS_DESTAQUE")
@XmlRootElement
public class ProdutoDestaqueEntity {
	
	@Id
	@Column(name="ID_PRODUTOS_DESTAQUE")
	@GeneratedValue(generator="id_produto_destaque")
    @GenericGenerator(name="id_produto_destaque", strategy = "increment")
	private int id_produto_destaque;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="FK_PRODUTO")
	private ProdutoEntity fk_produto;
	
	@Column(name="DATA_ENTRADA")
	private Timestamp data_entrada;
	
	@Column(name="DATA_SAIDA")
	private Timestamp data_saida;
	
	@Column(name="EXPOSICAO")
	private int exposicao;
	
	
	public int getId_produto_destaque() {
		return id_produto_destaque;
	}
	public void setId_produto_destaque(int id_produto_destaque) {
		this.id_produto_destaque = id_produto_destaque;
	}
	public ProdutoEntity getFk_produto() {
		return fk_produto;
	}
	public void setFk_produto(ProdutoEntity fk_produto) {
		this.fk_produto = fk_produto;
	}
	public Timestamp getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(Timestamp data_entrada) {
		this.data_entrada = data_entrada;
	}
	public Timestamp getData_saida() {
		return data_saida;
	}
	public void setData_saida(Timestamp data_saida) {
		this.data_saida = data_saida;
	}
	public int getExposicao() {
		return exposicao;
	}
	public void setExposicao(int exposicao) {
		this.exposicao = exposicao;
	}
	
	
	
}

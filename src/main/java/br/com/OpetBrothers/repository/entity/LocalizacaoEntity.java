package br.com.OpetBrothers.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="LOCALIZACAO")
@XmlRootElement
public class LocalizacaoEntity {
	@Id
	@Column(name="ID_LOCALIZACAO")
	@GeneratedValue(generator="id_localizacao")
    @GenericGenerator(name="id_localizacao", strategy = "increment")
	private int id_localizacao;
	
	@Column(name="LONGITUDE")
	private String longitude;
	
	@Column(name="LATITUDE")
	private String latitude;

	public int getId_localizacao() {
		return id_localizacao;
	}

	public void setId_localizacao(int id_localizacao) {
		this.id_localizacao = id_localizacao;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
}

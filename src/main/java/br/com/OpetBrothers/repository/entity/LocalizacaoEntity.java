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
	private int Id_Localizacao;
	
	@Column(name="LONGITUDE")
	private String Longitude;
	
	@Column(name="LATITUDE")
	private String Latitude;

	public int getId_Localizacao() {
		return Id_Localizacao;
	}

	public void setId_Localizacao(int id_Localizacao) {
		Id_Localizacao = id_Localizacao;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}


	
	
}

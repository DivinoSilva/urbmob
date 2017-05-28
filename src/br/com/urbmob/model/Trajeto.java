package br.com.urbmob.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Trajeto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Double latIni;
	private Double longIni;
	private Double latFim;
	private Double longFim;
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Rota> rotas;

	public Double getLatIni() {
		return latIni;
	}

	public void setLatIni(Double latIni) {
		this.latIni = latIni;
	}

	public Double getLongIni() {
		return longIni;
	}

	public void setLongIni(Double longIni) {
		this.longIni = longIni;
	}

	public Double getLatFim() {
		return latFim;
	}

	public void setLatFim(Double latFim) {
		this.latFim = latFim;
	}

	public Double getLongFim() {
		return longFim;
	}

	public void setLongFim(Double longFim) {
		this.longFim = longFim;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}
}

package com.proyecto.android.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "monumentos")
public class Monumento implements Serializable {

	@Id
	@Column(name = "idnotes")
	private int idnotes;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "X")
	private double X;

	@Column(name = "Y")
	private double Y;

	@Column(name = "numpol")
	private String numpol;

	@Column(name = "codvia")
	private String codvia;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "ruta")
	private String ruta;

	@Column(name = "img")
	private String img;

	public Monumento() {
		super();
	}

	public Monumento(int idnotes, String nombre, double x, double y, String numpol, String codvia, String telefono,
			String ruta, String img) {
		super();
		this.idnotes = idnotes;
		this.nombre = nombre;
		X = x;
		Y = y;
		this.numpol = numpol;
		this.codvia = codvia;
		this.telefono = telefono;
		this.ruta = ruta;
		this.img = img;
	}

	public int getIdnotes() {
		return idnotes;
	}

	public void setIdnotes(int idnotes) {
		this.idnotes = idnotes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getX() {
		return X;
	}

	public void setX(double x) {
		X = x;
	}

	public double getY() {
		return Y;
	}

	public void setY(double y) {
		Y = y;
	}

	public String getNumpol() {
		return numpol;
	}

	public void setNumpol(String numpol) {
		this.numpol = numpol;
	}

	public String getCodvia() {
		return codvia;
	}

	public void setCodvia(String codvia) {
		this.codvia = codvia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}

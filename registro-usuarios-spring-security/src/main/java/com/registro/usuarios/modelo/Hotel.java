package com.registro.usuarios.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	private Integer id_hotel;
	
	@NotBlank
	@Column(name = "nombre")
	private String nombre;
	
	@NotBlank
	private String direccion;
	
	@NotBlank
	private String distrito;
	
	private Integer numero;
	
	private Integer ruc;
	
	private String estado;
	
	@NotBlank
	private String descripcion;
	
	private String rutalogo;

	@Transient
	private MultipartFile logo;
	
	
	private Date fechacreacion;




	public Hotel(@NotBlank String nombre, @NotBlank String direccion, @NotBlank String distrito, Integer numero,
			Integer ruc, @NotBlank String descripcion, String rutalogo, MultipartFile logo, Date fechacreacion) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.distrito = distrito;
		this.numero = numero;
		this.ruc = ruc;
		this.descripcion = descripcion;
		this.rutalogo = rutalogo;
		this.logo = logo;
		this.fechacreacion = fechacreacion;
	}


	public Hotel(Integer id_hotel, @NotBlank String nombre, @NotBlank String direccion, @NotBlank String distrito,
			Integer numero, Integer ruc, @NotBlank String descripcion, String rutalogo, MultipartFile logo,
			Date fechacreacion) {
		super();
		this.id_hotel = id_hotel;
		this.nombre = nombre;
		this.direccion = direccion;
		this.distrito = distrito;
		this.numero = numero;
		this.ruc = ruc;
		this.descripcion = descripcion;
		this.rutalogo = rutalogo;
		this.logo = logo;
		this.fechacreacion = fechacreacion;
	}


	public Hotel() {
		super();
	}
	
	
	


	public Integer getId_hotel() {
		return id_hotel;
	}


	public void setId_hotel(Integer id_hotel) {
		this.id_hotel = id_hotel;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDistrito() {
		return distrito;
	}


	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public Integer getRuc() {
		return ruc;
	}


	public void setRuc(Integer ruc) {
		this.ruc = ruc;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getRutalogo() {
		return rutalogo;
	}


	public void setRutalogo(String rutalogo) {
		this.rutalogo = rutalogo;
	}


	public MultipartFile getLogo() {
		return logo;
	}


	public void setLogo(MultipartFile logo) {
		this.logo = logo;
	}


	public Date getFechacreacion() {
		return fechacreacion;
	}


	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}	
	
	
	
	
	
}

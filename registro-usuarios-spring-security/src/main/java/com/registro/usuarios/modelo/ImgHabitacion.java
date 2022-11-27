package com.registro.usuarios.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class ImgHabitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_img")
	private Integer id;

	@NotBlank
	private String nombre;
	
	private String rutaimagenhabi;

	@Transient
	private MultipartFile imghabitacion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRutaimagenhabi() {
		return rutaimagenhabi;
	}

	public void setRutaimagenhabi(String rutaimagenhabi) {
		this.rutaimagenhabi = rutaimagenhabi;
	}

	public MultipartFile getImghabitacion() {
		return imghabitacion;
	}

	public void setImghabitacion(MultipartFile imghabitacion) {
		this.imghabitacion = imghabitacion;
	}

	public ImgHabitacion(@NotBlank String nombre, String rutaimagenhabi, MultipartFile imghabitacion) {
		super();
		this.nombre = nombre;
		this.rutaimagenhabi = rutaimagenhabi;
		this.imghabitacion = imghabitacion;
	}

	public ImgHabitacion(Integer id, @NotBlank String nombre, String rutaimagenhabi, MultipartFile imghabitacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rutaimagenhabi = rutaimagenhabi;
		this.imghabitacion = imghabitacion;
	}

	public ImgHabitacion() {
		super();
	}
	
	
	
}

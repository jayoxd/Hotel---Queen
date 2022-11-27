package com.registro.usuarios.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Tipo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tipo")
	private Integer id_tipo;

	@NotBlank
	private String nombre;

	@NotBlank
	private String descripcion;

	public Tipo() {
		super();
	}

	public Tipo(Integer id_tipo, @NotBlank String nombre, @NotBlank String descripcion) {
		super();
		this.id_tipo = id_tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Tipo(@NotBlank String nombre, @NotBlank String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Integer getId_tipo() {
		return id_tipo;
	}

	public void setId_tipo(Integer id_tipo) {
		this.id_tipo = id_tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	

}

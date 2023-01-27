package com.registro.usuarios.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")

public class Rol {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private Integer id_rol;
	@NotBlank
	private String nombre;
	
	private String descripcion;
	
	
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getId_rol() {
		return id_rol;
	}
	public void setId_rol(Integer id_rol) {
		this.id_rol = id_rol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Rol(Integer id_rol, @NotBlank String nombre) {
		super();
		this.id_rol = id_rol;
		this.nombre = nombre;
	}
	public Rol() {
		super();
	}
	public Rol(@NotBlank String nombre) {
		super();
		this.nombre = nombre;
	}
	public Rol(Integer id_rol, @NotBlank String nombre, String descripcion) {
		super();
		this.id_rol = id_rol;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public Rol(@NotBlank String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
	
	
	

	/*@OneToMany(fetch=FetchType.LAZY, mappedBy="ciudad")
	private List<Usuario> persons=new ArrayList<Usuario>();
*/
	

	
}

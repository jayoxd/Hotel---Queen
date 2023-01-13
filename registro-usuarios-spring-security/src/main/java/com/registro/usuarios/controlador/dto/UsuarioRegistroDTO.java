package com.registro.usuarios.controlador.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.registro.usuarios.modelo.Rol;

public class UsuarioRegistroDTO {

	



	private Integer id;
	private String nombre;
	private String apellido;
	private String email;
	private Integer telefono;
	private LocalDate fechaNacimiento;
	private String password;
	private Rol rol;
	private String rutaimagenhabi;
	@Transient
	private MultipartFile imghabitacion;
	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}




	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
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
	
	
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	
	
	public UsuarioRegistroDTO() {

	}


	public UsuarioRegistroDTO(String nombre, String apellido, String email, Integer telefono, LocalDate fechaNacimiento,
			String password, Rol rol, String rutaimagenhabi, MultipartFile imghabitacion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.rol = rol;
		this.rutaimagenhabi = rutaimagenhabi;
		this.imghabitacion = imghabitacion;
	}

	public UsuarioRegistroDTO(Integer id, String nombre, String apellido, String email, Integer telefono,
			LocalDate fechaNacimiento, String password, Rol rol, String rutaimagenhabi, MultipartFile imghabitacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.rol = rol;
		this.rutaimagenhabi = rutaimagenhabi;
		this.imghabitacion = imghabitacion;
	}

}

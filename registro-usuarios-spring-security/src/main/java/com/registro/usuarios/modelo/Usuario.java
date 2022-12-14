package com.registro.usuarios.modelo;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "apellido")
	private String apellido;

	@Column(name = "telefono")
	private Integer telefono;

	@Column(name = "fechaNacimiento")
	@DateTimeFormat(iso = ISO.DATE)
	private Date fechaNacimiento;
	
	private String email;
	
	private String password;
	
	
	private String rutaimagenhabi;

	@Transient
	private MultipartFile imghabitacion;
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "usuario_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "rol_id",referencedColumnName = "id")
			)
	private Collection<Rol> roles;

	
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}



	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, Integer telefono, Date fechaNacimiento, String email,
			String password, String rutaimagenhabi, MultipartFile imghabitacion, Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.password = password;
		this.rutaimagenhabi = rutaimagenhabi;
		this.imghabitacion = imghabitacion;
		this.roles = roles;
	}

	public Usuario(Long id, String nombre, String apellido, Integer telefono, Date fechaNacimiento, String email,
			String password, String rutaimagenhabi, MultipartFile imghabitacion, Collection<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.password = password;
		this.rutaimagenhabi = rutaimagenhabi;
		this.imghabitacion = imghabitacion;
		this.roles = roles;
	}

	

	
	
	
}

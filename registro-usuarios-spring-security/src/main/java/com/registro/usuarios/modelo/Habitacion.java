package com.registro.usuarios.modelo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_habitacion")
	private Integer id;

	@NotBlank
	private String nombre;

	@Min(0)
	private Integer invitados;

	@Min(0)
	private Double precio;

	@NotBlank
	private String descripcion;
	
	private String estado;

//	private String rutaimagenhabi;

	//@JoinColumn(name = "id", referencedColumnName = "id")
	//@ManyToOne(fetch = FetchType.LAZY)
	// PONER EL EAGER ACA SI HEMOS PUESTO EN EL OTRO
//	private Usuario idUsuario;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo")
	@ManyToOne(fetch = FetchType.LAZY)
	// PONER EL EAGER ACA SI HEMOS PUESTO EN EL OTRO
	private Tipo idTipo;
	
	
	@NotEmpty	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "habitacion_imagenx", joinColumns = @JoinColumn(name = "id_habitacion"), 
	inverseJoinColumns = @JoinColumn(name = "id_img"))
	private List<ImgHabitacion> imagenes;
	
	
	@NotEmpty	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "habitacion_caracteristica", joinColumns = @JoinColumn(name = "id_habitacion")
	, inverseJoinColumns = @JoinColumn(name = "id_caracteristica"))
	private List<Caracteristica> caracteristica;

//	@Transient
//	private MultipartFile imghabitacion;

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

	public Integer getInvitados() {
		return invitados;
	}

	public void setInvitados(Integer invitados) {
		this.invitados = invitados;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	/*public String getRutaimagenhabi() {
		return rutaimagenhabi;
	}

	public void setRutaimagenhabi(String rutaimagenhabi) {
		this.rutaimagenhabi = rutaimagenhabi;
	}*/



	public Tipo getIdTipo() {
		return idTipo;
	}

	public void setIdTipo(Tipo idTipo) {
		this.idTipo = idTipo;
	}

	public List<Caracteristica> getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(List<Caracteristica> caracteristica) {
		this.caracteristica = caracteristica;
	}

	/*public MultipartFile getImghabitacion() {
		return imghabitacion;
	}

	public void setImghabitacion(MultipartFile imghabitacion) {
		this.imghabitacion = imghabitacion;
	}*/

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	public List<ImgHabitacion> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<ImgHabitacion> imagenes) {
		this.imagenes = imagenes;
	}

	public Habitacion(@NotBlank String nombre, @Min(0) Integer invitados, @Min(0) Double precio,
			@NotBlank String descripcion, String estado , Tipo idTipo,
			@NotEmpty List<Caracteristica> caracteristica) {
		super();
		this.nombre = nombre;
		this.invitados = invitados;
		this.precio = precio;
		this.descripcion = descripcion;
		this.estado = estado;
		this.idTipo = idTipo;
		this.caracteristica = caracteristica;
	}

	public Habitacion(Integer id, @NotBlank String nombre, @Min(0) Integer invitados, @Min(0) Double precio,
			@NotBlank String descripcion, String estado  , Tipo idTipo,
			@NotEmpty List<Caracteristica> caracteristica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.invitados = invitados;
		this.precio = precio;
		this.descripcion = descripcion;
		this.estado = estado;
		this.idTipo = idTipo;
		this.caracteristica = caracteristica;
	}
	
	
	////////////////////////////////////////////////////////////
	
	
	

	public Habitacion() {
		super();
	}

	public Habitacion(@NotBlank String nombre, @Min(0) Integer invitados, @Min(0) Double precio,
			@NotBlank String descripcion, String estado, Tipo idTipo, @NotEmpty List<ImgHabitacion> imagenes,
			@NotEmpty List<Caracteristica> caracteristica) {
		super();
		this.nombre = nombre;
		this.invitados = invitados;
		this.precio = precio;
		this.descripcion = descripcion;
		this.estado = estado;
		this.idTipo = idTipo;
		this.imagenes = imagenes;
		this.caracteristica = caracteristica;
	}

	public Habitacion(Integer id, @NotBlank String nombre, @Min(0) Integer invitados, @Min(0) Double precio,
			@NotBlank String descripcion, String estado, Tipo idTipo, @NotEmpty List<ImgHabitacion> imagenes,
			@NotEmpty List<Caracteristica> caracteristica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.invitados = invitados;
		this.precio = precio;
		this.descripcion = descripcion;
		this.estado = estado;
		this.idTipo = idTipo;
		this.imagenes = imagenes;
		this.caracteristica = caracteristica;
	}
	
	
	

}

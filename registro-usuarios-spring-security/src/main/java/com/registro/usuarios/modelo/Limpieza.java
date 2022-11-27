package com.registro.usuarios.modelo;
import java.time.LocalDate;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "limpieza")
public class Limpieza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_limpieza")
	private Integer id_limpieza;

	
	private Date fechaCreacion;
	
	private Date fechaRecibida;
	
	@NotBlank
	private String obeservacion;


	@JoinColumn(name = "id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	// PONER EL EAGER ACA SI HEMOS PUESTO EN EL OTRO
	private Usuario idUsuario;
	
	@JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion")
	@ManyToOne(fetch = FetchType.LAZY)
	// PONER EL EAGER ACA SI HEMOS PUESTO EN EL OTRO
	private Habitacion habitacion;

	
	
	
	public Limpieza(Date fechaCreacion, Date fechaRecibida, @NotBlank String obeservacion, Usuario idUsuario,
			Habitacion habitacion) {
		super();
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibida = fechaRecibida;
		this.obeservacion = obeservacion;
		this.idUsuario = idUsuario;
		this.habitacion = habitacion;
	}




	public Limpieza() {
		super();
	}




	public Date getFechaCreacion() {
		return fechaCreacion;
	}




	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}




	public Date getFechaRecibida() {
		return fechaRecibida;
	}




	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}




	public String getObeservacion() {
		return obeservacion;
	}




	public void setObeservacion(String obeservacion) {
		this.obeservacion = obeservacion;
	}




	public Usuario getIdUsuario() {
		return idUsuario;
	}




	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}




	public Habitacion getHabitacion() {
		return habitacion;
	}




	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}
	
	
	
}

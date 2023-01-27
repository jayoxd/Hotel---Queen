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
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Reserva {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReserva")
	private Integer idReserva;

	


	@Min(0)
	private Integer adultos;

	
	@Min(0)
	private Integer niños;

	@NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date fechaReservacion;
	
	@NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date fechaInicio;
	
	@NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date fechaFin;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "adelanto")
	private Double adelanto;
	
	@JoinColumn(name = "id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	// PONER EL EAGER ACA SI HEMOS PUESTO EN EL OTRO
	private Usuario idUsuario;
	
	
	@JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion")
	@ManyToOne(fetch = FetchType.LAZY)
	// PONER EL EAGER ACA SI HEMOS PUESTO EN EL OTRO
	private Habitacion idHabitacion;
	
	
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	@ManyToOne(fetch = FetchType.LAZY)
	// PONER EL EAGER ACA SI HEMOS PUESTO EN EL OTRO
	private Cliente idCliente;


	public Integer getIdReserva() {
		return idReserva;
	}


	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}


	public Integer getAdultos() {
		return adultos;
	}


	public void setAdultos(Integer adultos) {
		this.adultos = adultos;
	}


	public Integer getNiños() {
		return niños;
	}


	public void setNiños(Integer niños) {
		this.niños = niños;
	}


	public Date getFechaReservacion() {
		return fechaReservacion;
	}


	public void setFechaReservacion(Date fechaReservacion) {
		this.fechaReservacion = fechaReservacion;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Double getAdelanto() {
		return adelanto;
	}


	public void setAdelanto(Double adelanto) {
		this.adelanto = adelanto;
	}


	public Usuario getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}


	public Habitacion getIdHabitacion() {
		return idHabitacion;
	}


	public void setIdHabitacion(Habitacion idHabitacion) {
		this.idHabitacion = idHabitacion;
	}


	public Cliente getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}


	public Reserva(Integer idReserva, @Min(0) Integer adultos, @Min(0) Integer niños, @NotNull Date fechaReservacion,
			@NotNull Date fechaInicio, @NotNull Date fechaFin, String estado, Double adelanto, Usuario idUsuario,
			Habitacion idHabitacion, Cliente idCliente) {
		super();
		this.idReserva = idReserva;
		this.adultos = adultos;
		this.niños = niños;
		this.fechaReservacion = fechaReservacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.adelanto = adelanto;
		this.idUsuario = idUsuario;
		this.idHabitacion = idHabitacion;
		this.idCliente = idCliente;
	}


	public Reserva(@Min(0) Integer adultos, @Min(0) Integer niños, @NotNull Date fechaReservacion,
			@NotNull Date fechaInicio, @NotNull Date fechaFin, String estado, Double adelanto, Usuario idUsuario,
			Habitacion idHabitacion, Cliente idCliente) {
		super();
		this.adultos = adultos;
		this.niños = niños;
		this.fechaReservacion = fechaReservacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.estado = estado;
		this.adelanto = adelanto;
		this.idUsuario = idUsuario;
		this.idHabitacion = idHabitacion;
		this.idCliente = idCliente;
	}


	public Reserva() {
		super();
	}
	




	


	
	
}

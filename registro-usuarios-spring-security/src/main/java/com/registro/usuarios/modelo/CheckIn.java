package com.registro.usuarios.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
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
import javax.validation.constraints.Null;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
public class CheckIn {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCheckIn")
	private Integer idCheckIn;

	


	@Min(0)
	private Integer adultos;

	
	@Min(0)
	private Integer niños;


	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaReservacion;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaInicio;
	
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaFin;
	
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime horainicio;

	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime horafin;
	
	
	@Column(name = "adelanto")
	private Double adelanto;
	
	@Column(name = "pago")
	private Double pago;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "nrrecibo")
	private String nrrecibo;
	
	public LocalTime getHorainicio() {
		return horainicio;
	}


	public void setHorainicio(LocalTime horainicio) {
		this.horainicio = horainicio;
	}


	public LocalTime getHorafin() {
		return horafin;
	}


	public void setHorafin(LocalTime horafin) {
		this.horafin = horafin;
	}


	@JoinColumn(name = "id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Usuario idUsuario;
	
	
	@JoinColumn(name = "id_habitacion", referencedColumnName = "id_habitacion")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Habitacion idHabitacion;
	
	
	@JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Cliente clientes;
	
	
	
	@JoinColumn(name = "idReserva", referencedColumnName = "idReserva")
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonProperty(access = Access.WRITE_ONLY)
	private Reserva reserva;
	
	
	
	
	

	
	
	
	
	
	public CheckIn() {
		super();
	}

	
	public Double getAdelanto() {
		return adelanto;
	}

	public void setAdelanto(Double adelanto) {
		this.adelanto = adelanto;
	}

	public Double getPago() {
		return pago;
	}

	public void setPago(Double pago) {
		this.pago = pago;
	}


	public Integer getIdCheckIn() {
		return idCheckIn;
	}

	public void setIdCheckIn(Integer idCheckIn) {
		this.idCheckIn = idCheckIn;
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


	public Cliente getClientes() {
		return clientes;
	}


	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}


	public Reserva getReserva() {
		return reserva;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


	public LocalDate getFechaReservacion() {
		return fechaReservacion;
	}


	public void setFechaReservacion(LocalDate fechaReservacion) {
		this.fechaReservacion = fechaReservacion;
	}


	public LocalDate getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public LocalDate getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	

	
	
	
	

}

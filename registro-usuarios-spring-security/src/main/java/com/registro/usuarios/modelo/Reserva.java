package com.registro.usuarios.modelo;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@Table(name = "reserva")
public class Reserva {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReserva")
	private Integer idReserva;

	


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
	
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "adelanto")
	private Double adelanto;
	
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


	
	
	@OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<CheckIn> checkins = new HashSet<>();
	
	public Set<CheckIn> getCheckins() {
		return checkins;
	}


	public void setCheckins(Set<CheckIn> checkins) {
		this.checkins = checkins;
	}


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




	

	

	public Reserva(Integer idReserva, @Min(0) Integer adultos, @Min(0) Integer niños, LocalDate fechaReservacion,
			LocalDate fechaInicio, LocalDate fechaFin, String estado, Double adelanto, Usuario idUsuario,
			Habitacion idHabitacion, Cliente clientes, Set<CheckIn> checkins) {
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
		this.clientes = clientes;
		this.checkins = checkins;
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


	public Cliente getClientes() {
		return clientes;
	}


	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}


	public Reserva() {
		super();
	}
	




	


	
	
}

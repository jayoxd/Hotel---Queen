package com.registro.usuarios.controlador;

import java.time.LocalDate;
import java.util.List;

import com.registro.usuarios.modelo.Reserva;

public class Day {
	  private LocalDate date;
	  private List<Reserva> reservations;

	  public Day(LocalDate date, List<Reserva> reservations) {
	    this.date = date;
	    this.reservations = reservations;
	  }

	  public LocalDate getDate() {
	    return date;
	  }

	  public List<Reserva> getReservations() {
	    return reservations;
	  }
	}
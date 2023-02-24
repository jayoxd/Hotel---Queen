package com.registro.usuarios.servicio;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


import com.registro.usuarios.modelo.Reserva;


public interface ReservaServicio  {

	public Reserva save( Reserva reserva);
	public Optional<Reserva> get(Integer id);
	public void update(Reserva reserva);
	public void delete(Integer id);
	public List<Reserva> listar();
	public List<Reserva>listarpornom(Integer nombre);
	public List<Reserva>listarreserva(String dato);
	public void actualizarCodigoAutogenerado() ;
	public Reserva isRoomAvailable(LocalDate startDate, LocalDate endDate);
	public boolean  isRoomAvailableXD(LocalDate startDate, LocalDate endDate,Integer id);

}

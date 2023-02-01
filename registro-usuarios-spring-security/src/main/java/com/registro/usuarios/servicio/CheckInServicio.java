package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;

import com.registro.usuarios.modelo.CheckIn;
import com.registro.usuarios.modelo.Reserva;


public interface CheckInServicio  {

	public CheckIn save( CheckIn reserva);
	public Optional<CheckIn> get(Integer id);
	public void update(CheckIn reserva);
	public void delete(Integer id);
	public List<CheckIn> listar();
	public List<CheckIn>listarpornom(Integer nombre);
	public List<CheckIn>listacheckIn(String dato);

}

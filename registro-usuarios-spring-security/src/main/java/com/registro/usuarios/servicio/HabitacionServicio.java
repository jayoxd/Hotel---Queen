package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;


import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.Tipo;


public interface HabitacionServicio  {

	public Habitacion save( Habitacion habitacion);
	public Optional<Habitacion> get(Integer id);
	public void update(Habitacion habitacion);
	public void delete(Integer id);
	public List<Habitacion> listar();
	public List<Habitacion>listarpornom(String nombre);
	public List<Habitacion>listarhabiCheckin(String disponible,String ocupado,String limpieza);

}

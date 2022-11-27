package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;


import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.modelo.Tipo;


public interface ImgHabitacionServicio  {

	public ImgHabitacion save( ImgHabitacion imgHabitacion);
	public Optional<ImgHabitacion> get(Integer id);
	public void update(ImgHabitacion imgHabitacion);
	public void delete(Integer id);
	public List<ImgHabitacion> listar();
	
}

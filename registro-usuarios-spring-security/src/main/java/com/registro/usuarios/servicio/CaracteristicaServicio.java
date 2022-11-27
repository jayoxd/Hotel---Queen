package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;


import com.registro.usuarios.modelo.Caracteristica;


public interface CaracteristicaServicio  {

	public Caracteristica save( Caracteristica caracteristica);
	public Optional<Caracteristica> get(Integer id);
	public void update(Caracteristica caracteristica);
	public void delete(Integer id);
	public List<Caracteristica> listar();
	public List<Caracteristica>listarpornom(String nombre);
}

package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;


import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Limpieza;


public interface LimpiezaServicio  {

	public Limpieza save( Limpieza limpieza);
	public Optional<Limpieza> get(Integer id);
	public void update(Limpieza limpieza);
	public void delete(Integer id);
	public List<Limpieza> listar();
	
}

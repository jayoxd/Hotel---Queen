package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;


import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Tipo;


public interface TipoServicio  {

	public Tipo save( Tipo tipo);
	public Optional<Tipo> get(Integer id);
	public void update(Tipo tipo);
	public void delete(Integer id);
	public List<Tipo> listar();
	public List<Tipo>listarpornom(String nombre);

}

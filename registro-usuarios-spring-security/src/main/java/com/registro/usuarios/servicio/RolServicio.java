package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;


import com.registro.usuarios.modelo.Rol;


public interface RolServicio  {

	public Rol save( Rol rol);
	public Optional<Rol> get( Integer id);
	public void update(Rol rol);
	public void delete(Integer id);
	public List<Rol> listar();
	public List<Rol>listarpornom(String nombre);

	
}

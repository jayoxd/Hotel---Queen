package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;


import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.Tipo;


public interface ClienteServicio  {

	public Cliente save( Cliente cliente);
	public Optional<Cliente> get(Integer id);
	public void update(Cliente cliente);
	public void delete(Integer id);
	public List<Cliente> listar();
	public List<Cliente>listarpornom(String nombre);

	
}

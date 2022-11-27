package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;


import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Hotel;


public interface HotelServicio  {

	public Hotel save( Hotel hotel);
	public Optional<Hotel> get(Integer id);
	public void update(Hotel hotel);
	public void delete(Integer id);
	public List<Hotel> listar();
	
}

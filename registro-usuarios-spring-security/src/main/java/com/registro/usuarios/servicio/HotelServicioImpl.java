package com.registro.usuarios.servicio;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Hotel;
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;
import com.registro.usuarios.repositorio.HotelRepositorio;


@Service
public class HotelServicioImpl implements HotelServicio {

	@Autowired
	private HotelRepositorio hotelRepositorio;

	@Override
	public Hotel save(Hotel hotel) {
		return hotelRepositorio.save(hotel);
	}

	@Override
	public Optional<Hotel> get(Integer id) {
		return hotelRepositorio.findById(id);
	}

	@Override
	public void update(Hotel hotel) {
		hotelRepositorio.save(hotel);
	}

	@Override
	public void delete(Integer id) {
		hotelRepositorio.deleteById(id);
	}

	@Override
	public List<Hotel> listar() {
		return hotelRepositorio.findAll();
	}

	
}

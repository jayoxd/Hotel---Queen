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
import com.registro.usuarios.modelo.Reserva;
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;
import com.registro.usuarios.repositorio.ReservaRepositorio;


@Service
public class ReservaServicioImpl implements ReservaServicio {

	@Autowired
	private ReservaRepositorio reservaRepositorio;

	@Override
	public Reserva save(Reserva reserva) {
		 return reservaRepositorio.save(reserva);
	}

	@Override
	public Optional<Reserva> get(Integer id) {
		return reservaRepositorio.findById(id);
	}

	@Override
	public void update(Reserva reserva) {
		  reservaRepositorio.save(reserva);

	}

	@Override
	public void delete(Integer id) {
		reservaRepositorio.deleteById(id);
	}

	@Override
	public List<Reserva> listar() {
		return reservaRepositorio.findAll();
	}

	@Override
	public List<Reserva> listarpornom(String nombre) {
		if(nombre!=null) {
			 return	reservaRepositorio.buscarcar(nombre);
			}
			return reservaRepositorio.findAll();
	}

	




}

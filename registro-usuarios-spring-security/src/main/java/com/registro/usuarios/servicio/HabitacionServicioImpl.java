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
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;
import com.registro.usuarios.repositorio.HabitacionRepositorio;
import com.registro.usuarios.repositorio.TipoRepositorio;


@Service
public class HabitacionServicioImpl implements HabitacionServicio {

	@Autowired
	private HabitacionRepositorio habitacionRepositorio;
	
	@Override
	public Habitacion save(Habitacion habitacion) {
		return habitacionRepositorio.save(habitacion);
	}

	@Override
	public Optional<Habitacion> get(Integer id) {
		return habitacionRepositorio.findById(id);
	}

	@Override
	public void update(Habitacion habitacion) {
		habitacionRepositorio.save(habitacion);
	}

	@Override
	public void delete(Integer id) {
		habitacionRepositorio.deleteById(id);
	}

	@Override
	public List<Habitacion> listar() {
		return habitacionRepositorio.findAll();
	}

	@Override
	public List<Habitacion> listarpornom(String nombre) {
		if(nombre!=null) {
			 return	habitacionRepositorio.buscarabita(nombre);
			}
			return habitacionRepositorio.findAll();
	}






}

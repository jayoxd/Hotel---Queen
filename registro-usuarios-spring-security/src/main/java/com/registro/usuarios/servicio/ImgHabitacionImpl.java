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
import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;
import com.registro.usuarios.repositorio.ClienteRepositorio;
import com.registro.usuarios.repositorio.HotelRepositorio;
import com.registro.usuarios.repositorio.ImgHabitacionRepositorio;
import com.registro.usuarios.repositorio.TipoRepositorio;


@Service
public class ImgHabitacionImpl implements ImgHabitacionServicio {

	@Autowired
	private ImgHabitacionRepositorio imgHabitacionRepositorio;
	
	
	@Override
	public ImgHabitacion save(ImgHabitacion imgHabitacion) {
		return imgHabitacionRepositorio.save(imgHabitacion);
	}

	@Override
	public Optional<ImgHabitacion> get(Integer id) {
		return imgHabitacionRepositorio.findById(id);
	}

	@Override
	public void update(ImgHabitacion imgHabitacion) {
		imgHabitacionRepositorio.save(imgHabitacion);
	}	

	@Override
	public void delete(Integer id) {
		imgHabitacionRepositorio.deleteById(id);
	}

	@Override
	public List<ImgHabitacion> listar() {
		return imgHabitacionRepositorio.findAll();
	}

	@Override
	public List<ImgHabitacion> listarpornom(String nombre) {
		if(nombre!=null) {
			 return	imgHabitacionRepositorio.buscarcar(nombre);
			}
			return imgHabitacionRepositorio.findAll();
	}



}

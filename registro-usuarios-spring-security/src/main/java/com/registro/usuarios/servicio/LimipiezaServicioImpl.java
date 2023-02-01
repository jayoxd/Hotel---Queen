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
import com.registro.usuarios.modelo.Limpieza;
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;
import com.registro.usuarios.repositorio.LimpiezaRepositorio;


@Service
public class LimipiezaServicioImpl implements LimpiezaServicio {

	@Autowired
	private LimpiezaRepositorio limpiezaRepositorio;

	@Override
	public Limpieza save(Limpieza limpieza) {
		return limpiezaRepositorio.save(limpieza);
	}

	@Override
	public Optional<Limpieza> get(Integer id) {
		return limpiezaRepositorio.findById(id);
	}

	@Override
	public void update(Limpieza limpieza) {
		limpiezaRepositorio.save(limpieza);
	}

	@Override
	public void delete(Integer id) {
		limpiezaRepositorio.deleteById(id);
	}

	@Override
	public List<Limpieza> listar() {
		return limpiezaRepositorio.findAll();
	}

	@Override
	public List<Limpieza> listarpornom(Integer nombre) {
		if(nombre!=null) {
			 return	limpiezaRepositorio.buscarcar(nombre);
			}
			return limpiezaRepositorio.findAll();
	}

	





}

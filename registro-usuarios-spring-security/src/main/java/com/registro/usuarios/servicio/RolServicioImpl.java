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
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;
import com.registro.usuarios.repositorio.RolRepositorio;


@Service
public class RolServicioImpl implements RolServicio {

	@Autowired
	private RolRepositorio repositorio;

	@Override
	public Rol save(Rol rol) {
		return null;
	}

	@Override
	public Optional<Rol> get(Integer id) {
		return null;
	}

	@Override
	public void update(Rol rol) {
		
	}

	@Override
	public void delete(Integer id) {
		
	}

	@Override
	public List<Rol> listar() {
		return repositorio.findAll();
	}





}

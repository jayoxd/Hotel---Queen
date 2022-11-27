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
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;


@Service
public class CaracteristicaServicioImpl implements CaracteristicaServicio {

	@Autowired
	private CaracteristicaRepositorio caracteristicaRepositorio;

	@Override
	public Caracteristica save(Caracteristica caracteristica) {
		return caracteristicaRepositorio.save(caracteristica);
	}

	@Override
	public Optional<Caracteristica> get(Integer id) {
		return caracteristicaRepositorio.findById(id);
	}

	@Override
	public void update(Caracteristica caracteristica) {
		caracteristicaRepositorio.save(caracteristica);
		
	}

	@Override
	public void delete(Integer id) {
		caracteristicaRepositorio.deleteById(id);
		
	}

	@Override
	public List<Caracteristica> listar() {
	
		return caracteristicaRepositorio.findAll();
	}

	@Override
	public List<Caracteristica> listarpornom(String nombre) {
		if(nombre!=null) {
		 return	caracteristicaRepositorio.buscarcar(nombre);
		}
		return caracteristicaRepositorio.findAll();
	}
	




}

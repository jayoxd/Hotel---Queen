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
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;
import com.registro.usuarios.repositorio.TipoRepositorio;


@Service
public class TipoServicioImpl implements TipoServicio {

	@Autowired
	private TipoRepositorio tipoRepositorio;

	@Override
	public Tipo save(Tipo tipo) {
		// TODO Auto-generated method stub
		return tipoRepositorio.save(tipo);
	}

	@Override
	public Optional<Tipo> get(Integer id) {
		return tipoRepositorio.findById(id);
	}

	@Override
	public void update(Tipo tipo) {
		tipoRepositorio.save(tipo);
		
	}

	@Override
	public void delete(Integer id) {
		tipoRepositorio.deleteById(id);
	}

	@Override
	public List<Tipo> listar() {
		return tipoRepositorio.findAll();
	}

	@Override
	public List<Tipo> listarpornom(String nombre) {
		if(nombre!=null) {
			 return	tipoRepositorio.buscarcar(nombre);
			}
			return tipoRepositorio.findAll();
		}

		




}

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
import com.registro.usuarios.modelo.CheckIn;
import com.registro.usuarios.modelo.Reserva;
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;
import com.registro.usuarios.repositorio.CheckInRepositorio;
import com.registro.usuarios.repositorio.ReservaRepositorio;


@Service
public class CheckInServicioImpl implements CheckInServicio {

	@Autowired
	private CheckInRepositorio checkInRepositorio;

	@Override
	public CheckIn save(CheckIn reserva) {
		// TODO Auto-generated method stub
		return checkInRepositorio.save(reserva);

	}

	@Override
	public Optional<CheckIn> get(Integer id) {
		// TODO Auto-generated method stub
		return checkInRepositorio.findById(id);

	}

	@Override
	public void update(CheckIn reserva) {
		checkInRepositorio.save(reserva);
		
	}

	@Override
	public void delete(Integer id) {
		checkInRepositorio.deleteById(id);
		
	}

	@Override
	public List<CheckIn> listar() {
		return checkInRepositorio.findAll();
	
	}

	@Override
	public List<CheckIn> listarpornom(Integer nombre) {
		if(nombre!=null) {
			 return	checkInRepositorio.buscarcar(nombre);
			}
			return checkInRepositorio.findAll();
	}

	@Override
	public List<CheckIn> listacheckIn(String dato) {
		if(dato!=null) {
			 return	checkInRepositorio.buscarcheckin(dato);
			}
			return checkInRepositorio.findAll();
	}



	
	
	




}

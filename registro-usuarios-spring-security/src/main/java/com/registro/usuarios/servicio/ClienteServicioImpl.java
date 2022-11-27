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
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;
import com.registro.usuarios.repositorio.ClienteRepositorio;
import com.registro.usuarios.repositorio.TipoRepositorio;


@Service
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Override
	public Cliente save(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	@Override
	public Optional<Cliente> get(Integer id) {
		return clienteRepositorio.findById(id);
	}

	@Override
	public void update(Cliente cliente) {
		clienteRepositorio.save(cliente);
	}

	@Override
	public void delete(Integer id) {
		clienteRepositorio.deleteById(id);
	}

	@Override
	public List<Cliente> listar() {
		return clienteRepositorio.findAll();
	}

	

		




}

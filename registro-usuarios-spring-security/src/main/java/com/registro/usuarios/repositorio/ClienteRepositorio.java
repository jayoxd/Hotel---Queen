package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Cliente;



@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Integer>{

	@Query("SELECT p FROM Cliente p WHERE p.nombre LIKE %?1%"
			+ " OR p.apellido LIKE %?1%"
			+ " OR p.telefono LIKE %?1%"
			+ " OR p.email LIKE %?1%"
			+ " OR p.fechaNacimiento LIKE %?1%"
			)
	public List<Cliente> buscarClie(String keyword);
	
}

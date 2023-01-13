package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Rol;
@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {

	
	@Query("SELECT p FROM Rol p WHERE p.nombre LIKE %?1%"
	           )
		public List<Rol> buscarcar(String nombre);
	
}

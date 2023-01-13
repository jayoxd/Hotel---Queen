package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{

	@Query("SELECT p FROM Usuario p WHERE p.nombre LIKE %?1%"
			+ " OR p.apellido LIKE %?1%"
			+ " OR p.telefono LIKE %?1%"
			+ " OR p.email LIKE %?1%"
		
			)
		public List<Usuario> buscarcar(String nombre);
	
	
	
	public Usuario findByEmail(String email);
	
}

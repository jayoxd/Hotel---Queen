package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;

@Repository
public interface TipoRepositorio extends JpaRepository<Tipo, Integer>{

	@Query("SELECT p FROM Tipo p WHERE p.nombre LIKE %?1%"
	           )
		public List<Tipo> buscarcar(String nombre);
	
}

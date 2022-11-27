package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;

@Repository
public interface TipoRepositorio extends JpaRepository<Tipo, Integer>{

	//public Tipo findByNombre(String nombre);
	
}

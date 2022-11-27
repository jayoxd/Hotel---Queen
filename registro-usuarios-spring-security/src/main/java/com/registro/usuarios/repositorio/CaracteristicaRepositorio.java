package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Caracteristica;

@Repository
public interface CaracteristicaRepositorio extends JpaRepository<Caracteristica, Integer>{

	@Query("SELECT p FROM Caracteristica p WHERE p.nombre LIKE %?1%"
           )
	public List<Caracteristica> buscarcar(String nombre);
	
}

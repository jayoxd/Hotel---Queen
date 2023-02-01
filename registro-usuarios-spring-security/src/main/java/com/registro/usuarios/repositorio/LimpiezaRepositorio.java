package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.CheckIn;
import com.registro.usuarios.modelo.Limpieza;

@Repository
public interface LimpiezaRepositorio extends JpaRepository<Limpieza, Integer>{


	@Query("SELECT p FROM Limpieza p WHERE p.id_limpieza =1"

           )
	public List<Limpieza> buscarcar(Integer nombre);

	
}

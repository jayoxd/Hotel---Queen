package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.Habitacion;

@Repository
public interface HabitacionRepositorio extends JpaRepository<Habitacion, Integer>{

	@Query("SELECT p FROM Habitacion p WHERE p.nombre LIKE %?1%"
			+ " OR p.invitados LIKE %?1%"
			+ " OR p.precio LIKE %?1%"
			+ " OR p.descripcion LIKE %?1%"
			+ " OR p.estado LIKE %?1%"
			+ " OR p.idTipo.nombre LIKE %?1%"
			)
	public List<Habitacion> buscarabita(String keyword);

	
	@Query("SELECT p FROM Habitacion p WHERE p.estado = ?1 OR p.estado =?2   OR p.estado =?3")
	public List<Habitacion> buscarahabiCheckin(String disponible,String ocupado,String limpieza);
	
	
	
}

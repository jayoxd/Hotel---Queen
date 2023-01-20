package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Reserva;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Integer>{

	@Query("SELECT p FROM Reserva p WHERE p.fechaReservacion LIKE %?1%"
           )
	public List<Reserva> buscarcar(String nombre);
	
}

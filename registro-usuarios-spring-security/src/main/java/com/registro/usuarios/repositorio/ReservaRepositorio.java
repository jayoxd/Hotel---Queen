package com.registro.usuarios.repositorio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Reserva;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Integer> {

	@Query("SELECT p FROM Reserva p WHERE p.idHabitacion.id =?1"

	)
	public List<Reserva> buscarcar(Integer nombre);

	@Query("SELECT p FROM Reserva p WHERE p.idHabitacion.nombre  LIKE %?1%" + " OR p.estado LIKE %?1%"
			+ " OR p.clientes.dni LIKE %?1%" + " OR p.fechaReservacion LIKE %?1%")
	public List<Reserva> buscarreserva(String nombre);

	

    List<Reserva> findByIdHabitacion_IdAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqual( Integer idHabitacion,LocalDate fechaInicio, LocalDate fechaFin);
}

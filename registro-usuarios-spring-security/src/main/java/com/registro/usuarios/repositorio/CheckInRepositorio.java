package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.CheckIn;
import com.registro.usuarios.modelo.Reserva;

@Repository
public interface CheckInRepositorio extends JpaRepository<CheckIn, Integer>{

	

	
	@Query("SELECT p FROM CheckIn p WHERE p.idHabitacion.id =?1"

           )
	public List<CheckIn> buscarcar(Integer nombre);
	
	
	@Query("SELECT p FROM CheckIn p WHERE p.idHabitacion.nombre  LIKE %?1%"
			+ " OR p.clientes.dni LIKE %?1%"
			+ " OR p.fechaInicio LIKE %?1%"

	           )
		public List<CheckIn> buscarcheckin(String nombre);
	
	

}

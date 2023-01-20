package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.registro.usuarios.modelo.ImgHabitacion;

@Repository
public interface ImgHabitacionRepositorio  extends JpaRepository<ImgHabitacion, Integer>{
	@Query("SELECT p FROM ImgHabitacion p WHERE p.nombre LIKE %?1%"
	           )
		public List<ImgHabitacion> buscarcar(String nombre);
}

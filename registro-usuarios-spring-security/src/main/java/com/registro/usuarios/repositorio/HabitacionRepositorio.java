package com.registro.usuarios.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Habitacion;

@Repository
public interface HabitacionRepositorio extends JpaRepository<Habitacion, Integer>{

	

	
}

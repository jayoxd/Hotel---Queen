package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.registro.usuarios.modelo.ImgHabitacion;

@Repository
public interface ImgHabitacionRepositorio  extends JpaRepository<ImgHabitacion, Integer>{

}

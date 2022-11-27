package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Limpieza;

@Repository
public interface LimpiezaRepositorio extends JpaRepository<Limpieza, Integer>{


}

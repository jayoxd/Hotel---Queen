package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Hotel;

@Repository
public interface HotelRepositorio  extends JpaRepository<Hotel, Integer>{


}

package com.registro.usuarios;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.HabitacionServicio;
import com.registro.usuarios.servicio.UsuarioServicio;
@SpringBootApplication
public class RegistroUsuariosSpringSecurityApplication {

	
	
	public static void main(String[] args) {
		SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);
	
	}

	@Bean
	public SpringDataDialect springDataDialect() {
		return new SpringDataDialect();
	}
}

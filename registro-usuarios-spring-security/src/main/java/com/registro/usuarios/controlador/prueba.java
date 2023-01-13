package com.registro.usuarios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.servicio.AlmacenServicioImpl;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.HabitacionServicio;
import com.registro.usuarios.servicio.ImgHabitacionServicio;
import com.registro.usuarios.servicio.TipoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/prueba")
public class prueba {

	@Autowired
	private ClienteServicio clienteServicio;
	@Autowired
	private HabitacionServicio habitacionServicio;
	

	@Autowired 
	private CaracteristicaServicio caracteristicaServicio;
	@Autowired
	private ImgHabitacionServicio imgHabitacionServicio;
	@Autowired 
	private TipoServicio tipoServicio;

	@Autowired
	private AlmacenServicioImpl servicio;
	@Autowired
	private UsuarioServicio usuarioServicio;

	@GetMapping("")
	public String verPaginaDeInicio() {
		return "listax/prueba2";

	}
	
	
	@GetMapping ("/x")
	public String edxt() {
		
		
		return "/Habitaciones/habitacionesedit";
		
				
	}
}
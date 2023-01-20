package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.HabitacionRepositorio;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.HabitacionServicio;
import com.registro.usuarios.servicio.ImgHabitacionServicio;
import com.registro.usuarios.servicio.TipoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

import com.registro.usuarios.servicio.AlmacenServicioImpl;

import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpSession;
@Slf4j 
@Controller 
@RequestMapping("reservas")
public class ReservaController {

	@Autowired
	private HabitacionServicio habitacionServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired 
	private CaracteristicaServicio caracteristicaServicio;
	@Autowired
	private ImgHabitacionServicio imgHabitacionServicio;
	@Autowired 
	private TipoServicio tipoServicio;

	@Autowired
	private AlmacenServicioImpl servicio;
	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo,@Param("palabra")String palabra) {
		List<Habitacion>habitaciones=habitacionServicio.listarpornom(palabra);
	
		
		
		return "/Reservas/reservas";
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}

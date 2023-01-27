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
import com.registro.usuarios.modelo.Reserva;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.HabitacionRepositorio;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.HabitacionServicio;
import com.registro.usuarios.servicio.ImgHabitacionServicio;
import com.registro.usuarios.servicio.ReservaServicio;
import com.registro.usuarios.servicio.TipoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;
import com.registro.usuarios.servicio.AlmacenServicioImpl;

import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
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
	private ReservaServicio reservaServicio;
	
	@Autowired 
	private CaracteristicaServicio caracteristicaServicio;
	@Autowired
	private ImgHabitacionServicio imgHabitacionServicio;
	@Autowired 
	private TipoServicio tipoServicio;

	@Autowired
	private AlmacenServicioImpl servicio;
	
	@Autowired
	private ClienteServicio clienteServicio;
	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo,@Param("palabra")String palabra) {
		;
		List<Habitacion>habitaciones=habitacionServicio.listarpornom(palabra);
		
	
		List<Habitacion>habitacidispo=habitacionServicio.listarpornom("disponible");
		Integer habidispo=habitacidispo.size();

		List<Habitacion>habitacionesx=habitacionServicio.listarpornom("Ocupado");
		Integer habiocupado=habitacionesx.size();
		
		List<Habitacion>habitacionesxd=habitacionServicio.listar();
		Integer habi=habitacionesxd.size();
		
		modelo.addAttribute("totalhabi",habi );
		modelo.addAttribute("habidispo",habidispo );
		modelo.addAttribute("habiocupado",habiocupado );
		modelo.addAttribute("palabra", palabra);
		modelo.addAttribute("usuarios", usuarioServicio.listarUsuarios());
	//	modelo.addAttribute("roles",rolservi.listar());
		modelo.addAttribute("caracteristicas", caracteristicaServicio.listar());
		modelo.addAttribute("tipos",tipoServicio.listar());
		modelo.addAttribute("imagenes",imgHabitacionServicio.listar());
		modelo.addAttribute("habitaciones",habitaciones);
		modelo.addAttribute("habitacion",new Habitacion());
	
		
		
		return "/Reservas/reservas";
	}
	

	
	
	@GetMapping( value =  "/editver/{id}")
	public ModelAndView editx(@PathVariable Integer id,Model modelo,HttpSession session  ) {
		Habitacion habitacion= habitacionServicio.get(id).get();
		List<Caracteristica> caracteristicas = caracteristicaServicio.listar();
		List<Tipo>idtipo=tipoServicio.listar();
		List<ImgHabitacion>imagenes=imgHabitacionServicio.listar();
		
		
		List<Cliente>clientes=clienteServicio.listar();		
		Usuario usuario =usuarioServicio.buscarid( Integer.parseInt(session.getAttribute("idusuario").toString())  ).get();
		
		modelo.addAttribute("clientes",clientes );
		modelo.addAttribute("usuario", usuario);
		
		modelo.addAttribute("habitacion",habitacion);
		modelo.addAttribute("caracteristicas",caracteristicas);
		modelo.addAttribute("tipos",idtipo);
		modelo.addAttribute("imagenes",imagenes);
		

		return new
				
				ModelAndView("/Reservas/recepcion")
				.addObject("reserva",new Reserva());
				
	}
	
	
	
	
	@PostMapping( value =  "/editver/{id}")
	public ModelAndView editX(Model modelo,@PathVariable Integer id,Habitacion habitacion,Reserva reserva) {
		Optional<Habitacion> habi=habitacionServicio.get(id);
		habi.get().setEstado("Reservado");

		habitacionServicio.save(habi.get());
		  Date date = new Date();
		  reserva.setFechaReservacion(date);
		
		reservaServicio.save(reserva);

		
				return new ModelAndView("redirect:/reservas");
	}
	
	
	
	
	
	
}

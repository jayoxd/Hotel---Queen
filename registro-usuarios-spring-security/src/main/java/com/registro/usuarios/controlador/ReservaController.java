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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.CheckIn;
import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.modelo.Limpieza;
import com.registro.usuarios.modelo.Reserva;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.HabitacionRepositorio;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.CheckInServicio;
import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.HabitacionServicio;
import com.registro.usuarios.servicio.ImgHabitacionServicio;
import com.registro.usuarios.servicio.LimpiezaServicio;
import com.registro.usuarios.servicio.ReservaServicio;
import com.registro.usuarios.servicio.RolServicio;
import com.registro.usuarios.servicio.TipoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;
import com.registro.usuarios.servicio.AlmacenServicioImpl;

import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
	private RolServicio rolServicio;

	@Autowired
	private LimpiezaServicio limpiezaServicio;
	
	@Autowired
	private CheckInServicio checkInServicio;

	
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
	public String verPaginaDeInicio(Model modelo, @Param("palabra") String palabra) {
		;
		List<Habitacion> habitaciones = habitacionServicio.listarpornom(palabra);

		List<Habitacion> habitacidispo = habitacionServicio.listarpornom("");
		Integer habidispo = habitacidispo.size();

		List<Habitacion> habitacionesx = habitacionServicio.listarpornom("");
		Integer habiocupado = habitacionesx.size();

		List<Habitacion> habitacionesxd = habitacionServicio.listar();
		Integer habi = habitacionesxd.size();

		modelo.addAttribute("totalhabi", habi);
		modelo.addAttribute("habidispo", habidispo);
		modelo.addAttribute("habiocupado", habiocupado);
		modelo.addAttribute("palabra", palabra);
		modelo.addAttribute("usuarios", usuarioServicio.listarUsuarios());
		// modelo.addAttribute("roles",rolservi.listar());
		modelo.addAttribute("caracteristicas", caracteristicaServicio.listar());
		modelo.addAttribute("tipos", tipoServicio.listar());
		modelo.addAttribute("imagenes", imgHabitacionServicio.listar());
		modelo.addAttribute("habitaciones", habitaciones);
		modelo.addAttribute("habitacion", new Habitacion());

		return "/Reservas/reservas";
	}
	  public static<T> List<T> reverseList(List<T> list)
	    {
	        List<T> reverse = new ArrayList<>(list);
	        Collections.reverse(reverse);
	        return reverse;
	    }
	@GetMapping(value = "/editver/{id}")
	public ModelAndView editx(@PathVariable Integer id, Model modelo, HttpSession session
			,@RequestParam(value = "dni", defaultValue = "1") int dni,
			 @RequestParam(value = "dispo", defaultValue = "1") String dispo

			) {
		Habitacion habitacion = habitacionServicio.get(id).get();
		List<Caracteristica> caracteristicas = caracteristicaServicio.listar();
		List<Tipo> idtipo = tipoServicio.listar();
		List<ImgHabitacion> imagenes = imgHabitacionServicio.listar();

		List<Cliente> clientes = clienteServicio.listar();
		Usuario usuario = usuarioServicio.buscarid(Integer.parseInt(session.getAttribute("idusuario").toString()))
				.get();
		
		String idhab=id.toString();

		 List<Reserva> list = reservaServicio.listarpornom(id);

	        List<Reserva> reverse = reverseList(list);

	        Reserva reservado=reverse.get(0);
		 
		 if(habitacion.getEstado().equalsIgnoreCase("Reservado") && dni==1)
		 {

			 modelo.addAttribute("clientes", clientes);
				modelo.addAttribute("usuario", usuario);
				modelo.addAttribute("reservadoF", reservado);

				modelo.addAttribute("habitacion", habitacion);
				modelo.addAttribute("caracteristicas", caracteristicas);
				modelo.addAttribute("tipos", idtipo);
				modelo.addAttribute("imagenes", imagenes);

				return new

				ModelAndView("/Reservas/recepcion2").addObject("cliente", new Cliente())

						.addObject("reserva", new Reserva());
		 }

		 
		 if(habitacion.getEstado().equalsIgnoreCase("Reservado") && dni!=1)
		 {

			 modelo.addAttribute("clientes", clientes);
				modelo.addAttribute("usuario", usuario);
				modelo.addAttribute("reservado", reservado);

				modelo.addAttribute("habitacion", habitacion);
				modelo.addAttribute("caracteristicas", caracteristicas);
				modelo.addAttribute("tipos", idtipo);
				modelo.addAttribute("imagenes", imagenes);

				return new

				ModelAndView("/Reservas/recepcion").addObject("cliente", new Cliente())
						.addObject("checkin", new CheckIn())
						.addObject("reserva", new Reserva());
		 }
		 
		 
		 
		 if(habitacion.getEstado().equalsIgnoreCase("Limpieza"))
		 {

			 modelo.addAttribute("clientes", clientes);
				modelo.addAttribute("usuario", usuario);
				modelo.addAttribute("reservado", reservado);

				modelo.addAttribute("habitacion", habitacion);
				modelo.addAttribute("caracteristicas", caracteristicas);
				modelo.addAttribute("tipos", idtipo);
				modelo.addAttribute("imagenes", imagenes);

				return new

				ModelAndView("/Reservas/recepcion4").addObject("cliente", new Cliente())
				.addObject("limpieza", new Limpieza()).
						addObject("reserva", new Reserva());
		 }
		 if(habitacion.getEstado().equalsIgnoreCase("Ocupado"))
		 {

			 modelo.addAttribute("clientes", clientes);
				modelo.addAttribute("usuario", usuario);
				modelo.addAttribute("reservado", reservado);

				modelo.addAttribute("habitacion", habitacion);
				modelo.addAttribute("caracteristicas", caracteristicas);
				modelo.addAttribute("tipos", idtipo);
				modelo.addAttribute("imagenes", imagenes);

				return new

				ModelAndView("/Reservas/recepcion3").addObject("cliente", new Cliente())
				.addObject("checkin", new CheckIn())
						.addObject("reserva", new Reserva());
		 }
		 
		
		 
		modelo.addAttribute("clientes", clientes);
		modelo.addAttribute("usuario", usuario);

		modelo.addAttribute("habitacion", habitacion);
		modelo.addAttribute("caracteristicas", caracteristicas);
		modelo.addAttribute("tipos", idtipo);
		modelo.addAttribute("imagenes", imagenes);

		return new

		ModelAndView("/Reservas/recepcion").addObject("cliente", new Cliente())

				.addObject("reserva", new Reserva());

	}

	@PostMapping(value = "/editver/{id}")
	public ModelAndView editX(Model modelo, @PathVariable Integer id, Cliente cliente, Habitacion habitacion, @RequestParam(value = "dni", defaultValue = "1") int dni
			, @RequestParam(value = "Ocupado", defaultValue = "1") String Ocupado,CheckIn checkIn,
			 @RequestParam(value = "finalizar", defaultValue = "1") String finalizar,
			 @RequestParam(value = "limpiezater", defaultValue = "1") String limpiezater,
		
			 Limpieza limpieza,
			Reserva reserva, HttpSession session) {
		Optional<Habitacion> habi = habitacionServicio.get(id);
		
		 Reserva reservadox =(Reserva) reservaServicio.listarpornom(id).get(0);
		habi.get().setEstado("Reservado");
		LocalDate datetime = LocalDate.now();

		Usuario usuario = usuarioServicio.buscarid(Integer.parseInt(session.getAttribute("idusuario").toString()))
				.get();

		 if(Ocupado.equals("Ocupado")) {	
				habi.get().setEstado("Ocupado");
				habitacionServicio.save(habi.get());
				return editx(id, modelo, session,1,null);

				 				
		 }
		
		 if(finalizar.equals("finalizar")) {	
				habi.get().setEstado("Limpieza");
				
				checkIn.setIdHabitacion(habitacion);
				checkIn.setIdUsuario(usuario);
				checkIn.setAdelanto(reservadox.getAdelanto());
				checkIn.setAdultos(reservadox.getAdultos());
				checkIn.setNiños(reservadox.getNiños());
				checkIn.setFechaInicio(reservadox.getFechaInicio());
				checkIn.setFechaFin(reservadox.getFechaFin());
				checkIn.setFechaReservacion(reservadox.getFechaReservacion());
				checkIn.setClientes(reservadox.getClientes());
				checkIn.setReserva(reservadox);
				checkInServicio.save(checkIn);
				habitacionServicio.save(habi.get());
				return new ModelAndView("redirect:/reservas");


				
		 }
		 
		 if(limpiezater.equals("limpiezater")) {	
				habi.get().setEstado("Disponible");
				
				habitacionServicio.save(habi.get());
				limpieza.setIdUsuario(usuario);
				limpiezaServicio.save(limpieza);
				return new ModelAndView("redirect:/reservas");


				
		 }
		 
		 

		if (dni!=1) {
			
			
			Habitacion habitacionx = habitacionServicio.get(id).get();
			List<Caracteristica> caracteristicas = caracteristicaServicio.listar();
			List<Tipo> idtipo = tipoServicio.listar();
			List<ImgHabitacion> imagenes = imgHabitacionServicio.listar();

			List<Cliente> clientes = clienteServicio.listar();
			Usuario usuariox = usuarioServicio.buscarid(Integer.parseInt(session.getAttribute("idusuario").toString()))
					.get();
			Rol rol = rolServicio.get(3).get();
			cliente.setIdRol(rol);
			clienteServicio.save(cliente);
			
			modelo.addAttribute("usuario", usuariox);

			modelo.addAttribute("habitacion", habitacionx);
			modelo.addAttribute("caracteristicas", caracteristicas);
			modelo.addAttribute("tipos", idtipo);
			modelo.addAttribute("imagenes", imagenes);
			
			return editx(id, modelo, session,dni,null);

		}
		
		
	
		habitacionServicio.save(habi.get());
		reserva.setFechaReservacion(datetime);
		reserva.setIdHabitacion(habitacion);
		reserva.setIdUsuario(usuario);
		reservaServicio.save(reserva);

		return new ModelAndView("redirect:/reservas");
		
	}

}

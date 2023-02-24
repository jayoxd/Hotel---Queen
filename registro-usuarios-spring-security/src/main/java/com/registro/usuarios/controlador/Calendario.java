package com.registro.usuarios.controlador;

import javax.persistence.NonUniqueResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.excepciones.ReservaExistenteException;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.Reserva;
import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.HabitacionServicio;
import com.registro.usuarios.servicio.ReservaServicio;

import groovy.util.logging.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;

@Slf4j
@Controller
@RequestMapping("/calendario")
public class Calendario {

	@Autowired
	private HabitacionServicio habitacionServicio;
	
	@Autowired
	private ReservaServicio roomRepository;

	  @GetMapping("")
	    public String mostrarFormulario(Model model) {
			List<Habitacion>habitaciones=habitacionServicio.listar();
		  model.addAttribute("reserva", new Reserva());
		  model.addAttribute("habitaciones", habitaciones);

	        return "calendario";
	    }

	    @PostMapping("")
	    public String procesarFormulario( Reserva reserva, Model model) {
	        if (!roomRepository.isRoomAvailableXD(reserva.getFechaInicio(), reserva.getFechaFin(), reserva.getIdHabitacion().getId())) {
	            throw new ReservaExistenteException ("Ya existe una reserva para el rango de fechas dado");
	        }
	        roomRepository.save(reserva);

	        return "calendario";

	    }

	 
	    
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    @ExceptionHandler(ReservaExistenteException.class)
	    @ResponseBody
	    public ErrorResponse handleReservaExistenteException(ReservaExistenteException ex) {
	        return new ErrorResponse("Ya existe una reserva para el rango de fechas dado");
	    }
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
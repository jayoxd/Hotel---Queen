package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;
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

import javax.servlet.http.HttpSession;
@Slf4j 
@Controller
@RequestMapping("/listax")
public class HabitacionController {

	@Autowired
	private HabitacionServicio habitacionServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	@Autowired 
	private CaracteristicaServicio caracteristicaServicio;
	@Autowired
	private ImgHabitacionServicio imgHabitacionServicio;
	

	@Autowired
	private AlmacenServicioImpl servicio;
	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("usuarios", usuarioServicio.listarUsuarios());
	//	modelo.addAttribute("roles",rolservi.listar());
		modelo.addAttribute("caracteristicas", caracteristicaServicio.listar());
		modelo.addAttribute("tipos",tipoServicio.listar());
		modelo.addAttribute("imagenes",imgHabitacionServicio.listar());
		modelo.addAttribute("habitaciones",habitacionServicio.listar());
		return "listax/listahabi";
	}
	
	
	
	
	
	@Autowired 
	private TipoServicio tipoServicio;
	
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioDeNuevaPelicula(Model modelo) {
//		modelo.addAttribute("caracteristicas", caracteristicaServicio.listar());
		List<Caracteristica> caracteristicas = caracteristicaServicio.listar();
		List<Tipo>idtipo=tipoServicio.listar();
		List<ImgHabitacion>imagenes=imgHabitacionServicio.listar();
		return new ModelAndView("registrohabitacion")
				.addObject("habitacion", new Habitacion())
				.addObject("caracteristica",caracteristicas)
				.addObject("imagenes",imagenes)
				.addObject("idTipo",idtipo)
				;
	}
	
	
	
	
	
	@PostMapping("/nuevo")
	public ModelAndView registrarCuentaDeUsuario( Habitacion habitacion, HttpSession session)throws IOException {
		//para saber el id de quien ingreso a la pagina 
		Usuario u= usuarioServicio.buscarid(Long.parseLong(session.getAttribute("idusuario").toString() )).get();
		//habitacion.setIdUsuario(u);

		log.info("ejecuntado el controlador rest");
		log.info("Id de la orden {}",u.getId().toString());
		
	


    	//String rutaPortada = servicio.almacenarArchivo(habitacion.getImghabitacion());
		//habitacion.setRutaimagenhabi(rutaPortada);
        
		

		habitacionServicio.save(habitacion);
		return new ModelAndView("redirect:/listax");
	}
	
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id ) {
		Habitacion habitacion= habitacionServicio.get(id).get();
		List<Caracteristica> caracteristicas = caracteristicaServicio.listar();
		List<Tipo>idtipo=tipoServicio.listar();
		List<ImgHabitacion>imagenes=imgHabitacionServicio.listar();
		return new ModelAndView("habitacion-edit")
				.addObject("habitacion",habitacion)
				.addObject("caracteristica",caracteristicas)
				.addObject("idTipo",idtipo)
				.addObject("imagenes",imagenes)
				;
	}
	
	
	@PostMapping("/update")
	public String update(Habitacion habitacion ) {
		habitacionServicio.update(habitacion);		
		return "redirect:/listax";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		habitacionServicio.delete(id);
		return "redirect:/listax";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

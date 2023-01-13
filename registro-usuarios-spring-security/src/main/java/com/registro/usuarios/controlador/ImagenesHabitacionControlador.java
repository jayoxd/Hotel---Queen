package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.servicio.AlmacenServicioImpl;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.ImgHabitacionServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
@RequestMapping("/imgHabitacion")
public class ImagenesHabitacionControlador {

	
	@Autowired 
	private ImgHabitacionServicio imgHabitacionServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private AlmacenServicioImpl servicio;
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("imageneshabitaciones", imgHabitacionServicio.listar());
		return "listax/listaxhabita";
	}
		
	
	

	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioDeNuevaPelicula(Model modelo) {
		return new ModelAndView("registroimg")
				.addObject("imageneshabi", new ImgHabitacion())
				;
	}
	
	
	@PostMapping("/nuevo")
	public ModelAndView registrarCuentaDeUsuario( ImgHabitacion imgHabitacion )  {
		
		String rutaPortada = servicio.almacenarArchivo(imgHabitacion.getImghabitacion());
		imgHabitacion.setRutaimagenhabi(rutaPortada);
		imgHabitacionServicio.save(imgHabitacion);
		return new ModelAndView("redirect:/listax/");
	}
	
	
	
	
	
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id ) {
		ImgHabitacion imgHabitacion= imgHabitacionServicio.get(id).get();
		return new ModelAndView("imgHabitacion/editar-imgHabitacion")
				.addObject("habitacion",imgHabitacion);
	}
	
	
	@PostMapping("/update")
	public String update(ImgHabitacion imgHabitacion ) {
		imgHabitacionServicio.update(imgHabitacion);		
		return "redirect:/imgHabitacion";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		imgHabitacionServicio.delete(id);
		return "redirect:/imgHabitacion";
	}
	

	
}

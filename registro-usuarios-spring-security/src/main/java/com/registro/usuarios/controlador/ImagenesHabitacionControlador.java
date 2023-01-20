package com.registro.usuarios.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.servicio.AlmacenServicioImpl;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.HabitacionServicio;
import com.registro.usuarios.servicio.ImgHabitacionServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
@RequestMapping("/imgHabitacion")
public class ImagenesHabitacionControlador {

	@Autowired
	private ClienteServicio clienteServicio;
	@Autowired
	private HabitacionServicio habitacionServicio;
	@Autowired 
	private ImgHabitacionServicio imgHabitacionServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	private AlmacenServicioImpl servicio;
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo,@Param("palabra")String palabra) {
		
		List<ImgHabitacion>imagenes=imgHabitacionServicio.listarpornom(palabra);
		
		List<ImgHabitacion>imagenestotal=imgHabitacionServicio.listarpornom(palabra);
		Integer imagentotal=imagenestotal.size();
		
		List<Cliente>clientes=clienteServicio.listar();
		Integer clientto=clientes.size();
		
		List<Habitacion>habitacidispo=habitacionServicio.listarpornom("disponible");
		Integer habidispo=habitacidispo.size();

		List<Habitacion>habitaciones=habitacionServicio.listar();
		Integer habi=habitaciones.size();
		
		
		ImgHabitacion imagen=new ImgHabitacion();
		modelo.addAttribute("total",clientto );
		modelo.addAttribute("totalhabi",habi );
		modelo.addAttribute("habidispo",habidispo );
		modelo.addAttribute("imagentotal",imagentotal );

		modelo.addAttribute("imageneshabitaciones", imagenes);
		modelo.addAttribute("imagen",imagen);
		return "imagenes/imagen";
	}
		
	@PostMapping("")
	public ModelAndView registrarCuentaDeUsuariox( ImgHabitacion imgHabitacion )  {
		if(imgHabitacion.getId()!=null)
		{
			Optional<ImgHabitacion> peliculaDB = imgHabitacionServicio.get(imgHabitacion.getId());
			peliculaDB.get().setNombre(imgHabitacion.getNombre());	
			if(!imgHabitacion.getImghabitacion().isEmpty()) {
				servicio.eliminarArchivo(peliculaDB.get().getRutaimagenhabi());
				String rutaPortada = servicio.almacenarArchivo(imgHabitacion.getImghabitacion());
				peliculaDB.get().setRutaimagenhabi(rutaPortada);
			}
			
			imgHabitacionServicio.save(peliculaDB.get());
			return new ModelAndView("redirect:/imgHabitacion");
			
		}
		String rutaPortada = servicio.almacenarArchivo(imgHabitacion.getImghabitacion());
		imgHabitacion.setRutaimagenhabi(rutaPortada);
	
		imgHabitacionServicio.save(imgHabitacion);
		return new ModelAndView("redirect:/imgHabitacion");
	}
	
	
	@GetMapping("/findOne")
    @ResponseBody
	public ImgHabitacion editx( Integer id ) {
		//Caracteristica caracteristica= new Caracteristica();
		//Optional<Caracteristica> optionalCaracteristica=caracteristicaServicio.get(id);
       
        
		return  imgHabitacionServicio.get(id).get();
				
	
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

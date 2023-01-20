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
import com.registro.usuarios.servicio.ClienteServicio;
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
@RequestMapping("habitaciones")
public class HabitacionController {

	@Autowired
	private HabitacionServicio habitacionServicio;
	
	
	@Autowired
	private ClienteServicio clienteServicio;

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
	
		List<Cliente>clientes=clienteServicio.listar();
		Integer clientto=clientes.size();
		
		List<Habitacion>habitacidispo=habitacionServicio.listarpornom("disponible");
		Integer habidispo=habitacidispo.size();

		List<Habitacion>habitacionesx=habitacionServicio.listarpornom("Ocupado");
		Integer habiocupado=habitacionesx.size();
		
		List<Habitacion>habitacionesxd=habitacionServicio.listar();
		Integer habi=habitacionesxd.size();
		
		modelo.addAttribute("totalhabi",habi );
		modelo.addAttribute("habidispo",habidispo );
		modelo.addAttribute("habiocupado",habiocupado );
		modelo.addAttribute("clientestotla",clientto );

		modelo.addAttribute("clientes",clientes );

		
		
		
		modelo.addAttribute("palabra", palabra);
		modelo.addAttribute("usuarios", usuarioServicio.listarUsuarios());
	//	modelo.addAttribute("roles",rolservi.listar());
		modelo.addAttribute("caracteristicas", caracteristicaServicio.listar());
		modelo.addAttribute("tipos",tipoServicio.listar());
		modelo.addAttribute("imagenes",imgHabitacionServicio.listar());
		modelo.addAttribute("habitaciones",habitaciones);
		modelo.addAttribute("habitacion",new Habitacion());
		return "/Habitaciones/habitaciones";
	}
	

	@GetMapping( value =  "/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id,Model modelo ) {
		Habitacion habitacion= habitacionServicio.get(id).get();
		List<Caracteristica> caracteristicas = caracteristicaServicio.listar();
		List<Tipo>idtipo=tipoServicio.listar();
		List<ImgHabitacion>imagenes=imgHabitacionServicio.listar();
		modelo.addAttribute("habitacion",habitacion);
		modelo.addAttribute("caracteristicas",caracteristicas);
		modelo.addAttribute("tipos",idtipo);
		modelo.addAttribute("imagenes",imagenes);
		return new
		ModelAndView("/Habitaciones/habitacionesedit");
				
	}
	
	@PostMapping( value =  "/edit/{id}")
	public ModelAndView editX(@PathVariable Integer id,Habitacion habitacion ) {
		Optional<Habitacion> habi=habitacionServicio.get(id);
		habi.get().setNombre(habitacion.getNombre());
		habi.get().setInvitados(habitacion.getInvitados());
		habi.get().setPrecio(habitacion.getPrecio());
		habi.get().setDescripcion(habitacion.getDescripcion());
		habi.get().setEstado(habitacion.getEstado());
		habi.get().setNombre(habitacion.getNombre());
		habi.get().setIdTipo(habitacion.getIdTipo());
		habi.get().setImagenes(habitacion.getImagenes());
		habi.get().setCaracteristica(habitacion.getCaracteristica());
		habitacionServicio.save(habi.get());
		
				return new ModelAndView("redirect:/habitaciones");
				
	}
	
	
	/*@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id ) {
		Habitacion habitacion= habitacionServicio.get(id).get();
		List<Caracteristica> caracteristicas = caracteristicaServicio.listar();
		List<Tipo>idtipo=tipoServicio.listar();
		List<ImgHabitacion>imagenes=imgHabitacionServicio.listar();
		return new ModelAndView("Habitaciones/habitacionesedit")
				.addObject("habitacion",habitacion)
				.addObject("caracteristica",caracteristicas)
				.addObject("idTipo",idtipo)
				.addObject("imagenes",imagenes)
				;
	}*/
	
	
	
	

	
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
		Usuario u= usuarioServicio.buscarid(Integer.parseInt(session.getAttribute("idusuario").toString() )).get();
		//habitacion.setIdUsuario(u);

		log.info("ejecuntado el controlador rest");
		log.info("Id de la orden {}",u.getId().toString());
		
	


    	//String rutaPortada = servicio.almacenarArchivo(habitacion.getImghabitacion());
		//habitacion.setRutaimagenhabi(rutaPortada);
        
		

		habitacionServicio.save(habitacion);
		return new ModelAndView("redirect:/listax");
	}

	
	@PostMapping("")
	public ModelAndView registrarCuentaDeUsuario( Habitacion habitacion ){
		if(habitacion.getId()!=null)
		{
			Optional<Habitacion> peliculaDB = habitacionServicio.get(habitacion.getId());
			peliculaDB.get().setNombre(habitacion.getNombre());
			peliculaDB.get().setInvitados(habitacion.getInvitados());
			peliculaDB.get().setPrecio(habitacion.getPrecio());
			peliculaDB.get().setDescripcion(habitacion.getDescripcion());
			peliculaDB.get().setEstado(habitacion.getEstado());
			peliculaDB.get().setCaracteristica(habitacion.getCaracteristica());
			peliculaDB.get().setIdTipo(habitacion.getIdTipo());
	
			habitacionServicio.save(peliculaDB.get());
			return new ModelAndView("redirect:/habitaciones");
			
		}
		
		habitacionServicio.save(habitacion);
		return new ModelAndView("redirect:/habitaciones");
	}
	
	
	
	

	
	@PostMapping("/habi/{id}/editar")
	public ModelAndView actualizarPelicula(@PathVariable Integer id,@Validated Habitacion habitacion,BindingResult bindingResult) {
		
		
		habitacionServicio.save(habitacion);
		return new ModelAndView("redirect:/habitaciones");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/findOne")
    @ResponseBody
	public Habitacion editx( Integer id ) {
		return  habitacionServicio.get(id).get()	;
	}
	
	
	
	
	
	
	@PostMapping("/update")
	public String update(Habitacion habitacion ) {
		habitacionServicio.update(habitacion);		
		return "redirect:/habitaciones";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		habitacionServicio.delete(id);
		return "redirect:/habitaciones";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

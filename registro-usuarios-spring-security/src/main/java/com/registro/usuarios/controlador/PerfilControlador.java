package com.registro.usuarios.controlador;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.AlmacenServicioImpl;
import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.HabitacionServicio;
import com.registro.usuarios.servicio.RolServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
@RequestMapping("/perfil")
public class PerfilControlador {
	
	@Autowired
	private HabitacionServicio habitacionServicio;

	
	@Autowired
	private ClienteServicio clienteServicio;
	private UsuarioServicio usuarioServicio;

	public PerfilControlador(UsuarioServicio usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}
	@Autowired
	private AlmacenServicioImpl servicio;
	
	@Autowired
	RolServicio rolServicio;
	
	

	
	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo,HttpSession session) {
	
		Usuario usuario =usuarioServicio.buscarid( Integer.parseInt(session.getAttribute("idusuario").toString())  ).get();

		List<Rol>roless=rolServicio.listar();

		Integer rolex=roless.size();
		List<Habitacion>habitacidispo=habitacionServicio.listarpornom("disponible");
		Integer habidispo=habitacidispo.size();

		List<Habitacion>habitaciones=habitacionServicio.listar();
		Integer habi=habitaciones.size();
		List<Usuario>usuariosx=usuarioServicio.listarUsuarios();
		Integer usua=usuariosx.size();
		
		modelo.addAttribute("usuariosx", usuariosx);
		modelo.addAttribute("usuarios", usua);
		modelo.addAttribute("roles",rolServicio.listar());
		modelo.addAttribute("totaluser",usua );
		modelo.addAttribute("totalhabi",habi );
		modelo.addAttribute("habidispo",habidispo );
		modelo.addAttribute("totalrol",rolex );

		
		
		
		
		String nombre=usuario.getNombre()+" "+usuario.getApellido();
	    modelo.addAttribute("mensaje",nombre);
		modelo.addAttribute("usuario", usuario);

		return "/Perfil/perfil";
	}
	
	
	@PostMapping("")
	public ModelAndView registrarCuentaDeUsuario( Usuario usuario){
		if(usuario.getId()!=null)
		{
			Optional<Usuario> peliculaDB = usuarioServicio.buscarid(usuario.getId());
			peliculaDB.get().setNombre(usuario.getNombre());
			peliculaDB.get().setApellido(usuario.getApellido());
			peliculaDB.get().setTelefono(usuario.getTelefono());
			peliculaDB.get().setFechaNacimiento(usuario.getFechaNacimiento());
			peliculaDB.get().setEmail(usuario.getEmail());
			
			
			peliculaDB.get().setIdRol(usuario.getIdRol());
			if(!usuario.getImghabitacion().isEmpty()) {
				servicio.eliminarArchivo(peliculaDB.get().getRutaimagenhabi());
				String rutaPortada = servicio.almacenarArchivo(usuario.getImghabitacion());
				peliculaDB.get().setRutaimagenhabi(rutaPortada);
			}
			
			usuarioServicio.save(peliculaDB.get());
			return new ModelAndView("redirect:/usuariox");
			
		}
		String rutaPortada = servicio.almacenarArchivo(usuario.getImghabitacion());
		usuario.setRutaimagenhabi(rutaPortada);
		usuarioServicio.save(usuario);
		return new ModelAndView("redirect:/usuariox");
	}
	
	
	
	@GetMapping("/findOne")
    @ResponseBody
	public Usuario editlk( Integer id ) {
		return  usuarioServicio.buscarid(id).get()	;
	}
	
	
	
	@GetMapping( value =  "/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id,Model modelo ) {
		Optional<Usuario> usuario= usuarioServicio.buscarid(id);
		List<Rol> roles = rolServicio.listar();
		modelo.addAttribute("usuario",usuario);
		modelo.addAttribute("roles",roles);
		return new
				ModelAndView("/Usuarios/usuariosedit");				
	}
	
	@PostMapping( value =  "/edit/{id}")
	public ModelAndView editX(@PathVariable Integer id,Usuario usuario ) {
		Optional<Usuario> habi=usuarioServicio.buscarid(id);
		habi.get().setNombre(usuario.getNombre());
		habi.get().setApellido(usuario.getApellido());
		habi.get().setTelefono(usuario.getTelefono());
		habi.get().setFechaNacimiento(usuario.getFechaNacimiento());
		habi.get().setEmail(usuario.getEmail());
		habi.get().setPassword(usuario.getPassword());
		habi.get().setIdRol(usuario.getIdRol());
		
		if(!usuario.getImghabitacion().isEmpty()) {
			servicio.eliminarArchivo(habi.get().getRutaimagenhabi());
			String rutaPortada = servicio.almacenarArchivo(usuario.getImghabitacion());
			habi.get().setRutaimagenhabi(rutaPortada);
		}
		usuarioServicio.save(habi.get());
		
				return new ModelAndView("redirect:/usuariox");
				
	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {	
		
		usuarioServicio.delete(id);
		return "redirect:/usuariox";
	}
	
	
	
	
	
	
}

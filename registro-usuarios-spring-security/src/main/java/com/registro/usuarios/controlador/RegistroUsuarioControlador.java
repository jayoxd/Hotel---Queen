package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.AlmacenServicioImpl;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

	private UsuarioServicio usuarioServicio;

	public RegistroUsuarioControlador(UsuarioServicio usuarioServicio) {
		super();
		this.usuarioServicio = usuarioServicio;
	}
	@Autowired
	private AlmacenServicioImpl servicio;
	
	
	
	
	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
		return new UsuarioRegistroDTO();
	}

	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
	
		String rutaPortada = servicio.almacenarArchivo(registroDTO.getImghabitacion());
		registroDTO.setRutaimagenhabi(rutaPortada);
		usuarioServicio.guardar(registroDTO);
		return "redirect:/registro?exito";
	}
	
	

	
	
	
	
	
	
}

package com.registro.usuarios.controlador;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.RolServicio;
import com.registro.usuarios.servicio.TipoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {

	private final Logger log= LoggerFactory.getLogger(RegistroControlador.class);

	@Autowired
	private UsuarioServicio servicio;
	
	@Autowired
	private RolServicio rolservi;
	
	
	@Autowired 
	private CaracteristicaServicio caracteristicaServicio;
	
	@Autowired 
	private TipoServicio tipoServicio;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo,Usuario usuario, HttpSession session) {
		
		
		Optional<Usuario> user=servicio.buscarid(Integer.parseInt(session.getAttribute("idusuario").toString()));
		log.info("Usuario de db: {}", user.get().getNombre());
		
		if (user.isPresent()) {
			session.setAttribute("idusuario", user.get().getId());
		}
		return "Layout/index";
	}
}

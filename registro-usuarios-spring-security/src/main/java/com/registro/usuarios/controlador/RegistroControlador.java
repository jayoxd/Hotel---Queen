package com.registro.usuarios.controlador;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.HabitacionServicio;
import com.registro.usuarios.servicio.ImgHabitacionServicio;
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
	private HabitacionServicio habitacionServicio;
	@Autowired
	private ClienteServicio clienteServicio;

	
	
	

	
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
		List<Cliente>clientes=clienteServicio.listar();
		Integer clientto=clientes.size();
		
		List<Usuario>usuariosx=servicio.listarUsuarios();
		Integer usua=usuariosx.size();
		
		List<Rol>roless=rolservi.listar();

		Integer rolex=roless.size();
		
		List<Habitacion>habitacidispo=habitacionServicio.listarpornom("disponible");
		Integer habidispo=habitacidispo.size();

		List<Habitacion>habitacionesx=habitacionServicio.listarpornom("Ocupado");
		Integer habiocupado=habitacionesx.size();
		
		List<Habitacion>habitacionesmante=habitacionServicio.listarpornom("Limpieza");
		Integer habiomanteni=habitacionesmante.size();
		
		List<Habitacion>habitacionreser=habitacionServicio.listarpornom("Reservado");
		Integer habioreser=habitacionreser.size();
		
		
		List<Habitacion>habitacionesxd=habitacionServicio.listar();
		Integer habi=habitacionesxd.size();
		
		modelo.addAttribute("rolex",rolex );
		modelo.addAttribute("usuarr",usua );
		modelo.addAttribute("habiomanteni",habiomanteni );
		modelo.addAttribute("habioreser",habioreser );
		modelo.addAttribute("totalhabi",habi );
		modelo.addAttribute("habidispo",habidispo );
		modelo.addAttribute("habiocupado",habiocupado );
		modelo.addAttribute("clientestotla",clientto );

		modelo.addAttribute("clientes",clientes );
		
		return "Layout/index";
	}
}

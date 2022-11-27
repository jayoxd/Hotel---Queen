package com.registro.usuarios.controlador;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.Limpieza;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.LimpiezaServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
@RequestMapping("/limpiezas")
public class LimpiezaController {

	@Autowired
	private LimpiezaServicio limpiezaServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("limpiezas", limpiezaServicio.listar());
		return "listax/listalimpiez";
	}
		
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioDeNuevaPelicula(Model modelo) {
		return new ModelAndView("limpiezas/create")
				.addObject("limpieza", new Limpieza())
				;
	}
	
	
	@PostMapping("/nuevo")
	public ModelAndView registrarCuentaDeUsuario( Limpieza limpieza , HttpSession session)throws IOException{
		Usuario u= usuarioServicio.buscarid(Long.parseLong(session.getAttribute("idusuario").toString() )).get();
		limpieza.setIdUsuario(u);
		limpiezaServicio.save(limpieza);
		return new ModelAndView("redirect:/limpiezas");
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id ) {
		Limpieza limpieza= limpiezaServicio.get(id).get();
		return new ModelAndView("limpiezas/editar-limpiezas")
				.addObject("limpieza",limpieza);
	}
	
	
	@PostMapping("/update")
	public String update(Limpieza limpieza ) {
		limpiezaServicio.update(limpieza);		
		return "redirect:/limpiezas";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		limpiezaServicio.delete(id);
		return "redirect:/limpiezas";
	}
}

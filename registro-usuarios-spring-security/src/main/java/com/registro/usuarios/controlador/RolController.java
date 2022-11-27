package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.servicio.RolServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
@RequestMapping("/roles")
public class RolController {

	
	@Autowired 
	private RolServicio rolServicio;
	

	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("roles", rolServicio.listar());
		return "listax/listaroles";
	}
		
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioDeNuevaPelicula(Model modelo) {
		return new ModelAndView("roles/create")
				.addObject("rol", new Rol())
				;
	}
	
	
	@PostMapping("/nuevo")
	public ModelAndView registrarCuentaDeUsuario( Rol rol )  {
		rolServicio.save(rol);
		return new ModelAndView("redirect:/roles");
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id ) {
		Rol rol= rolServicio.get(id).get();
		return new ModelAndView("roles/editar-rol")
				.addObject("rol",rol);
	}
	
	
	@PostMapping("/update")
	public String update(Rol rol ) {
		rolServicio.update(rol);		
		return "redirect:/roles";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		rolServicio.delete(id);
		return "redirect:/roles";
	}
	
	
}

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
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.TipoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;


@Slf4j 
@Controller
@RequestMapping("/tipos")
public class TiposController {

	@Autowired 
	private TipoServicio tipoServicio;
	

	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("tipos", tipoServicio.listar());
		return "listax/listatipo";
	}
		
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioDeNuevaPelicula(Model modelo) {
		return new ModelAndView("tipos/create")
				.addObject("tipos", new Tipo())
				;
	}
	
	
	@PostMapping("/nuevo")
	public ModelAndView registrarCuentaDeUsuario( Tipo tipo )  {
		tipoServicio.save(tipo);
		return new ModelAndView("redirect:/tipos");
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id ) {
		Tipo tipo= tipoServicio.get(id).get();
		return new ModelAndView("tipos/editar-tipo")
				.addObject("tipo",tipo);
	}
	
	
	@PostMapping("/update")
	public String update(Tipo tipo ) {
		tipoServicio.update(tipo);		
		return "redirect:/tipos";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		tipoServicio.delete(id);
		return "redirect:/tipos";
	}
	
	
	
	
}

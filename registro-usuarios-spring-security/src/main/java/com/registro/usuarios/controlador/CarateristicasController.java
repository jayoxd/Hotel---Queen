package com.registro.usuarios.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.*;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.HabitacionServicio;
import com.registro.usuarios.servicio.TipoServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;




import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;


@Slf4j 
@Controller
@RequestMapping("/caracteristica")
public class CarateristicasController {
	

	
	@Autowired 
	private CaracteristicaServicio caracteristicaServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo,@Param("palabra")String palabra) {
		List<Caracteristica>listacaracter=caracteristicaServicio.listarpornom(palabra);
		modelo.addAttribute("caracteristicas",listacaracter );
		modelo.addAttribute("palabra", palabra);
		return "listax/listacarac";
	}
		
	
	
	
	
	
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioDeNuevaPelicula(Model modelo) {
		return new ModelAndView("caracteristicas/create")
				.addObject("caracteristica", new Caracteristica())
				;
	}
	
	
	@PostMapping("/nuevo")
	public ModelAndView registrarCuentaDeUsuario( Caracteristica caracteristica )  {
		caracteristicaServicio.save(caracteristica);
		return new ModelAndView("redirect:/caracteristicas");
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id ) {
		Caracteristica caracteristica= caracteristicaServicio.get(id).get();
		return new ModelAndView("caracteristicas/editar-caracteristicas")
				.addObject("caracteristica",caracteristica);
	}
	
	
	@PostMapping("/update")
	public String update(Caracteristica caracteristica ) {
		caracteristicaServicio.update(caracteristica);		
		return "redirect:/caracteristicas";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		caracteristicaServicio.delete(id);
		return "redirect:/caracteristicas";
	}
	
	
	
	
	
	
	
}

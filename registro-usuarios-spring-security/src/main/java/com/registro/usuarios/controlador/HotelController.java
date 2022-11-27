package com.registro.usuarios.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.registro.usuarios.modelo.Hotel;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.servicio.HotelServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
@RequestMapping("/hotelver")
public class HotelController {
	
	@Autowired 
	private HotelServicio hotelServicio;
	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("hotel", hotelServicio.listar());
		return "listax/listahotel";
	}
		
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioDeNuevaPelicula(Model modelo) {
		return new ModelAndView("hotel/create")
				.addObject("hotel", new Hotel())
				;
	}
	
	
	@PostMapping("/nuevo")
	public ModelAndView registrarCuentaDeUsuario( Hotel hotel )  {
		hotelServicio.save(hotel);
		return new ModelAndView("redirect:/hotelver");
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id ) {
		Hotel hotel= hotelServicio.get(id).get();
		return new ModelAndView("hotelver/editar-hotel")
				.addObject("hotel",hotel);
	}
	
	
	@PostMapping("/update")
	public String update(Hotel hotel ) {
		hotelServicio.update(hotel);		
		return "redirect:/hotelver";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		hotelServicio.delete(id);
		return "redirect:/hotelver";
	}
	
	
	
}

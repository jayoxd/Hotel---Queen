package com.registro.usuarios.controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.*;

import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Cliente;
import com.registro.usuarios.modelo.Habitacion;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.CaracteristicaServicio;
import com.registro.usuarios.servicio.ClienteServicio;
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
	private ClienteServicio clienteServicio;
	@Autowired
	private HabitacionServicio habitacionServicio;
	@Autowired 
	private CaracteristicaServicio caracteristicaServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo,@Param("palabra")String palabra) {
		List<Caracteristica>listacaracter=caracteristicaServicio.listarpornom(palabra);
		modelo.addAttribute("caracteristicas",listacaracter );
		modelo.addAttribute("palabra", palabra);
		Integer caracto=listacaracter.size();
		
		
		List<Cliente>clientes=clienteServicio.listar();
		Integer clientto=clientes.size();
		
		List<Habitacion>habitacidispo=habitacionServicio.listarpornom("disponible");
		Integer habidispo=habitacidispo.size();

		List<Habitacion>habitaciones=habitacionServicio.listar();
		Integer habi=habitaciones.size();
		List<Usuario>usuarios=usuarioServicio.listarUsuarios();
		Integer usua=usuarios.size();
		
		
		
		
		modelo.addAttribute("clientes",clientes );
		modelo.addAttribute("palabra", palabra);
		modelo.addAttribute("total",clientto );
		modelo.addAttribute("totaluser",usua );
		modelo.addAttribute("totalhabi",habi );
		modelo.addAttribute("habidispo",habidispo );
		
		
		modelo.addAttribute("caractot",caracto );

		
		modelo.addAttribute("caracteristica",new Caracteristica());
		return "Caracteristicas/caracteristicas";
	}
		
	
	

	
	
	@PostMapping("")
	public ModelAndView registrarCuentaDeUsuario( Caracteristica caracteristica )  {
		caracteristicaServicio.save(caracteristica);
		return new ModelAndView("redirect:/caracteristica");
	}
	

	
	/*@GetMapping("{id}/editar/")
	public ModelAndView edit(@PathVariable Integer id ) {
		//Caracteristica caracteristica= new Caracteristica();
		//Optional<Caracteristica> optionalCaracteristica=caracteristicaServicio.get(id);
		 Caracteristica caracteristica = caracteristicaServicio.get(id);
		return new ModelAndView("Caracteristicas/caracteristicas")
				.addObject("caracteristica",caracteristica)
				;
	
	}*/
	@GetMapping("/findOne")
    @ResponseBody
	public Caracteristica edit( Integer id ) {
		//Caracteristica caracteristica= new Caracteristica();
		//Optional<Caracteristica> optionalCaracteristica=caracteristicaServicio.get(id);
		return  caracteristicaServicio.get(id).get()
				;
	
	}
	
	
	
	/*@PostMapping("{id}/edit/")
	public String update(Caracteristica caracteristica ) {
		Caracteristica p= new Caracteristica();
		p=caracteristicaServicio.get(caracteristica.getId()).get();	
		caracteristicaServicio.update(caracteristica);		
		return "redirect:/caracteristica";
	}*/
	
	/*@PostMapping("{id}/editar")
	public ModelAndView actualizarPelicula(@PathVariable Integer id,@Validated Caracteristica pelicula) {
		
		
		Caracteristica caraDB = caracteristicaServicio.get(id).get();
		caraDB.setNombre(pelicula.getNombre());
	
		
	
		caracteristicaServicio.save(caraDB);
		return new ModelAndView("redirect:/caracteristica");
	}*/
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		caracteristicaServicio.delete(id);
		return "redirect:/caracteristica";
	}
	
	
	
	
	
	
	
}

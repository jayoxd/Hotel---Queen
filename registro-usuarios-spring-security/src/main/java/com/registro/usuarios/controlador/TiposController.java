package com.registro.usuarios.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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


@Slf4j 
@Controller
@RequestMapping("/tipo")
public class TiposController {

	@Autowired 
	private TipoServicio tipoServicio;
	@Autowired
	private ClienteServicio clienteServicio;
	@Autowired
	private HabitacionServicio habitacionServicio;

	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo,@Param("palabra")String palabra) {
		List<Tipo>listartipo=tipoServicio.listarpornom(palabra);
		
		List<Tipo>listartipox=tipoServicio.listar();
		Integer totaltipo=listartipox.size();

		
		
		List<Habitacion>habitacidispo=habitacionServicio.listarpornom("disponible");
		Integer habidispo=habitacidispo.size();

		List<Habitacion>habitaciones=habitacionServicio.listar();
		Integer habi=habitaciones.size();
		
		List<Cliente>clientes=clienteServicio.listar();
		Integer clientto=clientes.size();
		
		
		modelo.addAttribute("totaltipo",totaltipo );
		modelo.addAttribute("totalhabi",habi );
		modelo.addAttribute("habidispo",habidispo );
		modelo.addAttribute("total",clientto );

		modelo.addAttribute("tipos",listartipo );
		modelo.addAttribute("palabra", palabra);
		modelo.addAttribute("tipo",new Tipo());
		return "Tipos/tipos";
	}
		
	
	
	
	@PostMapping("")
	public ModelAndView registrarCuentaDeUsuario( Tipo tipo )  {
		tipoServicio.save(tipo);
		return new ModelAndView("redirect:/tipo");
	}
	

	@GetMapping("/findOne")
    @ResponseBody
	public Tipo edit( Integer id ) {
		//Caracteristica caracteristica= new Caracteristica();
		//Optional<Caracteristica> optionalCaracteristica=caracteristicaServicio.get(id);
		return  tipoServicio.get(id).get()
				;
	
	}
	

	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		tipoServicio.delete(id);
		return "redirect:/tipo";
	}
	
	
	
	
}

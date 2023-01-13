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
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.servicio.RolServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
@RequestMapping("/role")
public class RolController {

	
	@Autowired 
	private RolServicio rolServicio;
	

	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo,@Param("palabra")String palabra) {
		List<Rol>roles=rolServicio.listarpornom(palabra);
		modelo.addAttribute("roles",roles );
		modelo.addAttribute("rol",new Rol());
		return "Roles/roles";
	}
		

	
	
	@PostMapping("")
	public ModelAndView registrarCuentaDeUsuario( Rol rol )  {
		rolServicio.save(rol);
		return new ModelAndView("redirect:/roles");
	}
	

	@GetMapping("/findOne")
    @ResponseBody
	public Rol edit( Integer id ) {
		//Caracteristica caracteristica= new Caracteristica();
		//Optional<Caracteristica> optionalCaracteristica=caracteristicaServicio.get(id);
       
        
		return  rolServicio.get(id).get();
				
	
	}
	
	
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		rolServicio.delete(id);
		return "redirect:/role";
	}
	
	
}

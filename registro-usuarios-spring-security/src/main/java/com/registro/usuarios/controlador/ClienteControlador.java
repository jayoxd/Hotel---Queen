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
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.UsuarioServicio;

import lombok.extern.slf4j.Slf4j;

@Slf4j 
@Controller
@RequestMapping("/clientes")
public class ClienteControlador {

	@Autowired
	private ClienteServicio clienteServicio;
	
	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@GetMapping("")
	public String verPaginaDeInicio(Model modelo) {
		modelo.addAttribute("clientes", clienteServicio.listar());
		return "listax/listaclient";
	}
		
	@GetMapping("/nuevo")
	public ModelAndView mostrarFormularioDeNuevaPelicula(Model modelo) {
		return new ModelAndView("clientes/create")
				.addObject("cliente", new Caracteristica())
				;
	}
	
	
	@PostMapping("/nuevo")
	public ModelAndView registrarCuentaDeUsuario( Cliente cliente , HttpSession session)throws IOException{
		Usuario u= usuarioServicio.buscarid(Long.parseLong(session.getAttribute("idusuario").toString() )).get();
		//cliente.setIdUsuario(u);
		clienteServicio.save(cliente);
		return new ModelAndView("redirect:/clientes");
	}
	

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable Integer id ) {
		Cliente cliente= clienteServicio.get(id).get();
		return new ModelAndView("clientes/editar-clientes")
				.addObject("cliente",cliente);
	}
	
	
	@PostMapping("/update")
	public String update(Cliente cliente ) {
		clienteServicio.update(cliente);		
		return "redirect:/clientes";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {		
		clienteServicio.delete(id);
		return "redirect:/clientes";
	}
	
}

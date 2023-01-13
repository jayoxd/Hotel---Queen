package com.registro.usuarios.controlador;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
import com.registro.usuarios.modelo.ImgHabitacion;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.Tipo;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.servicio.AlmacenServicioImpl;
import com.registro.usuarios.servicio.ClienteServicio;
import com.registro.usuarios.servicio.RolServicio;
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
	@Autowired 
	private RolServicio rolServicio;
	@Autowired
	private AlmacenServicioImpl servicio;

	@GetMapping("")
	public String verPaginaDeInicio(Model modelo,@Param("palabra")String palabra) {
		List<Cliente>clientes=clienteServicio.listarpornom(palabra);
		Cliente cliente=new Cliente();
		modelo.addAttribute("clientes",clientes );
		modelo.addAttribute("palabra", palabra);
		modelo.addAttribute("cliente",cliente);
		return "Clientes/clientes";
	}
	

	
	@PostMapping("")
	public ModelAndView registrarCuentaDeUsuario( Cliente cliente ){
		if(cliente.getId_cliente()!=null)
		{
			Optional<Cliente> peliculaDB = clienteServicio.get(cliente.getId_cliente());
			peliculaDB.get().setNombre(cliente.getNombre());
			peliculaDB.get().setApellido(cliente.getApellido());
			peliculaDB.get().setTelefono(cliente.getTelefono());
			peliculaDB.get().setFechaNacimiento(cliente.getFechaNacimiento());
			peliculaDB.get().setEmail(cliente.getEmail());
			if(!cliente.getImghabitacion().isEmpty()) {
				servicio.eliminarArchivo(peliculaDB.get().getRutaimagenhabi());
				String rutaPortada = servicio.almacenarArchivo(cliente.getImghabitacion());
				peliculaDB.get().setRutaimagenhabi(rutaPortada);
			}
			
			clienteServicio.save(peliculaDB.get());
			return new ModelAndView("redirect:/clientes");
			
		}
		String rutaPortada = servicio.almacenarArchivo(cliente.getImghabitacion());
		cliente.setRutaimagenhabi(rutaPortada);
		Rol rol=rolServicio.get(3).get();
		cliente.setIdRol(rol);
		clienteServicio.save(cliente);
		return new ModelAndView("redirect:/clientes");
	}
	
	@GetMapping("/findOne")
    @ResponseBody
	public Cliente editlk( Integer id ) {
		return  clienteServicio.get(id).get()	;
	}
	

	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {	
		Optional<Cliente> pelicula = clienteServicio.get(id);
		clienteServicio.delete(pelicula.get().getId_cliente());
		servicio.eliminarArchivo(pelicula.get().getRutaimagenhabi());

		return "redirect:/clientes";
	}
	
}

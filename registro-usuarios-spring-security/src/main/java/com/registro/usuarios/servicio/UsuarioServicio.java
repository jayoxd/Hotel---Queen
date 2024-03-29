package com.registro.usuarios.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
	public Optional<Usuario> buscarid(Integer id);
	
	public Usuario save(Usuario usuario);
	
	public List<Usuario>listarpornom(String nombre);
	
	public  void delete(Integer id);

}

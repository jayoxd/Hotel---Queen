package com.registro.usuarios.servicio;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.registro.usuarios.controlador.HabitacionController;
import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Rol;
import com.registro.usuarios.modelo.Usuario;
import com.registro.usuarios.repositorio.UsuarioRepositorio;

import lombok.extern.slf4j.Slf4j;
@Slf4j 
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired 
	private RolServicio rolServicio;
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	HttpSession session;
	public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Rol rol=rolServicio.get(1).get();
		
		Usuario usuario = new Usuario(registroDTO.getNombre(),registroDTO.getApellido(),registroDTO.getTelefono(),
				registroDTO.getFechaNacimiento(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()),
				registroDTO.getRutaimagenhabi(),registroDTO.getImghabitacion(),rol);

		return usuarioRepositorio.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepositorio.findByEmail(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		session.setAttribute("idusuario", usuario.getId());
		log.info("ejecuntado el controlador rest");
		log.info("Id de la orden {}",usuario.getId().toString());
		
		GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getIdRol().getNombre());

		
		return new User(usuario.getEmail(),usuario.getPassword(), Arrays.asList(authority));
	
		
		
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Rol roles){
		return ((Collection<? extends GrantedAuthority>) roles).stream().map(role -> new SimpleGrantedAuthority(((UsuarioRegistroDTO) role).getNombre())).collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Optional<Usuario> buscarid(Integer id) {
		return usuarioRepositorio.findById(id);
}

	@Override
	public Usuario save(Usuario usuario) {
		Rol rol=rolServicio.get(1).get();
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		//usuario.setIdRol(rol);
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public List<Usuario> listarpornom(String nombre) {
		if(nombre!=null) {
			 return	usuarioRepositorio.buscarcar(nombre);
			}
			return usuarioRepositorio.findAll();
	}

	@Override
	public void delete(Integer id) {
		usuarioRepositorio.deleteById(id);
		
	}
}

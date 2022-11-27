package com.registro.usuarios.servicio;
import javax.servlet.http.HttpSession;

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
		Usuario usuario = new Usuario(registroDTO.getNombre(),registroDTO.getApellido(),registroDTO.getTelefono(),
				registroDTO.getFechaNacimiento(),registroDTO.getEmail(),passwordEncoder.encode(registroDTO.getPassword()),
				registroDTO.getRutaimagenhabi(),registroDTO.getImghabitacion(),Arrays.asList(new Rol("ROLE_ADMIN")));

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
		return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
	}

	private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}
	
	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public Optional<Usuario> buscarid(Long id) {
		return usuarioRepositorio.findById(id);
}

	@Override
	public Usuario save(Usuario usuario) {
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		usuario.setRoles(Arrays.asList(new Rol("ROLE_ADMIN")));
		return usuarioRepositorio.save(usuario);
	}
}

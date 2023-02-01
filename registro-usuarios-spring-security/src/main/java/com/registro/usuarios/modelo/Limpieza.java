package com.registro.usuarios.modelo;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name = "limpieza")
public class Limpieza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_limpieza")
	private Integer id_limpieza;

	

	
	@NotBlank
	private String obeservacion;


	@JoinColumn(name = "id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	// PONER EL EAGER ACA SI HEMOS PUESTO EN EL OTRO
	private Usuario idUsuario;
	

	

	



	public Integer getId_limpieza() {
		return id_limpieza;
	}









	public void setId_limpieza(Integer id_limpieza) {
		this.id_limpieza = id_limpieza;
	}









	


















	public String getObeservacion() {
		return obeservacion;
	}




	public void setObeservacion(String obeservacion) {
		this.obeservacion = obeservacion;
	}




	public Usuario getIdUsuario() {
		return idUsuario;
	}




	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}









	public Limpieza() {
		super();
	}









	public Limpieza(Integer id_limpieza, @NotBlank String obeservacion, Usuario idUsuario) {
		super();
		this.id_limpieza = id_limpieza;
		this.obeservacion = obeservacion;
		this.idUsuario = idUsuario;
	}









	
}

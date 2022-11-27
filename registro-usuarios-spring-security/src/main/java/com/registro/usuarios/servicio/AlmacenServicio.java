package com.registro.usuarios.servicio;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface AlmacenServicio {

	public void iniciarAlmacenDeArchivos();

	public String almacenarArchivo(MultipartFile archivo) throws IOException;

	public Path cargarArchivo(String nombreArchivo);

	public Resource cargarComoRecurso(String nombreArchivo);

	public void eliminarArchivo(String nombreArchivo);
}

package com.registro.usuarios.servicio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;



import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Caracteristica;
import com.registro.usuarios.modelo.Reserva;
import com.registro.usuarios.repositorio.CaracteristicaRepositorio;
import com.registro.usuarios.repositorio.ReservaRepositorio;


@Service
public class ReservServicioImpl implements ReservaServicio {

	@Autowired
	private ReservaRepositorio reservaRepositorio;

	  @Autowired
	  private EntityManager entityManager;
	
	@Override
	public Reserva save(Reserva reserva) {
		 return reservaRepositorio.save(reserva);
	}

	@Override
	public Optional<Reserva> get(Integer id) {
		return reservaRepositorio.findById(id);
	}

	@Override
	public void update(Reserva reserva) {
	
		  reservaRepositorio.save(reserva);

	}

	@Override
	public void delete(Integer id) {
		reservaRepositorio.deleteById(id);
	}

	@Override
	public List<Reserva> listar() {
		return reservaRepositorio.findAll();
	}

	@Override
	public List<Reserva> listarpornom(Integer nombre) {
		if(nombre!=null) {
			 return	reservaRepositorio.buscarcar(nombre);
			}
			return reservaRepositorio.findAll();
	}

	@Override
	public List<Reserva> listarreserva(String dato) {

		if(dato!=null) {
			 return	reservaRepositorio.buscarreserva(dato);
			}
			return reservaRepositorio.findAll();
	}

	@Transactional
	@Override
	public void actualizarCodigoAutogenerado() {
	    entityManager.createNativeQuery("UPDATE Reserva SET nrrecibo = CONCAT('AA', LPAD(id_reserva, 3, '0'))").executeUpdate();
	
	}
	
	@Override
	 public Reserva isRoomAvailable( LocalDate startDate, LocalDate endDate) {
         
        List<Reserva> reservas =reservaRepositorio.findByIdHabitacion_IdAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqual (null,startDate, endDate);
        if (reservas.size() > 1) {
            throw new RuntimeException("Error: se encontraron múltiples reservas para el rango de fechas dado");
        }
        return reservas.isEmpty() ? null : reservas.get(0);
    
	}

	@Override
	public boolean isRoomAvailableXD(LocalDate startDate, LocalDate endDate,Integer id) {
		  List<Reserva> reservaciones = reservaRepositorio.findByIdHabitacion_IdAndFechaInicioLessThanEqualAndFechaFinGreaterThanEqual (id,startDate, endDate );
	        return reservaciones.isEmpty();
	}
	
	

}






































package pe.edu.uni.sigetur.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.uni.sigetur.backend.model.ServicioTuristico;
import pe.edu.uni.sigetur.backend.model.enums.CategoriaServicio;

import java.util.List;

public interface ServicioTuristicoRepository extends JpaRepository<ServicioTuristico, Long> {

    List<ServicioTuristico> findByEstadoDisponibleTrue(); // Servicios activos/disponibles para ofrecer al cliente

    List<ServicioTuristico> findByCategoriaAndEstadoDisponibleTrue(CategoriaServicio categoria); // (ej. solo hoteles)

    List<ServicioTuristico> findByNombreServicioContainingIgnoreCaseAndEstadoDisponibleTrue(String nombre);
}

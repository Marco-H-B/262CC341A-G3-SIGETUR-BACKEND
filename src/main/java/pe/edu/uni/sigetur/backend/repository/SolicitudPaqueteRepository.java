package pe.edu.uni.sigetur.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository; // Herramienta de Spring que ya trae guardar, buscar, actualizar y borrar
import pe.edu.uni.sigetur.backend.model.SolicitudPaquete;
import pe.edu.uni.sigetur.backend.model.enums.EstadoSolicitud;

import java.util.List; // Lista para devolver varios resultados
import java.util.Optional; // Caja segura que puede traer un resultado o venir vacía sin dar error

public interface SolicitudPaqueteRepository extends JpaRepository<SolicitudPaquete, Long> {  // Conecta la tabla SolicitudPaquete (cuyo ID es Long) con la BD

    Optional<SolicitudPaquete> findByNumeroSolicitud(String numeroSolicitud);

    List<SolicitudPaquete> findByClienteIdPersonaOrderFechaRefistroDesc(Long idCliente);

    List<SolicitudPaquete> findByEstadoOrderByFechaRegistroDesc(EstadoSolicitud estado);
}

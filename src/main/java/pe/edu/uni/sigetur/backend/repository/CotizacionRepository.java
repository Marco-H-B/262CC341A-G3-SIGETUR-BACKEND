package pe.edu.uni.sigetur.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.uni.sigetur.backend.model.Cotizacion;
import pe.edu.uni.sigetur.backend.model.enums.EstadoCotizacion;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

public interface CotizacionRepository extends JpaRepository<Cotizacion, Long> {

    Optional<Cotizacion> findByCodigoCotizacionAndVersion(String codigoCotizacion, Integer version);

    Optional<Cotizacion> findTopByCodigoCotizacionOrderByVersionDesc(String codigoCotizacion);

    List<Cotizacion> findBySolicitudIdSolicitudOrderByVersionDesc(Long idSolicitud);

    List<Cotizacion> findByEstadoOrderByFechaEmisionDesc(EstadoCotizacion estado);

    List<Cotizacion> findByEstadoInAndFechaVencimientoBefore(List<EstadoCotizacion> estados, OffsetDateTime fecha); // vencidas
}

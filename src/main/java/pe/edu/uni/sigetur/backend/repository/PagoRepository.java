package pe.edu.uni.sigetur.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.uni.sigetur.backend.model.Pago;
import pe.edu.uni.sigetur.backend.model.enums.EstadoPago;

import java.util.Optional;

public interface PagoRepository extends JpaRepository<Pago, Long> {

    Optional<Pago> findByCotizacionIdCotizacion(Long idCotizacion);

    Optional<Pago> findByCodigoOperacion(String codigoOperacion);

    boolean existsByCotizacionIdCotizacionAndEstadoTransaccion(Long idCotizacion, EstadoPago estadoTransaccion);
}

package pe.edu.uni.sigetur.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.uni.sigetur.backend.model.ConstanciaViaje;

import java.util.Optional;

public interface ConstanciaViajeRepository extends JpaRepository<ConstanciaViaje, Long> {

    Optional<ConstanciaViaje> findByPagoIdPago(Long idPago);

    Optional<ConstanciaViaje> findByCodigoVoucher(String codigoVoucher);
}

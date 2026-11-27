package pe.edu.uni.sigetur.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.uni.sigetur.backend.model.ItemCotizacion;

import java.util.List;

public interface ItemCotizacionRepository extends JpaRepository<ItemCotizacion, Long> {

    List<ItemCotizacion> findByCotizacionIdCotizacion(Long idCotizacion);

    void deleteByCotizacionIdCotizacion(Long idCotizacion);
}

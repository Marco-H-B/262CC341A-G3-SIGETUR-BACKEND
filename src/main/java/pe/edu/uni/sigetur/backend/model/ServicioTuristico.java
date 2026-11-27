package pe.edu.uni.sigetur.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode; // Avisa a Hibernate que tipo exacto tiene la columna en la BD
import org.hibernate.type.SqlTypes; // Lista de tipos de datos de base de datos
import pe.edu.uni.sigetur.backend.model.enums.CategoriaServicio;

import java.math.BigDecimal;

@Entity
@Table(name = "servicio_turistico", schema = "sigetur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioTuristico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long idServicio;

    @Column(name = "nombre_servicio", nullable = false, length = 160)
    private String nombreServicio;

    @Column(name = "proveedor", nullable = false, length = 160)
    private String proveedor;

    @Column(name = "costo_base", nullable = false, precision = 12, scale = 2)
    private BigDecimal costoBase;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM) // Avisa a Hibernate que esta columna es un ENUM, no un texto comun
    @Column(name = "categoria", nullable = false)
    private CategoriaServicio categoria;

    @Column(name = "estado_disponible", nullable = false)
    private Boolean estadoDisponible;

    @Column(name = "descripcion", columnDefinition = "text")
    private String descripcion;
}

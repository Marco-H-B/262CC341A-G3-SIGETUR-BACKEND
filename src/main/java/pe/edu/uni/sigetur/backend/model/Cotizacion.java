package pe.edu.uni.sigetur.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pe.edu.uni.sigetur.backend.model.enums.EstadoCotizacion;
import pe.edu.uni.sigetur.backend.model.enums.MotivoCancelacion;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "cotizacion", schema = "sigetur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cotizacion")
    private Long idCotizacion;

    @Column(name = "codigo_cotizacion", nullable = false, length = 20)
    private String codigoCotizacion;

    @Column(name = "version", nullable = false)
    private Integer version;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitud", nullable = false)
    private SolicitudPaquete solicitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agente", nullable = false)
    private AgenteReceptivo agente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_version_anterior")
    private Cotizacion versionAnterior;

    @Column(name = "fecha_emision")
    private OffsetDateTime fechaEmision;

    @Column(name = "fecha_vencimiento", nullable = false)
    private OffsetDateTime fechaVencimiento;

    @Column(name = "margen_comercial", nullable = false, precision = 5, scale = 4)
    private BigDecimal margenComercial;

    @Column(name = "costo_base_total", nullable = false, precision = 12, scale = 2)
    private BigDecimal costoBaseTotal;

    @Column(name = "total_cotizacion", nullable = false, precision = 12, scale = 2)
    private BigDecimal totalCotizacion;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "estado", nullable = false)
    private EstadoCotizacion estado;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "motivo_cancelacion")
    private MotivoCancelacion motivoCancelacion;

    @Column(name = "comentario_cancelacion", length = 500)
    private String comentarioCancelacion;

    @Column(name = "motivo_vencimiento", length = 120)
    private String motivoVencimiento;

    @Column(name = "fecha_cancelacion")
    private OffsetDateTime fechaCancelacion;

    @PrePersist
    public void prePersist() {
        if (version == null) version = 1;
        if (margenComercial == null) margenComercial = new BigDecimal("0.1500");
        if (costoBaseTotal == null) costoBaseTotal = BigDecimal.ZERO;
        if (totalCotizacion == null) totalCotizacion = BigDecimal.ZERO;
        if (estado == null) estado = EstadoCotizacion.EMITIDA;
        if (fechaEmision == null) fechaEmision = OffsetDateTime.now();
    }
}

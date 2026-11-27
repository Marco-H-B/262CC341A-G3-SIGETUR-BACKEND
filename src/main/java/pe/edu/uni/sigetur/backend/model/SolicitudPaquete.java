package pe.edu.uni.sigetur.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pe.edu.uni.sigetur.backend.model.enums.EstadoSolicitud;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "solicitud_paquete", schema = "sigetur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudPaquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Long idSolicitud;

    @Column(name = "numero_solicitud", nullable = false, unique = true, length = 20)
    private String numeroSolicitud;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "destino", nullable = false, length = 160)
    private String destino;

    @Column(name = "num_pasajeros", nullable = false)
    private Integer numPasajeros;

    @Column(name = "fecha_partida", nullable = false)
    private OffsetDateTime fechaPartida;

    @Column(name = "fecha_regreso", nullable = false)
    private OffsetDateTime fechaRegreso;

    @Column(name = "categoria_hotel", length = 40)
    private String categoriaHotel;

    @Column(name = "preferencias", columnDefinition = "text")
    private String preferencias;

    @Column(name = "presupuesto_aprox", precision = 12, scale = 2)
    private BigDecimal presupuestoAprox;

    @Column(name = "fecha_registro", nullable = false)
    private OffsetDateTime fechaRegistro;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "estado", nullable = false)
    private EstadoSolicitud estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_agente_asignado")
    private AgenteReceptivo agenteAsignado;

    @PrePersist
    public void prePersist() {
        if (fechaRegistro == null) {
            fechaRegistro = OffsetDateTime.now();
        }
        if (estado == null) {
            estado = EstadoSolicitud.REGISTRADA;
        }
    }
}

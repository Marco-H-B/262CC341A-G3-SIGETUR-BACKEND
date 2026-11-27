package pe.edu.uni.sigetur.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Entity
@Table(name = "constancia_viaje", schema = "sigetur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstanciaViaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_constancia")
    private Long idConstancia;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pago", nullable = false, unique = true)
    private Pago pago;

    @Column(name = "codigo_voucher", nullable = false, unique = true, length = 30)
    private String codigoVoucher;

    @Column(name = "fecha_emision", nullable = false)
    private OffsetDateTime fechaEmision;

    @Column(name = "detalle_servicios", nullable = false, columnDefinition = "text")
    private String detalleServicios;

    @Column(name = "codigo_qr", nullable = false, columnDefinition = "text")
    private String codigoQr;

    @PrePersist
    public void prePersist() {
        if (fechaEmision == null) {
            fechaEmision = OffsetDateTime.now();
        }
    }
}

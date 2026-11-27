package pe.edu.uni.sigetur.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agente_receptivo", schema = "sigetur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgenteReceptivo {

    @Id
    @Column(name = "id_persona")
    private Long idPersona;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_persona")
    private Empleado empleado;
}

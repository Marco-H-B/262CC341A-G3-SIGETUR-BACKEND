package pe.edu.uni.sigetur.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "empleado", schema = "sigetur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    @Column(name = "id_persona")
    private Long idPersona;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "codigo_empleado", nullable = false, unique = true, length = 20)
    private String codigoEmpleado;

    @Column(name = "cargo", nullable = false, length = 50)
    private String cargo;
}




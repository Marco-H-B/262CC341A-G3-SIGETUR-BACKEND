package pe.edu.uni.sigetur.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pe.edu.uni.sigetur.backend.model.enums.TipoDocumento;

@Entity
@Table(name = "persona", schema = "sigetur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "tipo_doc", nullable = false)
    private TipoDocumento tipoDoc;

    @Column(name = "num_doc", nullable = false, length = 20)
    private String numDoc;

    @Column(name = "nombre_completo", nullable = false, length = 160)
    private String nombreCompleto;

    @Column(name = "correo", nullable = false, length = 254)
    private String correo;

    @Column(name = "telefono", length = 25)
    private String telefono;
}

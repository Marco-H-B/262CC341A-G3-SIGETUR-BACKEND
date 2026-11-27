package pe.edu.uni.sigetur.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import pe.edu.uni.sigetur.backend.model.enums.TipoDocumento;

@Entiti
@Table(name = "persona", schema = "sigetur")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private long idPersona;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes,NAMED_ENUM)
    @Column(name = "tipo_doc", nullable = false)
    private TipoDocumento tipoDoc;

    @Column(name = "num_doc", nullable = false, length = 20)
    private String numDoc;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "telefono", length = 20)
    private String telefono;
}

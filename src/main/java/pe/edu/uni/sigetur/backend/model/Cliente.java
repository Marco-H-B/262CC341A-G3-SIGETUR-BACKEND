package pe.edu.uni.sigetur.backend.model;

import jakarta.persistence.*; // Herramientas para conectar Java con la base de datos
import lombok.AllArgsConstructor; // Atajo para crear constructor con todos los datos
import lombok.Builder; // Atajo para armar el objeto paso a paso
import lombok.Data; // Atajo para crear getters, setters y demas metodos automaticos
import lombok.NoArgsConstructor; // Atajo para crear constructor vacio

import java.time.OffsetDateTime; // Tipo de fecha que guarda dia, hora y zona horaria

@Entity // Avisa que esta clase representa una tabla real de la BD
@Table(name = "cliente", schema = "sigetur")
@Data // Genera automaticamente los get/set de todos los atributos
@Builder // Permite crear un Cliente
@NoArgsConstructor // Constructor vacio (obligatorio para que Spring lea filas de la BD)
@AllArgsConstructor // Constructor con todos los campos (necesario para @Builder)
public class Cliente {

    @Id // Marca este campo como el identificador unico
    @Column(name = "id_persona")
    private Long idPersona;

    @OneToOne(fetch = FetchType.LAZY) // Un cliente corresponde a una persona; LAZY = no carga los datos de Persona hasta que se pidan
    @MapsId // Copia el ID de Persona para usarlo como mi propio ID (no genera uno nuevo)
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "es_socio", nullable = false)
    private Boolean esSocio;

    @Column(name = "fecha_afiliacion")
    private OffsetDateTime fechaAfiliacion;

    @Column(name = "ruc_empresa", length = 11)
    private String rucEmpresa;

    @Column(name = "razon_social", length = 180)
    private String razonSocial;
}

package com.example.test.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "documento_persona")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoPersona implements Serializable {

        @Id
        @GeneratedValue(strategy = IDENTITY)
        @Column(name = "id_documento_persona")
        private Long id;

        @ManyToOne
        @JoinColumn(name = "persona_id")
        private Persona persona;

        @ManyToOne
        @JoinColumn(name = "documento_id")
        private Documento documento;

        @Size(min = 8, max = 11, message = "El numero de documento debe tener entre 8 y 11 caracteres")
        @Column(name = "numero_documento")
        private String numeroDocumento;
}

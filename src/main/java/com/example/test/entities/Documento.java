package com.example.test.entities;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "documento")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Documento implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_documento")
    private Long id;

    @Column(name = "documento")
    private String documento;
}

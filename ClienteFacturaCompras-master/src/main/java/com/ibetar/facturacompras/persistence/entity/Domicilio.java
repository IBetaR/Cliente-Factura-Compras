package com.ibetar.facturacompras.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "domicilio")
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_calle")
    @NotBlank
    @Size(min = 3 , max = 50)
    private String nombreCalle;

    @NotBlank
    @Column(name = "numero")
    private int numero;

    @OneToOne(mappedBy = "domicilio")
    @JoinColumn(name = "fk_cliente")
    private Cliente cliente;


}

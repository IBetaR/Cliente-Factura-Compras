package com.ibetar.facturacompras.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "articulo")
public class Articulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "cantidad")
    private int cantidad;

    @NotBlank
    @Column(name = "denominacion")
    private String denominacion;

    @NotBlank
    @Column(name = "precio")
    private float precio;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "articulo_categoria",
            joinColumns = @JoinColumn(name="articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "categoria_id"))
    private List<Categoria> categorias = new ArrayList<Categoria>();

    @OneToMany(mappedBy = "articulo", cascade = CascadeType.PERSIST)
    private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();
}

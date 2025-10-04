package es.unex.gc01.merchandisingservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Representa un producto físico abstracto en el sistema.
 * Puede ser extendido por tipos concretos de productos.
 * Contiene información básica como identificadores, nombre y precio.
 */
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {
    /**
     * Identificador único interno del producto.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    /**
     * Identificador público único del producto, generado automáticamente.
     */
    @Column(name = "public_id", unique = true, nullable = false, updatable = false)
    private UUID publicId = UUID.randomUUID();

    /**
     * Nombre del producto.
     */
    @Column(nullable = false)
    private String name;

    /**
     * Precio del producto.
     */
    @Column(nullable = false)
    private Float price;

    /**
     * Cantidad de artículos del producto.
     */
    @Column(nullable = false)
    private Integer stock;
}

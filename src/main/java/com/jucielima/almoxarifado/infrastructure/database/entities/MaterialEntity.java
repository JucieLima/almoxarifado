package com.jucielima.almoxarifado.infrastructure.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "materials")
@AllArgsConstructor
@Data
public class MaterialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id")
    private CategoryEntity category;
    @Column(name = "amount", nullable = false)
    private Integer amount;
    @Column(name = "minimum_stock", nullable = false)
    private Integer minimumStock;
    @Column(name = "available", nullable = false)
    private Integer available;
}

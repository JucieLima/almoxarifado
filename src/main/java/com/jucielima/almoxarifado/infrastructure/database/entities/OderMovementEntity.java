package com.jucielima.almoxarifado.infrastructure.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "order_movement")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OderMovementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type", nullable = false)
    private String type;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private OderEntity order;
    @ManyToOne
    @JoinColumn(name = "storekeeper", referencedColumnName = "id", nullable = false)
    private UserEntity storekeeper;
}

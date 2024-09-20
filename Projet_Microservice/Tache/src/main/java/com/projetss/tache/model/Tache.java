package com.projetss.tache.model;

import com.projetss.tache.model.Enum.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Tache {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String startDate;
    private String endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String resources;
    private Long projetId;
}

package com.projetss.tache.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TacheDto {
    private Long id;
    private String description;
    private String startDate;
    private String endDate;
    private String status;
    private String resources;
    private Long projetId ;
}

package com.projet.mapper;

import com.projet.dto.ProjetDTO;
import com.projet.model.Projet;
import org.springframework.stereotype.Component;

@Component
public class ProjetMapper {

    public ProjetDTO toDto(Projet projet) {
        ProjetDTO dto = new ProjetDTO();
        dto.setId(projet.getId());
        dto.setName(projet.getName());
        dto.setDescription(projet.getDescription());
        dto.setStartDate(projet.getStartDate());
        dto.setEndDate(projet.getEndDate());
        dto.setBudget(projet.getBudget());
        return dto;
    }

    public Projet toEntity(ProjetDTO dto) {
        Projet projet = new Projet();
        projet.setId(dto.getId());
        projet.setName(dto.getName());
        projet.setDescription(dto.getDescription());
        projet.setStartDate(dto.getStartDate());
        projet.setEndDate(dto.getEndDate());
        projet.setBudget(dto.getBudget());
        return projet;
    }
}

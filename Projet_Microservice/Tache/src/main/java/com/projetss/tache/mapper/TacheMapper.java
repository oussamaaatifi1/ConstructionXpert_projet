package com.projetss.tache.mapper;

import com.projetss.tache.dto.TacheDto;
import com.projetss.tache.model.Tache;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TacheMapper {
    TacheMapper INSTANCE = Mappers.getMapper(TacheMapper.class);

    @Mapping(source = "projetId", target = "projetId")
    TacheDto toDTO(Tache tache);

    @Mapping(source = "projetId", target = "projetId")
    Tache toEntity(TacheDto tacheDto);
}

package ressourceservice.mapper;


import org.springframework.stereotype.Component;
import ressourceservice.dto.RessourceDTO;
import ressourceservice.model.Ressource;
import ressourceservice.model.Type;

@Component
public class RessourceMapper {

    public RessourceDTO toDto(Ressource ressource) {
        RessourceDTO dto = new RessourceDTO();
        dto.setIdRessource(ressource.getIdRessource());
        dto.setNomRessource(ressource.getNomRessource());
        dto.setType(ressource.getType().name()); // Enum to String
        dto.setQuantite(ressource.getQuantite());
        dto.setNomFournisseur(ressource.getNomFournisseur());
        dto.setPrenomFournisseur(ressource.getPrenomFournisseur());
        dto.setTele(ressource.getTele());
        dto.setAdresse(ressource.getAdresse());
        dto.setIdTache(ressource.getIdTache());
        return dto;
    }

    public Ressource toEntity(RessourceDTO dto) {
        Ressource ressource = new Ressource();
        ressource.setIdRessource(dto.getIdRessource());
        ressource.setNomRessource(dto.getNomRessource());
        ressource.setType(Enum.valueOf(Type.class, dto.getType())); // Corrected reference to Type
        ressource.setQuantite(dto.getQuantite());
        ressource.setNomFournisseur(dto.getNomFournisseur());
        ressource.setPrenomFournisseur(dto.getPrenomFournisseur());
        ressource.setTele(dto.getTele());
        ressource.setAdresse(dto.getAdresse());
        ressource.setIdTache(dto.getIdTache());
        return ressource;
    }
}


package ressourceservice.dto;

import lombok.Data;

@Data
public class RessourceDTO {
    private int idRessource;
    private String nomRessource;
    private String type;
    private int quantite;
    private String nomFournisseur;
    private String prenomFournisseur;
    private String tele;
    private String adresse;
    private int idTache;
}

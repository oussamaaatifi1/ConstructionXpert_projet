package ressourceservice;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ressourceservice.dto.RessourceDTO;
import ressourceservice.exception.RessourceNotFoundException;
import ressourceservice.mapper.RessourceMapper;
import ressourceservice.model.Ressource;
import ressourceservice.repository.RessourceRepository;
import ressourceservice.service.RessourceService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RessourceServiceTest {

    @InjectMocks
    private RessourceService ressourceService;

    @Mock
    private RessourceRepository ressourceRepository;

    @Mock
    private RessourceMapper ressourceMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddRessource() {
        RessourceDTO ressourceDTO = new RessourceDTO();
        Ressource ressource = new Ressource();
        when(ressourceMapper.toEntity(ressourceDTO)).thenReturn(ressource);
        when(ressourceRepository.save(ressource)).thenReturn(ressource);
        when(ressourceMapper.toDto(ressource)).thenReturn(ressourceDTO);

        RessourceDTO savedRessource = ressourceService.addRessource(ressourceDTO);
        assertNotNull(savedRessource);
        verify(ressourceRepository, times(1)).save(ressource);
    }

    @Test
    void testGetRessourceById() {
        Ressource ressource = new Ressource();
        when(ressourceRepository.findById(1L)).thenReturn(Optional.of(ressource));
        RessourceDTO ressourceDTO = new RessourceDTO();
        when(ressourceMapper.toDto(ressource)).thenReturn(ressourceDTO);

        RessourceDTO foundRessource = ressourceService.getRessourceById(1);
        assertNotNull(foundRessource);
        verify(ressourceRepository, times(1)).findById(1L);
    }

    @Test
    void testGetRessourceByIdNotFound() {
        when(ressourceRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RessourceNotFoundException.class, () -> {
            ressourceService.getRessourceById(1);
        });
    }

    @Test
    void testGetAllRessources() {
        List<Ressource> ressources = Arrays.asList(new Ressource(), new Ressource());
        when(ressourceRepository.findAll()).thenReturn(ressources);
        when(ressourceMapper.toDto(any())).thenReturn(new RessourceDTO());

        List<RessourceDTO> allRessources = ressourceService.getAllRessources();
        assertEquals(2, allRessources.size());
        verify(ressourceRepository, times(1)).findAll();
    }

    @Test
    void testUpdateRessource() {
        Ressource existingRessource = new Ressource();
        RessourceDTO ressourceDTO = new RessourceDTO();
        Ressource updatedRessource = new Ressource();

        when(ressourceRepository.findById(1L)).thenReturn(Optional.of(existingRessource));
        when(ressourceMapper.toEntity(ressourceDTO)).thenReturn(updatedRessource);
        when(ressourceRepository.save(updatedRessource)).thenReturn(updatedRessource);
        when(ressourceMapper.toDto(updatedRessource)).thenReturn(ressourceDTO);

        RessourceDTO result = ressourceService.updateRessource(1, ressourceDTO);
        assertNotNull(result);
        verify(ressourceRepository, times(1)).save(updatedRessource);
    }

    @Test
    void testDeleteRessource() {
        Ressource ressource = new Ressource();
        when(ressourceRepository.findById(1L)).thenReturn(Optional.of(ressource));

        ressourceService.deleteRessource(1);
        verify(ressourceRepository, times(1)).delete(ressource);
    }

    @Test
    void testDeleteRessourceNotFound() {
        when(ressourceRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RessourceNotFoundException.class, () -> {
            ressourceService.deleteRessource(1);
        });
    }
}

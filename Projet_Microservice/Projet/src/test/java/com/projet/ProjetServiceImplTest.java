package com.projet;
import com.projet.dto.ProjetDTO;
import com.projet.mapper.ProjetMapper;
import com.projet.model.Projet;
import com.projet.repository.ProjetRepository;
import com.projet.service.impl.ProjetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProjetServiceImplTest {

    @Mock
    private ProjetRepository projetRepository;

    @Mock
    private ProjetMapper projetMapper;

    @InjectMocks
    private ProjetServiceImpl projetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAjouterProjet() {
        // Arrange
        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setName("Test Projet");
        projetDTO.setDescription("Test Description");
        projetDTO.setBudget(10000);
        projetDTO.setStartDate(LocalDate.of(2023, 9, 1));
        projetDTO.setEndDate(LocalDate.of(2023, 12, 1));

        Projet projet = new Projet();
        when(projetMapper.toEntity(projetDTO)).thenReturn(projet);
        when(projetRepository.save(projet)).thenReturn(projet);

        // Act
        Projet result = projetService.ajouterProjet(projetDTO);

        // Assert
        assertNotNull(result);
        verify(projetRepository, times(1)).save(projet);
    }

    @Test
    void testModifierProjet() {
        // Arrange
        Long projetId = 1L;
        ProjetDTO projetDTO = new ProjetDTO();
        projetDTO.setName("Updated Projet");
        projetDTO.setDescription("Updated Description");
        projetDTO.setBudget(20000);
        projetDTO.setStartDate(LocalDate.of(2023, 9, 1));
        projetDTO.setEndDate(LocalDate.of(2023, 12, 1));

        Projet existingProjet = new Projet();
        existingProjet.setId(projetId);

        when(projetRepository.findById(projetId)).thenReturn(Optional.of(existingProjet));
        when(projetRepository.save(existingProjet)).thenReturn(existingProjet);

        // Act
        Projet result = projetService.modifierProjet(projetId, projetDTO);

        // Assert
        assertNotNull(result);
        assertEquals("Updated Projet", result.getName());
        verify(projetRepository, times(1)).findById(projetId);
        verify(projetRepository, times(1)).save(existingProjet);
    }

    @Test
    void testAllProjets() {
        // Arrange
        Projet projet1 = new Projet();
        Projet projet2 = new Projet();
        List<Projet> projets = Arrays.asList(projet1, projet2);

        when(projetRepository.findAll()).thenReturn(projets);
        when(projetMapper.toDto(projet1)).thenReturn(new ProjetDTO());
        when(projetMapper.toDto(projet2)).thenReturn(new ProjetDTO());

        // Act
        List<ProjetDTO> result = projetService.allProjets();

        // Assert
        assertEquals(2, result.size());
        verify(projetRepository, times(1)).findAll();
    }

    @Test
    void testSupprimerProjet() {
        // Arrange
        Long projetId = 1L;

        // Act
        projetService.supprimerProjet(projetId);

        // Assert
        verify(projetRepository, times(1)).deleteById(projetId);
    }
}
package tn.esprit.rh.achat.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
public class FournisseurServiceTestMockito {
	
	@Mock
	FournisseurRepository fournisseurRepository;
	
	@InjectMocks
	FournisseurServiceImpl fournisseurService;
	
	Fournisseur fournisseur = new Fournisseur("123","Fournisseur_1",CategorieFournisseur.CONVENTIONNE);
	
	
	 @Test
	    public void testFindFournisseur()
	    {
	        Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
	        Fournisseur fournisseur = fournisseurService.retrieveFournisseur(1L);  
	        Assertions.assertNotNull(fournisseur);
	    }

}

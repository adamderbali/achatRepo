package tn.esprit.rh.achat.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

@RunWith(JUnit4.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class ProduitServiceTestMockito {

    
    @Mock
    ProduitRepository produitRepository;
    
    @InjectMocks
    ProduitServiceImpl produitService;
    
    
    Produit produit = new Produit("Code2255","samsung",3000,new Date(),new Date());

    List<Produit> listProduits = new ArrayList<Produit>() {
      {
          add(new Produit("Code2255","samsung10",3000,new Date(),new Date()));
          add(new Produit("Code2255","samsung14",3000,new Date(),new Date()));
      }
    };
    
    @Test
    void testFindProduit()
    {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit p = produitService.retrieveProduit(1L); //produitRepository.findById(1L).get(); 
        Assertions.assertNotNull(p);
    }
}

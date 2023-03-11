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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class ProduitServiceTestMockito {

    
    @Mock
    ProduitRepository produitRepository;
    
    @InjectMocks
    ProduitServiceImpl produitService;
    
    
    Produit produit = new Produit("Code2255","samsung",3000,new Date(),new Date());

    List<Produit> listProduits = new ArrayList<Produit>() {
      {
          add(new Produit("is00","iphone 13",3500,new Date(),new Date()));
          add(new Produit("is00","iphone 14 pro max",5000,new Date(),new Date()));
      }
    };
    
    @Test
    public void testFindProduit()
    {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit p = produitService.retrieveProduit(1L); //produitRepository.findById(1L).get(); 
        Assertions.assertNotNull(p);
    }
}
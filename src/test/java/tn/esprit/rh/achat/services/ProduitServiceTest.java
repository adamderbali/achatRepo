package tn.esprit.rh.achat.services;

import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
class ProduitServiceTest {
  @Autowired
    IProduitService ps;
    
 
    
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
 
    @Test
     void testgetProduit()
    {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit o = produitService.retrieveProduit(1L);
        Assertions.assertNotNull(o);
        log.info("get ===> " + o.toString());
    }
    
    @Test
     void testgetAllProduit()
    {
        Mockito.when(produitRepository.findAll()).thenReturn(listProduits);
        List<Produit> listAllOperateurs = produitService.retrieveAllProduits();
        Assertions.assertEquals(3, listAllOperateurs.size());
    }
    
   
    @Test
     void testDeleteOperateur()
    {
        produitService.deleteProduit(4L);
        Mockito.verify(produitRepository , times(0)).delete(produit);
    }

}

package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProduitServiceTest {

    @Autowired
    IProduitService ps;
    
    @Autowired
    ProduitRepository produitRepository;
    
 
/*
    @Test
    @Order(1)
    public void testRetrieveAllUsers() {
        List<Produit> listProduits = ps.retrieveAllProduits();
        Assertions.assertEquals(0, listProduits.size());
    }
    */
    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("Code1232","iphone",4000,new Date(),new Date());
        ps.addProduit(prod);
        }
    
    @Test
    public void testFindProduit()
    {
        Produit p = ps.retrieveProduit(3L); //produitRepository.findById(1L).get(); 
        System.out.println(p);
    }
    
  /*  @Test
    public void testUpdateProduit()
    {
        Produit p = produitRepository.findById(1L).get();
        p.setCodeProduit("145der");
        //produitRepository.save(p);
        ps.updateProduit(p);
    }*/
    
    @Test
    public void testDeleteProduit()
    {
        produitRepository.deleteById(4L);;
    }
     
    @Test
    public void testListerTousProduits()
    {
        List<Produit> Produits = (List<Produit>) produitRepository.findAll();
        for (Produit c : Produits)
            {
                System.out.println(c);
            }
    }


}

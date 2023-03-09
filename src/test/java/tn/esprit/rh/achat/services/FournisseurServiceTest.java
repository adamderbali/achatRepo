package tn.esprit.rh.achat.services;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FournisseurServiceTest {
	
	@Autowired
	IFournisseurService iFournisseurService;
	
	Fournisseur fournisseur = new Fournisseur("123","Fournisseur_1",CategorieFournisseur.CONVENTIONNE);
	
	 @Test
	    @Order(1)
	    public void testRetrieveAllFournisseurs() {
	        List<Fournisseur> listFournisseurs = iFournisseurService.retrieveAllFournisseurs();
	        Assertions.assertEquals(0, listFournisseurs.size());
	    }
	 
	 @Test
	    @Order(2)
	    public void testAddFournisseurs() {
		    
		    Fournisseur newFournisseur=iFournisseurService.addFournisseur(fournisseur); 
	        Assertions.assertNotNull(newFournisseur.getIdFournisseur());
	    }

}

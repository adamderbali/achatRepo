package tn.esprit.rh.achat.services;


import java.util.List;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;



@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OperateurServiceTest {
/*
	@Autowired
    IOperateurService op;
    OperateurRepository opRepo;
	
	@Test
	@Order(1)
	public void testRetrieveAllOperateurs() {
		List<Operateur> listOperateurs = op.retrieveAllOperateurs();
	    Assertions.assertEquals(0, listOperateurs.size());
	}

    @Test
	@Order(2)
	public void testAddOperateur() {
		Operateur operateur = new Operateur("Fridhi","Ghada", "4Info_BI");
		Operateur operateurAdded = op.addOperateur(operateur);
		Assertions.assertEquals(operateur.getNom(), operateurAdded.getNom());
		
	}

   
    @Test
	@Order(3)
	public void testUpdateOperateur() {
    	Operateur operateur = opRepo.findById(1L).get();
    	operateur.setPrenom("operateurGhada");
    	op.updateOperateur(operateur);
    	Assertions.assertEquals(operateur.getPrenom(), operateur.getPrenom());
	}

    @Test
	@Order(4)
	public void testRetrieveOperateur() {
    	Operateur operRetrived = op.retrieveOperateur(1L);
    	Assertions.assertEquals(1L, operRetrived.getIdOperateur());
    	
	}
    @Test
	@Order(5)
  	public void testDeleteOperateur() {
          op.deleteOperateur(1L);
          Assertions.assertNull(op.retrieveOperateur(1L));
          
  		
  	}
  */
}

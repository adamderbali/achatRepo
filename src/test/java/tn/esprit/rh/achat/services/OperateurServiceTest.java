package tn.esprit.rh.achat.services;


import static org.mockito.Mockito.times;

import java.util.ArrayList;
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

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;




@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
public class OperateurServiceTest {
	
	@Mock
    OperateurRepository operateurRepository;
	
	@InjectMocks
	OperateurServiceImpl operateurService;
	
	
	Operateur operateur = new Operateur("Fridhi","Ghada", "4Info_BI");
	Operateur operateur1 = new Operateur("Fridhi","Ghada2", "4Info_BI");
	
	List<Operateur> listOperateurs = new ArrayList<Operateur>(){
		{
		   add(operateur);
		   add(new Operateur("Fridhi", "Wael", "Info-30"));
		   add(new Operateur("Fouleni", "Flen", "Info-65"));
	   
		}
	};

	@Test
	public void testgetOperateur()
	{
		Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
		Operateur o = operateurService.retrieveOperateur(1L);
		Assertions.assertNotNull(o);
		log.info("get ===> " + o.toString());
	}
	
	@Test
	public void testgetAllOperateurs()
	{
		Mockito.when(operateurRepository.findAll()).thenReturn(listOperateurs);
		List<Operateur> listAllOperateurs = operateurService.retrieveAllOperateurs();
		Assertions.assertEquals(3, listAllOperateurs.size());
	}
	
	@Test
	public void testAddOperateur()
	{
		Mockito.when(operateurRepository.save(operateur1)).thenReturn(operateur1);
		Operateur o1 = operateurService.addOperateur(operateur1);
		Mockito.verify(operateurRepository , times(1)).save(Mockito.any(Operateur.class));
		Assertions.assertNotNull(o1);
	}
	
	@Test
	public void testDeleteOperateur()
	{
		operateurService.deleteOperateur(4L);
		Mockito.verify(operateurRepository , times(0)).delete(operateur);
	}
}

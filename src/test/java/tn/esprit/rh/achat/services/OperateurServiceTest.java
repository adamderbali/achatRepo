package tn.esprit.rh.achat.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
public class OperateurServiceTest {
	
	@Mock
    OperateurRepository operateurRepository;
	
	@InjectMocks
	OperateurServiceImpl operateurService;
	
	
	Operateur operateur = new Operateur("Fridhi","Ghada", "4Info_BI");
	
	List<Operateur> listOperateurs = new ArrayList<Operateur>() {
		{
		   add(new Operateur("Fridhi", "Wael", "Info-30"));
		   add(new Operateur("Fouleni", "Flen", "Info-65"));
	   
		}
	};

	@Test
	public void getOperateurByIdTest()
	{
		Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));

		Operateur operat = operateurService.retrieveOperateur(1L);
		assertNotNull(operat);
		verify(operateurRepository).findById(Mockito.anyLong());
	}
}

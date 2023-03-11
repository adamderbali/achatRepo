package tn.esprit.rh.achat.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.hibernate.mapping.Array;
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
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
public class FactureServiceTestMockito {


	    @Mock
	    FactureRepository factureRepository;

	    @InjectMocks
	    FactureServiceImpl factureServiceImpl;

	    Facture facture = new Facture(0L, 0, 600, new Date(), new Date(), false, null, null, null);

	    @Test
	    public void testFindProduit()
	    {
	        Mockito.when(factureRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(facture));
	        Facture f = factureServiceImpl.retrieveFacture(1L);
	        Assertions.assertNotNull(f);
	    }

}
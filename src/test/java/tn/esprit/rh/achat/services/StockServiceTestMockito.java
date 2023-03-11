package tn.esprit.rh.achat.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;


@RunWith(JUnit4.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
@Slf4j
public class StockServiceTestMockito {

	@Mock
	StockRepository stockRepository;
	
	@InjectMocks
	StockServiceImpl stockService;
	
	Stock stock = new Stock("StockProd1",300,50);
	
	
	 @Test
	    public void testFindStock()
	    {
	        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
	        Stock stock = stockService.retrieveStock(1L);  
	        Assertions.assertNotNull(stock);
	    }
}

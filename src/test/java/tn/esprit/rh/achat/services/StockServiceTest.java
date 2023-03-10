package tn.esprit.rh.achat.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockServiceTest {
/*
	@Autowired
	IStockService iStockService;
	
	Stock stock = new Stock("StockProd1",300,50);
	
	 @Test
	    @Order(1)
	    public void testRetrieveAllStocks() {
	        List<Stock> listStocks = iStockService.retrieveAllStocks();
	        Assertions.assertEquals(0, listStocks.size());
	    }
	 
	 @Test
	    @Order(2)
	    public void testAddStock() {
		    
		    Stock newStock=iStockService.addStock(stock); 
	        Assertions.assertNotNull(newStock.getIdStock());
	    }
	    */
}

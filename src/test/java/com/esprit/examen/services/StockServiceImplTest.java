package com.esprit.examen.services;

import static org.junit.Assert.*;

import com.esprit.examen.repositories.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.esprit.examen.entities.Stock;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
@ExtendWith(MockitoExtension.class)

@MockitoSettings(strictness = Strictness.LENIENT)

public class StockServiceImplTest {
    @Mock
    StockRepository sto;
	@InjectMocks
	StockServiceImpl stockService;
	
	@Test
	public void testAddStock() {

		Stock s = new Stock("stock test",10,100);
        Mockito.when(sto.save(ArgumentMatchers.any(Stock.class))).thenReturn(s);
		Stock savedStock= stockService.addStock(s);

		assertNotNull(savedStock.getLibelleStock());
		assertNotNull(savedStock.getIdStock());
		assertSame(10, savedStock.getQte());
		assertTrue(savedStock.getQteMin()>0);

		stockService.deleteStock(savedStock.getIdStock());
		
	} 

	@Test
	public void testDeleteStock() {
		Stock s = new Stock("stock test",30,60);
		s.setIdStock(Long.valueOf(100));
		stockService.deleteStock(s.getIdStock());
		assertNull(stockService.retrieveStock(s.getIdStock()));
	}

}

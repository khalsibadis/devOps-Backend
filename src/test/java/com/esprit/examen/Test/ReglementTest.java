package com.esprit.examen.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.DetailFactureRepository;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.ReglementRepository;
import com.esprit.examen.services.ReglementServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ReglementTest {

	@InjectMocks
	ReglementServiceImpl reglementServiceImpl ;
	
	@Mock
	FactureRepository factureRepository;
	@Mock
	OperateurRepository operateurRepository;
	@Mock
	DetailFactureRepository detailFactureRepository;
	@Mock
	FournisseurRepository fournisseurRepository;
	@Mock
	ProduitRepository produitRepository;
	//@Mock
    //ReglementServiceImpl reglementService;
	@Mock
	ReglementRepository reglementRepository;
	

	@Test
	void test_retrieveAllReglements_ok() {
		
		when(reglementRepository.findAll()).thenReturn(new ArrayList());
		List<Reglement> response= reglementServiceImpl.retrieveAllReglements();
		assertEquals(0, response.size());
	}
	
	@Test
	void test_addReglement_ok() {
		Reglement r= new Reglement();
		r.setIdReglement(1L);
		//mock
		when(reglementRepository.save(any())).thenReturn(r);	
		//call function 
		reglementServiceImpl.addReglement(new Reglement());
		
		//assert
		assertEquals(1L, r.getIdReglement());
		}
	
}

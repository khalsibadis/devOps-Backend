package com.esprit.examen.repositories;

import java.util.Date;
import java.util.List;

import com.esprit.examen.services.IProduitService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.esprit.examen.entities.Produit;

@Repository
public interface  ProduitRepository extends JpaRepository<Produit, Long> {

    @Query("SELECT sum(df.prixTotal) FROM DetailFacture df where df.produit=:produit and df.facture.dateFacture between :startDate"
			+ " and :endDate and df.facture.active=true")
	List<Produit> retrieveAllProduit(@Param("idProduit") Long idProduit);

	public float getRevenuBrutProduit(@Param("produit") Produit produit, @Param("startDate") Date startDate,
			@Param("endDate") Date endDate);

}

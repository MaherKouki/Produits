package com.maher.produit.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maher.produit.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}

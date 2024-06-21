package com.maher.produit.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maher.produit.entities.Produit;
import com.maher.produit.service.ProduitService;

public class ProduitController {
	
	@Autowired
	ProduitService produitService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createProduit";
	}
	
	
	  
	@RequestMapping("/saveProduit")
	public String saveProduit(@ModelAttribute("produit") Produit produit,
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException
	{
	//conversion de la date
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	Date dateCreation = dateformat.parse(String.valueOf(date)); produit.setDateCreation(dateCreation);
	Produit saveProduit = produitService.saveProduit(produit);
	String msg ="produit enregistré avec Id "+saveProduit.getIdProduit();
	modelMap.addAttribute("msg", msg);
	return "createProduit";
	}

}

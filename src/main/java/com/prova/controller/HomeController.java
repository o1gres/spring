package com.prova.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prova.model.Utenti;
import com.prova.repository.RecipeRepositoryInterface;
import com.prova.services.UtentiService;

/**
 * Handles requests for the application home page.
 */
//@SpringBootApplication
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) 
	{
		logger.info("Welcome home! The client locale is {}.", locale);
		
		
		UtentiService utentiService = new UtentiService();
		
		//Sesso if maschio set true
//		Utenti utente1 = new Utenti(1, "Mario", 25, 1);
//		Utenti utente2 = new Utenti(2, "Rossa", 18, 1);
//		
//		utentiService.persist(utente1);
//		utentiService.persist(utente2);

		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("utentiString", "Nel Db sono presenti i seguenti Utenti");
		
		List<Utenti> utentiList = utentiService.findAll();
		model.addAttribute("utentiList", utentiList);

		return "home";
	}
	
}

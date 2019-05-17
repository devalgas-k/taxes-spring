package org.dave.myTaxes;

import java.util.Date;

import org.dave.myTaxes.dao.EntrepriseRepository;
import org.dave.myTaxes.dao.TaxeRepository;
import org.dave.myTaxes.entities.Entreprise;
import org.dave.myTaxes.entities.IR;
import org.dave.myTaxes.entities.TVA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTaxesApplication implements CommandLineRunner {

	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Autowired
	private TaxeRepository taxeRepository;
	public static void main(String[] args) {
		SpringApplication.run(MyTaxesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Entreprise e1 = entrepriseRepository.save(
				new Entreprise("Hytechs","hytechs@gmail.com","sarl"));
		Entreprise e2 = entrepriseRepository.save(
				new Entreprise("Innovatech","innovatech@gmail.com","sa"));
		taxeRepository.save(
				new TVA("Tva Logement",new Date(),8000,e1));
		taxeRepository.save(
				new TVA("Tva Logement",new Date(),8000,e2));
		taxeRepository.save(
				new TVA("Tva Automobile",new Date(),5000,e1));
		taxeRepository.save(
				new TVA("Tva Automobile",new Date(),5000,e2));
		taxeRepository.save(
				new IR("IR 2016",new Date(),15000,e1));
		taxeRepository.save(
				new IR("IR 2016",new Date(),15000,e2));
		taxeRepository.save(
				new IR("IR 2016",new Date(),16000,e1));
		taxeRepository.save(
				new IR("IR 2017",new Date(),16000,e2));
		*/
		
		
		
	}
}

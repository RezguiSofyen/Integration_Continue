package tn.esprit.spring;


import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IDepartementService;

public class DepartementTest {
	Entreprise entreprise=new Entreprise();
	Departement departement = new Departement(1,"Departement1",entreprise);
	
	IDepartementService us;
	
	@Test
	public void testegaliterID(){
		
		Assert.assertEquals(1, departement.getId());
		
	}

	@Test
	public void testegaliterName(){
		Assert.assertEquals("Departement1" , departement.getName());
		
	}
	
	@Test
	public void TestajoutDep() throws ParseException {
		
		String typeDepartement="INFO";
		Entreprise  entreprise=new Entreprise("Sopra", "raisonSocial");
		Departement d = new Departement(1,typeDepartement,entreprise); 
		Departement d2 = new Departement(2,typeDepartement,entreprise);
	//	us.ajoutDep(d);
	//	us.ajoutDep(d2);
		Assert.assertEquals(d.getId(),d2.getId());
		
	}
	
	
}

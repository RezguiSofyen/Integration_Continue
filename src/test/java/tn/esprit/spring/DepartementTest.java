package tn.esprit.spring;


import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;

import tn.esprit.spring.entities.Departement;

import tn.esprit.spring.entities.Entreprise;

public class DepartementTest {
	Entreprise entreprise=new Entreprise();
	Departement departement = new Departement(1,"Departement1",entreprise);
	
	@Test
	public void testegaliterID(){
		Assert.assertEquals(1, departement.getId());
		
	}

	@Test
	public void testegaliterName(){
		Assert.assertEquals("Departement1" , departement.getName());
		
	}
	
	@Test
	public void TestaddOrUpdateCont() throws ParseException {
		
		String typeDepartement="INFO";
		Entreprise  entreprise=new Entreprise("Sopra", "raisonSocial");
		Departement d = new Departement(1,typeDepartement,entreprise); 
		Departement d2 = new Departement(2,typeDepartement,entreprise);
		Assert.assertEquals(d.getId(),d2.getId());	
	}
	
	
}

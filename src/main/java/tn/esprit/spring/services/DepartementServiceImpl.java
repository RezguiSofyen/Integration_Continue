package tn.esprit.spring.services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;


@Service
public class DepartementServiceImpl implements IDepartementService {
	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);

	@Autowired
	DepartementRepository departementRepository;

	public List<Departement> getAllDepartement() {
		l.info("In  retrieveAllContrats : ");
		List<Departement> listCont = (List<Departement>) departementRepository.findAll();
		for (Departement cont : listCont) {
			l.debug("Departement  : " + cont);
		}
		l.info(" tout le département trouver");
		return listCont;
	}
	@Override

	public Departement addOrUpdateCont(Departement d) {
		l.info("in add cont : " + d);
		Departement cont = departementRepository.save(d);
		l.info(d + "département modifié");
		return cont;
	}

	@Override
	public void deleteDepartementById(int depId) {
		l.info("delted contrat id : " + depId);
		departementRepository.delete(departementRepository.findById(depId).get());

	}
	@Override
	public List<Departement> getAllDepartements() {
		// TODO Auto-generated method stub
		return null;
	}

}
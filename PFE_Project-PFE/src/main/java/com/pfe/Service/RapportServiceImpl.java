package com.pfe.Service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Model.Rapport;
import com.pfe.Repository.RapportRepository;

@Service
public class RapportServiceImpl implements IRapportService {
	
	@Autowired private RapportRepository rapportRepository;

	@Override
	public void updateRapport(Rapport rapport, Integer idRapport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRapportId(Integer idRapport) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rapport save(Rapport rapport) {
		if (rapport.getIdRapport() != null && rapportRepository.existsById(rapport.getIdRapport())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
 
		return rapportRepository.save(rapport);
	}

	@Override
	public List<Rapport> getAllRapports() {
		// TODO Auto-generated method stub
		return rapportRepository.findAll();
	}

}

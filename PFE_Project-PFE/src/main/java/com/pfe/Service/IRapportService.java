package com.pfe.Service;

import java.util.List;

import com.pfe.Model.Rapport;

public interface IRapportService {
	void updateRapport(Rapport rapport, Integer idRapport);

	void deleteRapportId(Integer idRapport);

	Rapport save(Rapport rapport);
	
	List<Rapport> getAllRapports();

}

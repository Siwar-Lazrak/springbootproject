package com.pfe.Service;
import java.util.List;
import com.pfe.Model.SousModule;


public interface ISousModuleService {
	
	void updateSousModul(SousModule sousModule, Integer idSousModule);

	void deleteSousModuleById(Integer idSousModule);

	SousModule save(SousModule sousmodul);
	
	List<SousModule> getAllSousModules();

	
	
	

}

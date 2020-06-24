package com.pfe.Service;

import java.util.List;

import javax.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pfe.Model.SousModule;
import com.pfe.Repository.ModuleRepository;
import com.pfe.Repository.SousModuleRepository;




@Service
public class SousmoduleServiceImpl implements ISousModuleService{
	
	@Autowired private SousModuleRepository sousModuleREpository;
	@Autowired ModuleRepository moduleRepository;

   
	@Override
	public void updateSousModul(SousModule sousModule, Integer idSousModule) {
		
		sousModuleREpository.save(sousModule);
		
	}

	
	  @Override public void deleteSousModuleById(Integer idSousModule) {
	  
	  sousModuleREpository.deleteById(idSousModule);
	  
	  }
	  
	
	 
	@Override
		public SousModule save(SousModule sousModul){
			if (sousModul.getIdSousModule() != null && sousModuleREpository.existsById(sousModul.getIdSousModule())) {
				throw new EntityExistsException("There is already existing entity with such ID in the database.");
			}
	 
			return sousModuleREpository.save(sousModul);
		}



			@Override
			public List<SousModule> getAllSousModules() {
				return sousModuleREpository.findAll();
			}


			






	

	




}

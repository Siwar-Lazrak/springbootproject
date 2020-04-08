package com.pfe.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Model.Module;
import com.pfe.Repository.ModuleRepository;

@Service
public class ModuleServiceImpl implements IModuleService {
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@Override
	public List<Module> getAllModule() {
		return moduleRepository.findAll();
	}

	@Override
	public Module getModuleById(Integer idModule) {
		
		return moduleRepository.getOne(idModule);
	}

	@Override
	public void addModule(Module module) {
		moduleRepository.save(module);
		
	}

	@Override
	public void updateModule(Module module, Integer idModule) {
		moduleRepository.save(module);
	}

	@Override
	public void deleteModule(Integer idModule) {
		moduleRepository.deleteById(idModule);
		
	}

	

}

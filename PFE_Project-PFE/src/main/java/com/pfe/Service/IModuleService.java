package com.pfe.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pfe.Model.Module;

@Service("mdouleService")
public interface IModuleService {
	
	List<Module> getAllModule();
	
	Module getModuleById(Integer idModule);
	
	void addModule(Module module);
	
	void updateModule(Module module, Integer idModule);
	
	void deleteModule(Integer idModule);
	

}

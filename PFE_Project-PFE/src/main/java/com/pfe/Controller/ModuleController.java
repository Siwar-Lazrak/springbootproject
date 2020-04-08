package com.pfe.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.relation.RelationNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.Model.Module;
import com.pfe.Model.Rapport;
import com.pfe.Model.SousModule;
import com.pfe.Model.User;
import com.pfe.Model.UserAccess;
import com.pfe.Repository.ModuleRepository;
import com.pfe.Repository.RapportRepository;
import com.pfe.Repository.SousModuleRepository;
import com.pfe.Repository.UserAccessRepository;
import com.pfe.Repository.UserRepository;

import com.pfe.Service.IModuleService;
import com.pfe.Service.IRapportService;
import com.pfe.Service.ISousModuleService;
import com.pfe.Service.IUserAccessService;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class ModuleController {
	


	    @Autowired IModuleService mdouleService;
	
	   	@Autowired ISousModuleService sousmoduleService;

		@Autowired UserRepository userRepository;
		
		@Autowired ModuleRepository moduleRepository;
		
		@Autowired SousModuleRepository sousmoduleRepository;
		
		@Autowired IUserAccessService useraccessSevice;
		
		@Autowired UserAccessRepository useraccessRepository;
		
		@Autowired IRapportService rapportService;
		
		@Autowired RapportRepository rapportRepository;
		
		
		  @GetMapping("/getAllModuls")
		  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		  public ResponseEntity<List<Module>> getAllModuls(@RequestParam(required = false) String nom) {
		    try {
		      List<Module> moduls = new ArrayList<Module>();

		      if (nom == null)
		        moduleRepository.findAll().forEach(moduls::add);
		      else
		        moduleRepository.findByNomContaining(nom).forEach(moduls::add);

		      if (moduls.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }

		      return new ResponseEntity<>(moduls, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		  }
		  
		  
		  	@GetMapping("/getModuleId/{id}")
		  	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
			 Module getModuleId(@PathVariable Integer id) {
			 
			    return moduleRepository.findById(id).get();
			  }
		  
		 
		  
		  @PostMapping("/modul")
		  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		  public ResponseEntity<Module> createModul(@RequestBody Module module) {
		    try {
		      Module _module = moduleRepository
		          .save(new Module( module.getNom(), module.getDescription()));
		      return new ResponseEntity<>(_module, HttpStatus.CREATED);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		    }
		  }
		  
		    @PutMapping("/updateModule/{idModule}")
		    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		  public ResponseEntity<Module> updateModule(@PathVariable("idModule") Integer idModule, @RequestBody Module modul) {
		    Optional<Module> moduleData = moduleRepository.findById(idModule);

		    if (moduleData.isPresent()) {
		      Module _module = moduleData.get();
		      _module.setNom(modul.getNom());
		      _module.setDescription(modul.getDescription());
		     
		      return new ResponseEntity<>(moduleRepository.save(_module), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		  }
		  
		  @DeleteMapping("/deleteModule/{id}")
		  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		  public ResponseEntity<HttpStatus> deleteModule(@PathVariable("id") Integer id) {
		    try {
		      moduleRepository.deleteById(id);
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    } catch (Exception e) {
		      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		    }
		  }
		  
		  
		  //sousmodule
		  
		  @PostMapping("/createSousmodule/{idModule}")
		  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
			public ResponseEntity<?> createSousmodule(@PathVariable(value = "idModule") Integer idModule,
			         @Valid @RequestBody SousModule sousmodule) {
			  
			  Optional<Module> module = moduleRepository.findById(idModule);
			  
			  if(module.isPresent()) {
				  sousmodule.setModule(module.get());
			  }
				return new ResponseEntity<>(sousmoduleRepository.save(sousmodule), HttpStatus.CREATED);
			}

	
		
	
	
	  @GetMapping("/getSousmoduleByModule/{idModule}")
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  public List <SousModule> getSousmoduleByModule(@PathVariable(value = "idModule") Integer idModule) {
		  return sousmoduleRepository.findByModuleIdModule(idModule);
	  
	  }
	 
		  
		  @GetMapping("/getAllSousmodule")
		  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
			public List<SousModule> getAllSousmodule() {
				return sousmoduleService.getAllSousModules();
			}
		  
//		   probleme ne peut pas le supprimer car c'est un clé etranger
		  @DeleteMapping("/deleteSousmodule/{idSousModule}")
		  @PreAuthorize("hasRole('ADMIN')")
			public ResponseEntity<Void> deleteSousmodule(@PathVariable Integer idSousModule) {
				sousmoduleService.deleteSousModuleById(idSousModule);
		 
				return ResponseEntity.ok().build();
			}
		  
		  @PutMapping("{idModule}/update/{idSousModule}")
		  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		  public SousModule update(@PathVariable(value = "idModule") Integer idModule,
			        @PathVariable(value = "idSousModule") Integer idSousModule, @Valid @RequestBody SousModule sousmoduleRequest)
			    throws RelationNotFoundException {

			        return sousmoduleRepository.findById(idSousModule).map(sousmodule -> {
			        	sousmodule.setNomSousModule(sousmoduleRequest.getNomSousModule());
			        	sousmodule.setDescriptionSousModule(sousmoduleRequest.getDescriptionSousModule());
			            return sousmoduleRepository.save(sousmodule);
			        }).orElseThrow();
		  }
			    
//		partie access
	
	  
		  
	  @PostMapping("/createuseraccess/{userId}/{idSousModule}")
		public ResponseEntity<?> createuseraccess(@PathVariable(value = "userId") Integer userId, @PathVariable(value = "idSousModule") Integer idSousModule,
		         @Valid @RequestBody UserAccess useraccess) {
		 	  
		  Optional<SousModule> sousModule=sousmoduleRepository.findById(idSousModule);
		  Optional<User> user=userRepository.findById(userId);
		  
		  if(sousModule.isPresent() && user.isPresent()) {
			  useraccess.setSousmodule(sousModule.get());
			  useraccess.setUser(user.get());
		  }
			return new ResponseEntity<>(useraccessRepository.save(useraccess), HttpStatus.CREATED);
		}
	
	  @GetMapping("/getAllAccess")
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  public List<UserAccess> getAllAccess() {
		  return useraccessRepository.findAll(); 
	  }
	 
//		partie rapport
	  
	  @GetMapping("/getAllRapport")
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		public List<Rapport> getAllRapport() {
			return rapportService.getAllRapports();
		}
	  
	  @PostMapping("/createRapport/{idSousModule}")
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		public ResponseEntity<?> createRapport(@PathVariable(value = "idSousModule") Integer idSousModule,
		         @Valid @RequestBody Rapport rapport) {
		  
		  Optional<SousModule> sousmodule = sousmoduleRepository.findById(idSousModule);
		  
		  if(sousmodule.isPresent()) {
			  rapport.setSousmodule(sousmodule.get());
		  }
			return new ResponseEntity<>(rapportRepository.save(rapport), HttpStatus.CREATED);
		}
	  
}


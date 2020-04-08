package com.pfe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {
		List<Module> findByNom(String nom);
		
	    List<Module> findByNomContaining(String nom);


}

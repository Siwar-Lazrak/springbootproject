package com.pfe.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pfe.Model.SousModule;

@Repository
public interface SousModuleRepository extends JpaRepository<SousModule, Integer>{
	

	
}

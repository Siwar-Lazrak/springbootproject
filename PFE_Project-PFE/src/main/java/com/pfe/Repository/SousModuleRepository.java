package com.pfe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pfe.Model.SousModule;

@Repository
public interface SousModuleRepository extends JpaRepository<SousModule, Integer>{
	

	
}

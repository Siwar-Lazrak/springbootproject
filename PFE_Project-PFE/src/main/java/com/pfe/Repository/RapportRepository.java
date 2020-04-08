package com.pfe.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pfe.Model.Rapport;

@Repository
public interface RapportRepository  extends JpaRepository<Rapport, Integer> {
	
	//	List <Rapport> findByIdSousmodule(@Param("idSousModule") Integer idSousModule );
		
	

}

package com.pfe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfe.Model.Yabscisse;

@Repository
public interface YabscisseRepository extends JpaRepository<Yabscisse, Integer>{

	List<Yabscisse> findAllByIdY(Integer idY);
	
	List <Yabscisse> findByXabscisseIdX(@Param("idX") Integer idX); 

}

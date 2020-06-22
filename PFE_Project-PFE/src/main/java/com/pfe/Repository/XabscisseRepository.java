package com.pfe.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pfe.Model.Xabscisse;


@Repository
public interface XabscisseRepository extends JpaRepository<Xabscisse, Integer> {
	List <Xabscisse> findByRapportIdRapport(@Param("idRapport") Integer idRapport);
	List<Xabscisse> findAllByIdX(Integer idX);


}

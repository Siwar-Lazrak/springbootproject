package com.pfe.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pfe.Model.Xabscisse;

@Repository
public interface XabscisseRepository extends JpaRepository<Xabscisse, Integer> {

}

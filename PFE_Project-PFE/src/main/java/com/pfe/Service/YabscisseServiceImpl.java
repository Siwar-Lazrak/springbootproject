package com.pfe.Service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Model.Yabscisse;
import com.pfe.Repository.YabscisseRepository;

@Service
public class YabscisseServiceImpl implements IYabscisseService {
	
	@Autowired private YabscisseRepository yabscisseRepository;


	@Override
	public void updatetYabscisse(Yabscisse Yabscisse, Integer idY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteYabscisseId(Integer idY) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Yabscisse save(Yabscisse yabscisse) {
		if (yabscisse.getIdY() != null && yabscisseRepository.existsById(yabscisse.getIdY())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
 
		return yabscisseRepository.save(yabscisse);
	}

	@Override
	public List<Yabscisse> getAllYabscisse() {
		// TODO Auto-generated method stub
		return yabscisseRepository.findAll();
	}

}

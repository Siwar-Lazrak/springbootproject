package com.pfe.Service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.Model.Xabscisse;
import com.pfe.Repository.XabscisseRepository;

@Service
public class XabscisseServiceImpl implements IXabscisseService {
	
	@Autowired private XabscisseRepository xabscisseRepository;

	@Override
	public void updatetXabscisse(Xabscisse xabscisse, Integer id_X) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteXabscisseId(Integer id_X) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Xabscisse save(Xabscisse xabscisse) {
		if (xabscisse.getId_X() != null && xabscisseRepository.existsById(xabscisse.getId_X())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
 
		return xabscisseRepository.save(xabscisse);
	}

	@Override
	public List<Xabscisse> getAllXabscisse() {
		// TODO Auto-generated method stub
		return xabscisseRepository.findAll();
	}

}

package com.pfe.Service;

import java.util.List;

import com.pfe.Model.Xabscisse;

public interface IXabscisseService {
	
	void updatetXabscisse(Xabscisse xabscisse, Integer id_X);

	void deleteXabscisseId(Integer id_X);

	Xabscisse save(Xabscisse xabscisse);
	
	List<Xabscisse> getAllXabscisse();

}

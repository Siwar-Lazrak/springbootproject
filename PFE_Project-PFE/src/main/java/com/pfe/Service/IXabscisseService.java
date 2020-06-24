package com.pfe.Service;

import java.util.List;

import com.pfe.Model.Xabscisse;

public interface IXabscisseService {
	
	void updatetXabscisse(Xabscisse xabscisse, Integer idX);

	void deleteXabscisseId(Integer idX);

	Xabscisse save(Xabscisse xabscisse);
	
	List<Xabscisse> getAllXabscisse();


}

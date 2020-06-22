package com.pfe.Service;

import java.util.List;

import com.pfe.Model.Yabscisse;

public interface IYabscisseService {
	void updatetYabscisse(Yabscisse Yabscisse, Integer idY);

	void deleteYabscisseId(Integer idY);

	Yabscisse save(Yabscisse yabscisse);
	
	List<Yabscisse> getAllYabscisse();

}

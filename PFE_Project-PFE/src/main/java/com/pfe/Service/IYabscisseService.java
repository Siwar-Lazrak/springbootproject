package com.pfe.Service;

import java.util.List;

import com.pfe.Model.Yabscisse;

public interface IYabscisseService {
	void updatetYabscisse(Yabscisse Yabscisse, Integer id_Y);

	void deleteYabscisseId(Integer id_Y);

	Yabscisse save(Yabscisse yabscisse);
	
	List<Yabscisse> getAllYabscisse();

}

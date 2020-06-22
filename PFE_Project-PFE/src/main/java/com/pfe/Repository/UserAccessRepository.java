package com.pfe.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pfe.Model.SousModule;
import com.pfe.Model.UserAccess;

public interface UserAccessRepository extends JpaRepository<UserAccess, Integer> {
		
	List<UserAccess> findByUserId(Integer userId);
	List<UserAccess> findBySousmodule(SousModule sousmodule);

	
	

	



}

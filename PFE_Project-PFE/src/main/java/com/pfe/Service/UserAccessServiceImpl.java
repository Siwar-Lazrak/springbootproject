package com.pfe.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pfe.Model.UserAccess;
import com.pfe.Repository.UserAccessRepository;

@Service
public class UserAccessServiceImpl implements IUserAccessService  {
	
	@Autowired private UserAccessRepository useraccessRepository;
	
	@Override
	public UserAccess save(UserAccess useraccess) {
		return useraccessRepository.save(useraccess);
	}
	
	
	 
	
}




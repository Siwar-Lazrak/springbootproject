package com.pfe.Service.mapper;

import org.mapstruct.Mapper;

import com.pfe.Model.User;



@Mapper(componentModel = "spring")
public interface UserMapper {
	UserModel toModel(User user);
	User toEntity(UserModel userModel);

}

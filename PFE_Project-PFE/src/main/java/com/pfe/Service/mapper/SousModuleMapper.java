package com.pfe.Service.mapper;

import org.mapstruct.Mapper;

import com.pfe.Model.SousModule;

@Mapper(componentModel = "spring")
public interface SousModuleMapper {
	
	SousmoduleModel toModel(SousModule sousmodule);
	SousModule toEntity(SousmoduleModel sousmodule);

}

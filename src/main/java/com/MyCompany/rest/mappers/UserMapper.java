package com.MyCompany.rest.mappers;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.MyCompany.rest.dtos.UserMsDtos;
import com.MyCompany.rest.entities.User;

@Mapper(componentModel="Spring")
public interface UserMapper {

	
	
	UserMapper INSTANCE=Mappers.getMapper(UserMapper.class);
	
	// User toUserMSDto
	
	@Mappings({@Mapping(source="email",target="emailaddress"),
	@Mapping(source="role",target="rolename")})
	UserMsDtos UsertoUserDto(User user);
	
	// List<User> to List<UserMsDto>
	
	List<UserMsDtos> UsertoUserDtos(List<User> users);
	
}

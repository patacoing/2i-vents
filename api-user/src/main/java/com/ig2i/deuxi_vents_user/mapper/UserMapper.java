package com.ig2i.deuxi_vents_user.mapper;

import com.ig2i.deuxi_vents_user.dto.UserDto;
import com.ig2i.deuxi_vents_user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto fromUser(User user);
}

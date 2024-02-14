package magazin.demo.mapper;

import magazin.demo.dto.UserDTO;
import magazin.demo.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "monitors", ignore = true)
    @Mapping(target = "hardDisks", ignore = true)
    @Mapping(target = "desktopComputers", ignore = true)
    @Mapping(target = "laptops", ignore = true)
    UserEntity userDtoToUserEntity(UserDTO userDTO);

    UserDTO userEntityToUserDTO(UserEntity userEntity);
}
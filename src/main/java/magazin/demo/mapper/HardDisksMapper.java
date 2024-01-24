package magazin.demo.mapper;

import magazin.demo.dto.HardDisksDTO;
import magazin.demo.entity.HardDisksEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HardDisksMapper {

    HardDisksMapper INSTANCE = Mappers.getMapper(HardDisksMapper.class);

    @Mapping(target = "id", ignore = true)
    HardDisksDTO entityToDto(HardDisksEntity entity);

    @Mapping(target = "id", ignore = true)
    HardDisksEntity dtoToEntity(HardDisksDTO dto);
}

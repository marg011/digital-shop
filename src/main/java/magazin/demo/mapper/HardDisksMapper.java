package magazin.demo.mapper;

import magazin.demo.dto.HardDisksDTO;
import magazin.demo.entity.HardDiskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HardDisksMapper {

    HardDisksMapper INSTANCE = Mappers.getMapper(HardDisksMapper.class);

    @Mapping(target = "id", ignore = true)
    HardDisksDTO entityToDto(HardDiskEntity entity);

    @Mapping(target = "id", ignore = true)
    HardDiskEntity dtoToEntity(HardDisksDTO dto);
}

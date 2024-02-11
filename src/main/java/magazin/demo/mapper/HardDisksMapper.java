package magazin.demo.mapper;

import magazin.demo.dto.HardDiskDTO;
import magazin.demo.entity.HardDiskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface HardDisksMapper {

    HardDisksMapper INSTANCE = Mappers.getMapper(HardDisksMapper.class);

    @Mapping(target = "id", ignore = true)
    HardDiskDTO entityToDto(HardDiskEntity entity);

    @Mapping(target = "id", ignore = true)
    HardDiskEntity dtoToEntity(HardDiskDTO dto);
}

package magazin.demo.mapper;

import magazin.demo.dto.MonitorsDTO;
import magazin.demo.entity.MonitorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface MonitorsMapper {

    MonitorsMapper INSTANCE = Mappers.getMapper(MonitorsMapper.class);

    @Mapping(target = "id", ignore = true)
    MonitorsDTO entityToDto(MonitorEntity entity);

    @Mapping(target = "id", ignore = true)
    MonitorEntity dtoToEntity(MonitorsDTO dto);
}

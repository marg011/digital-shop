package magazin.demo.mapper;

import magazin.demo.dto.MonitorsDTO;
import magazin.demo.entity.MonitorsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MonitorsMapper {

    MonitorsMapper INSTANCE = Mappers.getMapper(MonitorsMapper.class);

    @Mapping(target = "id", ignore = true)
    MonitorsDTO entityToDto(MonitorsEntity entity);

    @Mapping(target = "id", ignore = true)
    MonitorsEntity dtoToEntity(MonitorsDTO dto);
}

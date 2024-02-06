package magazin.demo.mapper;

import magazin.demo.dto.LaptopDTO;
import magazin.demo.entity.LaptopEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface LaptopMapper {
    LaptopDTO laptopEntityToLaptopDTO(LaptopEntity laptopEntity);
    LaptopEntity laptopDTOToLaptopEntity(LaptopDTO laptopDTO);
}

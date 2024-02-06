package magazin.demo.mapper;

import magazin.demo.dto.DesktopComputerDTO;
import magazin.demo.entity.DesktopComputerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface DesktopComputerMapper {
    DesktopComputerEntity desktopDTOToDesktopEntity(DesktopComputerDTO desktopComputerDTO);
    DesktopComputerDTO desktopEntityToDesktopDTO(DesktopComputerEntity desktopComputerEntity);
}

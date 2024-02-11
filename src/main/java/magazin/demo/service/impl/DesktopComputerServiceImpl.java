package magazin.demo.service.impl;

import magazin.demo.dto.DesktopComputerDTO;
import magazin.demo.dto.DesktopComputersDTO;
import magazin.demo.entity.DesktopComputerEntity;
import magazin.demo.exception.desktop.DesktopIsNotFoundException;
import magazin.demo.mapper.DesktopComputerMapper;
import magazin.demo.repository.DesktopComputerRepository;
import magazin.demo.service.DesktopComputerService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class DesktopComputerServiceImpl implements DesktopComputerService {
    private final DesktopComputerRepository desktopComputerRepository;
    private final DesktopComputerMapper desktopComputerMapper;

    public DesktopComputerServiceImpl(DesktopComputerRepository desktopComputerRepository, DesktopComputerMapper desktopComputerMapper) {
        this.desktopComputerRepository = desktopComputerRepository;
        this.desktopComputerMapper = desktopComputerMapper;
    }

    public DesktopComputerDTO addDesktop(DesktopComputerDTO desktopComputerDTO){
        DesktopComputerEntity desktopComputerEntity = desktopComputerRepository.save(desktopComputerMapper.desktopDTOToDesktopEntity(desktopComputerDTO));
        return desktopComputerMapper.desktopEntityToDesktopDTO(desktopComputerEntity);
    }

    public DesktopComputerDTO updateDesktop(long id, DesktopComputerDTO desktopComputerDTO){
        DesktopComputerEntity desktopComputerEntity = desktopComputerRepository.findById(id).orElseThrow(() -> new DesktopIsNotFoundException("Desktop computer is not found"));
        desktopComputerEntity.setSerialNumber(desktopComputerDTO.getSerialNumber());
        desktopComputerEntity.setPrice(desktopComputerDTO.getPrice());
        desktopComputerEntity.setManufacturer(desktopComputerDTO.getManufacturer());
        desktopComputerEntity.setQuantity(desktopComputerDTO.getQuantity());
        desktopComputerEntity.setForm(desktopComputerDTO.getForm());
        desktopComputerRepository.save(desktopComputerEntity);
        return desktopComputerMapper.desktopEntityToDesktopDTO(desktopComputerEntity);
    }

    public DesktopComputersDTO getAllDesktops(){
        return new DesktopComputersDTO(desktopComputerRepository.findAll().stream()
                .map(desktopComputerMapper::desktopEntityToDesktopDTO)
                .collect(Collectors.toList()));
    }

    public DesktopComputerDTO getDesktopById(long id){
        DesktopComputerEntity desktopComputerEntity = desktopComputerRepository.findById(id).orElseThrow(() -> new DesktopIsNotFoundException("Desktop is not found"));
        return desktopComputerMapper.desktopEntityToDesktopDTO(desktopComputerEntity);
    }
}

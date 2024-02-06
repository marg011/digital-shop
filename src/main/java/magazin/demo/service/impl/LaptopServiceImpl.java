package magazin.demo.service.impl;

import magazin.demo.dto.LaptopDTO;
import magazin.demo.dto.LaptopsDTO;
import magazin.demo.entity.LaptopEntity;
import magazin.demo.exception.laptop.LaptopIsNotFoundException;
import magazin.demo.mapper.LaptopMapper;
import magazin.demo.repository.LaptopRepository;
import magazin.demo.service.LaptopService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class LaptopServiceImpl implements LaptopService {
    private final LaptopRepository laptopRepository;
    private final LaptopMapper laptopMapper;

    public LaptopServiceImpl(LaptopRepository laptopRepository, LaptopMapper laptopMapper) {
        this.laptopRepository = laptopRepository;
        this.laptopMapper = laptopMapper;
    }

    public LaptopDTO addLaptop(LaptopDTO laptopDTO){
        LaptopEntity laptopEntity = laptopRepository.save(laptopMapper.laptopDTOToLaptopEntity(laptopDTO));
        return laptopMapper.laptopEntityToLaptopDTO(laptopEntity);
    }

    public LaptopDTO updateLaptop(long id, LaptopDTO laptopDTO){
        LaptopEntity laptopEntity = laptopRepository.findById(id).orElseThrow(() -> new LaptopIsNotFoundException("Laptop is not found"));
        laptopEntity.setSerialNumber(laptopDTO.getSerialNumber());
        laptopEntity.setPrice(laptopDTO.getPrice());
        laptopEntity.setManufacturer(laptopDTO.getManufacturer());
        laptopEntity.setQuantity(laptopDTO.getQuantity());
        laptopEntity.setLaptopSize(laptopDTO.getLaptopSize());
        laptopRepository.save(laptopEntity);
        return laptopMapper.laptopEntityToLaptopDTO(laptopEntity);
    }

    public LaptopsDTO getAllLaptops(){
        return new LaptopsDTO(laptopRepository.findAll().stream()
                .map(laptopMapper::laptopEntityToLaptopDTO)
                .collect(Collectors.toList()));
    }

    public LaptopDTO getLaptopById(long id){
        LaptopEntity laptopEntity = laptopRepository.findById(id).orElseThrow(() -> new LaptopIsNotFoundException("Laptop is not found"));
        return laptopMapper.laptopEntityToLaptopDTO(laptopEntity);
    }
}

package magazin.demo.service;

import magazin.demo.dto.LaptopDTO;
import magazin.demo.dto.LaptopsDTO;

public interface LaptopService {
    LaptopDTO addLaptop(LaptopDTO laptopDTO);
    LaptopDTO updateLaptop(long id, LaptopDTO laptopDTO);
    LaptopsDTO getAllLaptops();
    LaptopDTO getLaptopById(long id);
}

package magazin.demo.service;

import magazin.demo.dto.DesktopComputerDTO;
import magazin.demo.dto.DesktopComputersDTO;

public interface DesktopComputerService {
    DesktopComputerDTO addDesktop(DesktopComputerDTO desktopComputerDTO);
    DesktopComputerDTO updateDesktop(long id, DesktopComputerDTO desktopComputerDTO);
    DesktopComputersDTO getAllDesktops();
    DesktopComputerDTO getDesktopById(long id);

}

package magazin.demo.controller;

import magazin.demo.dto.DesktopComputerDTO;
import magazin.demo.dto.DesktopComputersDTO;
import magazin.demo.service.impl.DesktopComputerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/desktop")
public class DesktopComputerController {
    private final DesktopComputerServiceImpl desktopComputerService;

    public DesktopComputerController(DesktopComputerServiceImpl desktopComputerService) {
        this.desktopComputerService = desktopComputerService;
    }

    @PostMapping
    public ResponseEntity<DesktopComputerDTO> addDesktop(@RequestBody DesktopComputerDTO desktopComputerDTO){
        return new ResponseEntity<>(desktopComputerService.addDesktop(desktopComputerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DesktopComputerDTO> updateDesktop(@PathVariable long id,
                                                            @RequestBody DesktopComputerDTO desktopComputerDTO){
        return new ResponseEntity<DesktopComputerDTO>(desktopComputerService.updateDesktop(id, desktopComputerDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<DesktopComputersDTO> getAllDesktops(){
        return new ResponseEntity<>(desktopComputerService.getAllDesktops(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesktopComputerDTO> getDesktopById(@PathVariable long id){
        return new ResponseEntity<>(desktopComputerService.getDesktopById(id), HttpStatus.FOUND);
    }
}

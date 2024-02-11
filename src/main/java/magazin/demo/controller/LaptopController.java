package magazin.demo.controller;

import magazin.demo.dto.LaptopDTO;
import magazin.demo.dto.LaptopsDTO;
import magazin.demo.service.impl.LaptopServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    private final LaptopServiceImpl laptopService;

    public LaptopController(LaptopServiceImpl laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping
    public ResponseEntity<LaptopDTO> addLaptop(@RequestBody LaptopDTO laptopDTO){
        return new ResponseEntity<>(laptopService.addLaptop(laptopDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LaptopDTO> updateLaptop(@PathVariable long id,
                                                  @RequestBody LaptopDTO laptopDTO){
        return new ResponseEntity<LaptopDTO>(laptopService.updateLaptop(id, laptopDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<LaptopsDTO> getAllLaptops(){
        return new ResponseEntity<>(laptopService.getAllLaptops(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LaptopDTO> getLaptopById(@PathVariable long id){
        return new ResponseEntity<>(laptopService.getLaptopById(id), HttpStatus.FOUND);
    }
}

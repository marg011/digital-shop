package magazin.demo.controller;

import magazin.demo.dto.HardDiskDTO;
import magazin.demo.exception.harddisks.HardDiskAlreadyExistsException;
import magazin.demo.exception.harddisks.HardDiskNotFoundException;
import magazin.demo.service.HardDiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hard-disks")
public class HardDiskController {

    private final HardDiskService hardDiskService;

    @Autowired
    public HardDiskController(HardDiskService hardDiskService) {
        this.hardDiskService = hardDiskService;
    }

    @PostMapping
    public ResponseEntity<HardDiskDTO> createHardDisk(@RequestBody HardDiskDTO hardDiskDTO) throws HardDiskAlreadyExistsException {
        HardDiskDTO createdHardDisk = hardDiskService.createHardDisk(hardDiskDTO);
        return new ResponseEntity<>(createdHardDisk, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardDiskDTO> readHardDiskById(@PathVariable int id) throws HardDiskNotFoundException {
        HardDiskDTO hardDiskDTO = hardDiskService.readHardDiskById(id);
        return new ResponseEntity<>(hardDiskDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HardDiskDTO>> findAllHardDisks() {
        List<HardDiskDTO> hardDisks = hardDiskService.findAllHardDisks();
        return new ResponseEntity<>(hardDisks, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardDiskDTO> updateHardDisk(@PathVariable int id, @RequestBody HardDiskDTO updatedHardDiskDTO)
            throws HardDiskNotFoundException {
        HardDiskDTO updatedHardDisk = hardDiskService.updateHardDisk(id, updatedHardDiskDTO);
        return new ResponseEntity<>(updatedHardDisk, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHardDisk(@PathVariable int id) throws HardDiskNotFoundException {
        hardDiskService.deleteHardDisk(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
package magazin.demo.controller;

import magazin.demo.dto.HardDisksDTO;
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
    public ResponseEntity<HardDisksDTO> createHardDisk(@RequestBody HardDisksDTO hardDiskDTO) throws HardDiskAlreadyExistsException {
        HardDisksDTO createdHardDisk = hardDiskService.createHardDisk(hardDiskDTO);
        return new ResponseEntity<>(createdHardDisk, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HardDisksDTO> readHardDiskById(@PathVariable int id) throws HardDiskNotFoundException {
        HardDisksDTO hardDiskDTO = hardDiskService.readHardDiskById(id);
        return new ResponseEntity<>(hardDiskDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HardDisksDTO>> findAllHardDisks() {
        List<HardDisksDTO> hardDisks = hardDiskService.findAllHardDisks();
        return new ResponseEntity<>(hardDisks, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HardDisksDTO> updateHardDisk(@PathVariable int id, @RequestBody HardDisksDTO updatedHardDiskDTO)
            throws HardDiskNotFoundException {
        HardDisksDTO updatedHardDisk = hardDiskService.updateHardDisk(id, updatedHardDiskDTO);
        return new ResponseEntity<>(updatedHardDisk, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHardDisk(@PathVariable int id) throws HardDiskNotFoundException {
        hardDiskService.deleteHardDisk(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
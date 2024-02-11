package magazin.demo.controller;

import magazin.demo.dto.MonitorDTO;
import magazin.demo.exception.monitors.MonitorAlreadyExistsException;
import magazin.demo.exception.monitors.MonitorNotFoundException;
import magazin.demo.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitors")
public class MonitorController {

    private final MonitorService monitorService;

    @Autowired
    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    @PostMapping
    public ResponseEntity<MonitorDTO> createMonitor(@RequestBody MonitorDTO monitorDTO) throws MonitorAlreadyExistsException {
        MonitorDTO createdMonitor = monitorService.createMonitor(monitorDTO);
        return new ResponseEntity<>(createdMonitor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitorDTO> readMonitorById(@PathVariable int id) throws MonitorNotFoundException {
        MonitorDTO monitorDTO = monitorService.readMonitorById(id);
        return new ResponseEntity<>(monitorDTO, HttpStatus.OK);
    }

    // todo поиск по серийному номеру

    @GetMapping
    public ResponseEntity<List<MonitorDTO>> findAllMonitors() {
        List<MonitorDTO> monitors = monitorService.findAllMonitors();
        return new ResponseEntity<>(monitors, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitorDTO> updateMonitor(@PathVariable int id, @RequestBody MonitorDTO updatedMonitorDTO)
            throws MonitorNotFoundException {
        MonitorDTO updatedMonitor = null;
        try {
            updatedMonitor = monitorService.updateMonitor(id, updatedMonitorDTO);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(updatedMonitor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMonitor(@PathVariable int id) throws MonitorNotFoundException {
        try {
            monitorService.deleteMonitor(id);
            String message = "Монитор с ID " + id + " удален успешно"; // не пишет
            return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
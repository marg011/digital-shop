package magazin.demo.controller;

import magazin.demo.dto.MonitorsDTO;
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
    public ResponseEntity<MonitorsDTO> createMonitor(@RequestBody MonitorsDTO monitorDTO) throws MonitorAlreadyExistsException {
        MonitorsDTO createdMonitor = monitorService.createMonitor(monitorDTO);
        return new ResponseEntity<>(createdMonitor, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonitorsDTO> readMonitorById(@PathVariable int id) throws MonitorNotFoundException {
        MonitorsDTO monitorDTO = monitorService.readMonitorById(id);
        return new ResponseEntity<>(monitorDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MonitorsDTO>> findAllMonitors() {
        List<MonitorsDTO> monitors = monitorService.findAllMonitors();
        return new ResponseEntity<>(monitors, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonitorsDTO> updateMonitor(@PathVariable int id, @RequestBody MonitorsDTO updatedMonitorDTO)
            throws MonitorNotFoundException {
        MonitorsDTO updatedMonitor = null;
        try {
            updatedMonitor = monitorService.updateMonitor(id, updatedMonitorDTO);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(updatedMonitor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMonitor(@PathVariable int id) throws MonitorNotFoundException {
        try {
            monitorService.deleteMonitor(id);
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
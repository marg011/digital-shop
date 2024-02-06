package magazin.demo.service;

import magazin.demo.dto.MonitorDTO;
import magazin.demo.exception.monitors.MonitorAlreadyExistsException;
import magazin.demo.exception.monitors.MonitorNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface MonitorService {

    MonitorDTO createMonitor(MonitorDTO monitorDTO) throws MonitorAlreadyExistsException;


    MonitorDTO readMonitorById(long id) throws MonitorNotFoundException;


    List<MonitorDTO> findAllMonitors();


    MonitorDTO updateMonitor(long id, MonitorDTO updatedMonitorDTO) throws ChangeSetPersister.NotFoundException, MonitorNotFoundException;


    void deleteMonitor(long id) throws ChangeSetPersister.NotFoundException, MonitorNotFoundException;

}

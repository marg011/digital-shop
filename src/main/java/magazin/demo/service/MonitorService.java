package magazin.demo.service;

import magazin.demo.dto.MonitorsDTO;
import magazin.demo.exception.monitors.MonitorAlreadyExistsException;
import magazin.demo.exception.monitors.MonitorNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface MonitorService {

    MonitorsDTO createMonitor(MonitorsDTO monitorDTO) throws MonitorAlreadyExistsException;


    MonitorsDTO readMonitorById(long id) throws MonitorNotFoundException;


    List<MonitorsDTO> findAllMonitors();


    MonitorsDTO updateMonitor(long id, MonitorsDTO updatedMonitorDTO) throws ChangeSetPersister.NotFoundException, MonitorNotFoundException;


    void deleteMonitor(long id) throws ChangeSetPersister.NotFoundException, MonitorNotFoundException;

}

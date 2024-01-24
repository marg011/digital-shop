package magazin.demo.service;

import magazin.demo.dto.MonitorsDTO;

import java.util.List;

public interface MonitorService {

    MonitorsDTO createMonitor(MonitorsDTO monitorDTO);


    MonitorsDTO readMonitorById(Long id);


    List<MonitorsDTO> findAllMonitors();


    MonitorsDTO updateMonitor(Long id, MonitorsDTO updatedMonitorDTO);


    void deleteMonitor(Long id);
}

package magazin.demo.service;

import lombok.RequiredArgsConstructor;
import magazin.demo.dto.MonitorsDTO;
import magazin.demo.entity.MonitorEntity;
import magazin.demo.mapper.MonitorsMapper;
import magazin.demo.repository.MonitorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonitorServiceImpl implements MonitorService {

    private final MonitorRepository monitorRepository;
    private final MonitorsMapper monitorsMapper;

    @Override
    public MonitorsDTO createMonitor(MonitorsDTO monitorDTO) {
        MonitorEntity monitorEntity = monitorsMapper.dtoToEntity(monitorDTO);
        MonitorEntity savedEntity = monitorRepository.save(monitorEntity);
        return monitorsMapper.entityToDto(savedEntity);
    }

    @Override
    public MonitorsDTO readMonitorById(Long id) {
        return null;
    }

    @Override
    public List<MonitorsDTO> findAllMonitors() {
        return null;
    }

    @Override
    public MonitorsDTO updateMonitor(Long id, MonitorsDTO updatedMonitorDTO) {
        return null;
    }

    @Override
    public void deleteMonitor(Long id) {

    }
}

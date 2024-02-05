package magazin.demo.service;

import magazin.demo.exception.monitors.MonitorAlreadyExistsException;
import magazin.demo.mapper.MonitorsMapper;
import magazin.demo.repository.MonitorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class MonitorServiceImplTest {

    @Mock
    private MonitorRepository monitorRepository;

    @Mock
    private MonitorsMapper monitorsMapper;

    @InjectMocks
    private MonitorServiceImpl monitorService;

    @Test
    public void testCreateMonitor() throws MonitorAlreadyExistsException {
    }
}
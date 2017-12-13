package br.ranzi.monitor.magnificent.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.ranzi.monitor.magnificent.domain.orm.model.MonitorHistory;
import br.ranzi.monitor.magnificent.domain.repository.MonitorHistoryRepository;
import br.ranzi.monitor.magnificent.provider.MonitorHistoryProvider;

@RunWith(MockitoJUnitRunner.class)
public class MonitorServiceTest {

    @Mock
    private MonitorHistoryRepository repository;
    @InjectMocks
    private MonitorService service;
    MonitorHistory monitorHistory;

    @Before
    public void setup() {
        monitorHistory = MonitorHistoryProvider.create();
    }

    @Test
    public void requestMonitorReturnSucess() {

        doReturn(monitorHistory).when(repository).save(monitorHistory);

        MonitorHistory request = service.request();
        assertNotNull(request);

        verify(repository, times(1)).save(monitorHistory);
    }


}

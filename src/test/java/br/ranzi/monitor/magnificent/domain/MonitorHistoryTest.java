package br.ranzi.monitor.magnificent.domain;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.ranzi.monitor.magnificent.MonitorMagnificentApplication;
import br.ranzi.monitor.magnificent.domain.orm.model.MonitorHistory;
import br.ranzi.monitor.magnificent.domain.repository.MonitorHistoryRepository;
import br.ranzi.monitor.magnificent.provider.MonitorHistoryProvider;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MonitorMagnificentApplication.class)
@ActiveProfiles("application-tst.yml")
public class MonitorHistoryTest {

    @Autowired
    private MonitorHistoryRepository repository;

    @Test
    public void insertMonitorRepository() {
        MonitorHistory entity = MonitorHistoryProvider.create();
        entity = repository.save(entity);

        assertNotNull(entity);
        assertNotNull(entity.getId());
    }

}

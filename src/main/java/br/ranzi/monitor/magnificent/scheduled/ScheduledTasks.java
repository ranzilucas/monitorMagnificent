package br.ranzi.monitor.magnificent.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.ranzi.monitor.magnificent.service.MonitorService;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    MonitorService service;

    @Scheduled(fixedRate = 2000)
    public void reportCurrentTime() {

        log.info("Execute my scheduled");
        service.request();
    }

}

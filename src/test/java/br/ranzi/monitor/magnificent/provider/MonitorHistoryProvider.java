package br.ranzi.monitor.magnificent.provider;

import java.time.LocalDateTime;

import br.ranzi.monitor.magnificent.domain.orm.model.MonitorHistory;

public class MonitorHistoryProvider {

    public static MonitorHistory create() {
        MonitorHistory monitorHistory = new MonitorHistory();
        monitorHistory.setDate(LocalDateTime.now());
        monitorHistory.setResponse("Test");
        monitorHistory.setStatusCode(200);
        return monitorHistory;
    }
}

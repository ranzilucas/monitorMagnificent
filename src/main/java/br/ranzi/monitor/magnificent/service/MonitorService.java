package br.ranzi.monitor.magnificent.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.ranzi.monitor.magnificent.domain.orm.model.MonitorHistory;
import br.ranzi.monitor.magnificent.domain.repository.MonitorHistoryRepository;

@Service
public class MonitorService {

    @Value("${monitor.url:#{null}}")
    protected String urlMonitor;
    @Autowired
    private MonitorHistoryRepository repository;

    protected MonitorHistory requestUrl() {
        MonitorHistory monitorHistory = new MonitorHistory();
        String urlString = urlMonitor;
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuilder result = new StringBuilder();
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            monitorHistory.setResponse(result.toString());
            monitorHistory.setStatusCode(200);
            rd.close();
        } catch (IOException e) {
            monitorHistory.setResponse(e.getMessage());
            monitorHistory.setStatusCode(500);
        }

        return monitorHistory;
    }

    public List<MonitorHistory> history() {
        List<MonitorHistory> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }


    public MonitorHistory request() {

        MonitorHistory monitorHistory = requestUrl();
        monitorHistory.setDate(LocalDateTime.now());

        repository.save(monitorHistory);

        return monitorHistory;
    }


}

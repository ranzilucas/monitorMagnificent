package br.ranzi.monitor.magnificent.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ranzi.monitor.magnificent.api.v1.assembler.MonitorHistoryAssembler;
import br.ranzi.monitor.magnificent.api.v1.resource.MonitorResource;
import br.ranzi.monitor.magnificent.service.MonitorService;

@RestController
public class MonitorController {

    @Autowired
    private MonitorService service;

    @Autowired
    private MonitorHistoryAssembler converter;

    @PutMapping(value = "/monitor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MonitorResource> getMonitor() {

        return ResponseEntity.ok(converter.toResource(service.request()));
    }

    @GetMapping(value = "/monitor", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MonitorResource>> getHistoryMonitor() {

        return ResponseEntity.ok(converter.toResources(service.history()));
    }

}

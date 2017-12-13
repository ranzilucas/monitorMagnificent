package br.ranzi.monitor.magnificent.api.v1.assembler;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.ranzi.monitor.magnificent.api.v1.resource.MonitorResource;
import br.ranzi.monitor.magnificent.domain.orm.model.MonitorHistory;

@Component
public class MonitorHistoryAssembler {

    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private static final Locale LOCALE_BRAZIL = new Locale("pt", "BR");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN)
            .withLocale(LOCALE_BRAZIL);

    public MonitorResource toResource(MonitorHistory entity) {
        return MonitorResource.builder()
                .date(dateTimeFormatter.format(entity.getDate()))
                .response(entity.getResponse())
                .statusCode(entity.getStatusCode()).build();
    }

    public List<MonitorResource> toResources(List<MonitorHistory> entities) {
        List<MonitorResource> resources = new ArrayList<>();

        if (entities != null) {
            resources = entities.stream().map(this::toResource).collect(Collectors.toList());
        }

        return resources;
    }
}

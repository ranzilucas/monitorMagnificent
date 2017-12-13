package br.ranzi.monitor.magnificent.api.v1.resource;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MonitorResource {

    @NotNull(message = "response not null")
    private String response;

    @NotNull(message = "statusCode not null")
    private Integer statusCode;

    @NotNull(message = "date not null")
    private String date;
}


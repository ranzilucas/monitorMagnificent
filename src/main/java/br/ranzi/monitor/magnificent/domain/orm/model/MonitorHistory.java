package br.ranzi.monitor.magnificent.domain.orm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(doNotUseGetters = true, of = "id")
public class MonitorHistory {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "response not null")
    private String response;

    @Column(nullable = false)
    @NotNull(message = "statusCode not null")
    private Integer statusCode;

    @Column(nullable = false)
    @NotNull(message = "date not null")
    private LocalDateTime date;

}

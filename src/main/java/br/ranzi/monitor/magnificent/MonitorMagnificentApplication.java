package br.ranzi.monitor.magnificent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MonitorMagnificentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorMagnificentApplication.class, args);
	}
}

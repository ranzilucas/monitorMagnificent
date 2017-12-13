package br.ranzi.monitor.magnificent.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ranzi.monitor.magnificent.domain.orm.model.MonitorHistory;

@Repository
public interface MonitorHistoryRepository extends CrudRepository<MonitorHistory, Long> {
}

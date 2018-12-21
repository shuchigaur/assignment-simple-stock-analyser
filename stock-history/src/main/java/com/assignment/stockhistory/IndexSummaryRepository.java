package com.assignment.stockhistory;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * Repository for retrieving stock index data
 */
public interface IndexSummaryRepository extends CrudRepository<IndexSummary, Long> {

    List<IndexSummary> findByDateBetween(Date start, Date end);

    List<IndexSummary> findByTypeAndDateBetween(String type, Date start, Date end);
}

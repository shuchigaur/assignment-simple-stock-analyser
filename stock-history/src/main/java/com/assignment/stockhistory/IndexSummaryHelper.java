package com.assignment.stockhistory;

import org.h2.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper for index summary data
 */
@Component
public class IndexSummaryHelper {

    @Autowired
    private IndexSummaryRepository indexSummaryRepository;

    private static final Logger log = LoggerFactory.getLogger(IndexSummaryHelper.class);

    private static ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * Returns a list of stock index summaries
     * for the given index type, start and end dates
     *
     * @param type      String stock index type viz., BSE or DJI
     * @param startDate String start date in yyyy-MM-dd format
     * @param endDate   String end date in yyyy-MM-dd format
     * @return List of stock index summary data
     */
    public List<IndexSummaryDTO> getIndexSummary(String type, String startDate, String endDate) {

        List<IndexSummaryDTO> indexSummaryDTOS = null;

        try {
            Date startDate1 = sdf.get().parse(null != startDate ? startDate : "1000-01-01");
            Date endDate1 = null != endDate ? sdf.get().parse(endDate) : new Date();

            List<IndexSummary> indexSummaries = StringUtils.isNullOrEmpty(type) ?
                    indexSummaryRepository.findByDateBetween(startDate1, endDate1) :
                    indexSummaryRepository.findByTypeAndDateBetween(type, startDate1, endDate1);

            if (null != indexSummaries) {
                indexSummaryDTOS = indexSummaries.stream()
                        .map(i -> new IndexSummaryDTO(i.getId(), i.getType(),
                                i.getDate().getTime(),
                                i.getOpen(), i.getHigh(), i.getLow(), i.getClose()))
                        .sorted(Comparator.comparing(i -> i.getDate()))
                        .collect(Collectors.toList());
            }

        } catch (ParseException pe) {
            log.error("Exception while fetching index summaries", pe);
        }

        return indexSummaryDTOS;
    }
}

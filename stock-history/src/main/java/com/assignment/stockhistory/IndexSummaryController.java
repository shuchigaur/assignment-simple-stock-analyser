package com.assignment.stockhistory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * API Controller for index summary data
 */
@RestController
public class IndexSummaryController {

    @Autowired
    private IndexSummaryHelper indexSummaryHelper;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/indexSummary")
    public List<IndexSummaryDTO> getIndexSummary(@RequestParam(value = "type", required = false) String type,
                                                 @RequestParam(value = "startDate", required = false) String startDate,
                                                 @RequestParam(value = "endDate", required = false) String endDate) {
        return indexSummaryHelper.getIndexSummary(type, startDate, endDate);
    }
}

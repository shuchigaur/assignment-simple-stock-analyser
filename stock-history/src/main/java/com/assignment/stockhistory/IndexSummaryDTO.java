package com.assignment.stockhistory;

import java.math.BigDecimal;

/**
 * DTO for stock index summary
 */
public class IndexSummaryDTO {

    private Long id;

    private String type;
    private long date;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;

    public IndexSummaryDTO() {
    }

    public IndexSummaryDTO(Long id, String type, long date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
        this.id = id;
        this.type = type;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public long getDate() {
        return date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getClose() {
        return close;
    }
}


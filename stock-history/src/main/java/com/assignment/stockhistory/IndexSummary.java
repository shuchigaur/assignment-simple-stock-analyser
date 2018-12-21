package com.assignment.stockhistory;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Entity class for referencing sock index summary data
 */
@Entity
public class IndexSummary {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String type;

    @Column(name = "index_date")
    private Date date;

    @Column(name = "open_value")
    private BigDecimal open;

    @Column(name = "high_value")
    private BigDecimal high;

    @Column(name = "low_value")
    private BigDecimal low;

    @Column(name = "close_value")
    private BigDecimal close;

    protected IndexSummary() {
    }

    public IndexSummary(String type, Date date, BigDecimal open, BigDecimal high, BigDecimal low, BigDecimal close) {
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

    public Date getDate() {
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

    @Override
    public String toString() {
        return "IndexSummary{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                '}';
    }
}


package com.example.DesafioItau.Model;

import jakarta.validation.constraints.PositiveOrZero;

public class EstatisticaDTO {
    @PositiveOrZero
    private long count;
    private Double sum;
    private Double avg;
    private Double minValue;
    private Double maxValue;

    public EstatisticaDTO() {}

    public EstatisticaDTO(long count,
                          Double sum,
                          Double avg,
                          Double minValue,
                          Double maxValue)
    {
        this.count = count;
        this.sum = sum;
        this.avg = avg;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public long getCount() {
        return count;
    }

    public Double getSum() {
        return sum;
    }

    public Double getAvg() {
        return avg;
    }

    public Double getMinValue() {
        return minValue;
    }

    public Double getMaxValue() {
        return maxValue;
    }
}

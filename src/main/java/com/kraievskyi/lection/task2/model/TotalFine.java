package com.kraievskyi.lection.task2.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class TotalFine implements Comparable<TotalFine> {

    private String type;
    private double totalAmount;

    @Override
    public int compareTo(TotalFine o) {
        return (int) (this.totalAmount - o.totalAmount);
    }
}

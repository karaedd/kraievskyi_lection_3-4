package com.kraievskyi.lection.task2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TotalFine implements Comparable<TotalFine> {

    @JsonProperty("type")
    private String type;
    @JsonProperty("fine_amount")
    private double fineAmount;

    @Override
    public int compareTo(TotalFine fine) {
        int i = (int) (this.fineAmount - fine.fineAmount);
        if (i != 0) {
            return -i;
        }
        return (int) (this.fineAmount - fine.fineAmount);
    }
}

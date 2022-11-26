package com.kraievskyi.lection.task2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Fine {
    @JsonProperty("date_time")
    private Date dateTime;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("type")
    private String type;
    @JsonProperty("fine_amount")
    private double fineAmount;
}

package com.kraievskyi.lection.task2.service;

import com.kraievskyi.lection.task2.model.TotalFine;
import com.kraievskyi.lection.task2.model.TotalFines;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FineService {
    public TotalFines calculateFines(List<TotalFine> totalFinesList) {
        TotalFines totalFines = new TotalFines();

        Map<String, Double> totalFineHashMap = new HashMap<>();
        totalFinesList.forEach(t ->
                totalFineHashMap.merge(t.getType(), t.getFineAmount(), Double::sum)
        );

        List<TotalFine> collect = totalFineHashMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue()
                        .reversed())
                .map(x -> new TotalFine(x.getKey(), x.getValue()))
                .collect(Collectors.toList());

        totalFines.setTotalFine(collect);

        return totalFines;
    }
}

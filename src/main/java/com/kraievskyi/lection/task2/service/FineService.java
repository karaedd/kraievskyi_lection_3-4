package com.kraievskyi.lection.task2.service;

import com.kraievskyi.lection.task2.model.Fine;
import com.kraievskyi.lection.task2.model.TotalFine;
import com.kraievskyi.lection.task2.model.TotalFines;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FineService {
    public TotalFines calculateFines(List<Fine> fines) {
        List<TotalFine> totalFinesList = new ArrayList<>();
        for (Fine fine : fines) {
            TotalFine totalFine = new TotalFine();
            totalFine.setType(fine.getType());
            totalFine.setTotalAmount(fine.getFineAmount());
            totalFinesList.add(totalFine);
        }

        for (int i = 0; i < totalFinesList.size(); i++) {
            for (int j = i + 1; j < totalFinesList.size(); j++) {
                if (totalFinesList.get(i).getType().equals(totalFinesList.get(j).getType())) {
                    totalFinesList.get(i).setTotalAmount(totalFinesList.get(i)
                            .getTotalAmount() + totalFinesList.get(j).getTotalAmount());
                    totalFinesList.remove(j--);
                }
            }
        }
        Collections.sort(totalFinesList);
        Collections.reverse(totalFinesList);
        TotalFines totalFines = new TotalFines();
        totalFines.setTotalFine(totalFinesList);
        return totalFines;
    }
}

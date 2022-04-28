package com.github.nikolay_martynov.grokking_algorithms;

import javax.annotation.Nonnull;
import java.util.List;

public class Ex_4_4 {

    /**
     * Checks if a sorted list contains a given value.
     * <p>
     * Implementation uses recursive binary search as required by exercise.
     *
     * @param sortedList  Sorted list where to search given value.
     * @param targetValue Value to search for.
     * @return true if sortedList contains targetValue. false if sortedList is empty or does not contain targetValue.
     */
    public boolean contains(@Nonnull List<Integer> sortedList, int targetValue) {
        if (sortedList.isEmpty()) {
            return false;
        }
        int middleIndex = sortedList.size() / 2;
        int middleValue = sortedList.get(middleIndex);
        if (targetValue == middleValue) {
            return true;
        } else if (targetValue < middleValue) {
            return contains(sortedList.subList(0, middleIndex), targetValue);
        } else {
            return contains(sortedList.subList(middleIndex + 1, sortedList.size()), targetValue);
        }
    }

}

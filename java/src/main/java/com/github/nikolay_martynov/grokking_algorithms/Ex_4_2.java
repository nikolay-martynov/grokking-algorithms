package com.github.nikolay_martynov.grokking_algorithms;

import javax.annotation.Nonnull;
import java.util.List;

public class Ex_4_2 {

    /**
     * Calculates the number of elements in a list.
     * <p>
     * Implementation uses recursion as required by the exercise.
     *
     * @param elements List whose elements are to be counted.
     * @return Number of elements in the list or 0 if the list is empty.
     */
    public int count(@Nonnull List<?> elements) {
        return elements.isEmpty() ? 0 : 1 + count(elements.subList(1, elements.size()));
    }

}

package com.github.nikolay_martynov.grokking_algorithms;

import javax.annotation.Nonnull;
import java.util.List;

public class Ex_4_1 {

    /**
     * Calculates the sum of elements in a list.
     * <p>
     * Implementation uses recursion as required by the exercise.
     *
     * @param numbers List whose elements are to be summed.
     * @return Sum of elements or 0 if the list is empty.
     */
    public int sum(@Nonnull List<Integer> numbers) {
        return numbers.isEmpty() ? 0 : numbers.get(0) + sum(numbers.subList(1, numbers.size()));
    }

}

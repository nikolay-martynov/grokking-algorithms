package com.github.nikolay_martynov.grokking_algorithms;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class Ex_4_3 {

    /**
     * Calculates a maximum element in a list.
     * <p>
     * Implementation uses recursion as required by the exercise.
     *
     * @param elements List where to find a maximum element.
     * @return Value of the maximum element in the list or null if the list is empty.
     */
    @Nullable
    public Integer max(@Nonnull List<Integer> elements) {
        if (elements.isEmpty()) {
            return null;
        }
        int head = elements.get(0);
        List<Integer> tail = elements.subList(1, elements.size());
        return tail.isEmpty() ? head : Math.max(head, Optional.ofNullable(max(tail)).orElseThrow());
    }

}

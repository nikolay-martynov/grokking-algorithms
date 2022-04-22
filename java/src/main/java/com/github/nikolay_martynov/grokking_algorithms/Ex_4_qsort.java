package com.github.nikolay_martynov.grokking_algorithms;

import javax.annotation.Nonnull;
import java.util.*;

public class Ex_4_qsort {

    /**
     * Performs quick sort over a list.
     * <p>
     * As per chapter 4.
     * Implementation is stable and does not change the order of equal elements.
     *
     * @param source     List to be sorted. Could be non-random access list. Should contain no null elements.
     * @param comparator Comparator to be used to compare elements in the list.
     * @param <T>        Type of the elements in the list.
     */
    <T> void quickSort(@Nonnull List<T> source, @Nonnull Comparator<T> comparator) {
        if (source.size() < 2) {
            return;
        }
        int randomIndex = (int) (Math.random() * source.size());
        Iterator<T> sourceIterator = source.iterator();
        T randomElement = sourceIterator.next();
        while (--randomIndex >= 0) {
            randomElement = sourceIterator.next();
        }
        // Less, equal, greater
        int partiallySortedSize = 3;
        List<List<T>> partiallySorted = new ArrayList<>(partiallySortedSize);
        for (int i = 0; i < partiallySortedSize; i++) {
            partiallySorted.add(new LinkedList<>());
        }
        for (T currentElement : source) {
            int comparisonResult = comparator.compare(currentElement, randomElement);
            int subListIndex = Integer.signum(comparisonResult) + 1;
            partiallySorted.get(subListIndex).add(currentElement);
        }
        // Less
        quickSort(partiallySorted.get(0), comparator);
        // Greater
        quickSort(partiallySorted.get(2), comparator);
        source.clear();
        for (List<T> elements : partiallySorted) {
            source.addAll(elements);
        }
    }

}

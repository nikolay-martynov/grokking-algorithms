package com.github.nikolay_martynov.grokking_algorithms;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;

public class Ex_6 {

    /**
     * Does a greedy search across a graph.
     *
     * @param graph     Graph to walk across. Keys are nodes of the graph and values are links to connected nodes.
     * @param start     Node to start search from.
     * @param predicate Predicate to apply to each node including starting one.
     *                  If predicate returns false then the search continues.
     *                  If predicate returns true for a node then search stops and this node is returned.
     * @param <T>       Type of nodes.
     *                  Those should have proper equals and hashCode implementations
     *                  to be suitable elements for {@link HashSet}.
     * @return First node for which predicate has returned true or null if no linked node has matched.
     */
    @Nullable
    <T> T greedySearch(@Nonnull Map<T, List<T>> graph, @Nonnull T start, @Nonnull Predicate<T> predicate) {
        Queue<T> toVisit = new LinkedList<>();
        toVisit.add(start);
        Set<T> visited = new HashSet<>(graph.size());
        while (!toVisit.isEmpty()) {
            T candidate = toVisit.remove();
            if (visited.contains(candidate)) {
                continue;
            }
            if (predicate.test(candidate)) {
                return candidate;
            }
            visited.add(candidate);
            List<T> links = graph.get(candidate);
            if (links != null) {
                for (T link : links) {
                    if (link != null) {
                        toVisit.add(link);
                    }
                }
            }
        }
        return null;
    }

}

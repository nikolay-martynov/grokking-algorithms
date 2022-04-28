package com.github.nikolay_martynov.grokking_algorithms;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class Ex_7 {

    /**
     * Finds the closest route in a weighted graph.
     * <p>
     * Implements Dijkstra algorithm.
     * Complexity is O(n^2).
     *
     * @param graph  Graph is represented as a map where the keys are vertices
     *               and values are edges to connected vertices.
     *               If a map is missing a value for some vertex or the value is null,
     *               then it is considered that this vertex has no outgoing edges.
     * @param start  Vertex to start from.
     * @param finish Vertex to which the closest route is to be found.
     * @return The closest route from start to finish.
     * Closest means that the route has a minimal sum of all {@link Edge#distance} across all edges
     * from start to finish.
     * The list starts with start and ends with finish.
     * If start equals finish, then the returned list will contain a single element start.
     * If there is no route from start to finish, then null is returned.
     */
    @Nullable
    public <T> List<T> findClosestRoute(Map<T, List<Edge<T>>> graph, T start, T finish) {
        if (start.equals(finish)) {
            return Collections.singletonList(start);
        }
        Map<T, Distance<T>> distances = new HashMap<>(graph.size());
        distances.put(start, new Distance<>(start, start, 0.0));
        Distance<T> closestDistance;
        while ((closestDistance = findNextNode(distances)) != null) {
            closestDistance.markOptimal();
            List<Edge<T>> outgoingEdges = graph.get(closestDistance.getTarget());
            if (outgoingEdges != null) {
                for (Edge<T> outgoingEdge : outgoingEdges) {
                    distances.putIfAbsent(outgoingEdge.target, new Distance<>(outgoingEdge.target, closestDistance.getTarget(), Double.POSITIVE_INFINITY));
                    Distance<T> outgoingDistance = distances.get(outgoingEdge.target);
                    double distanceThroughClosestNode = closestDistance.getDistanceTo() + outgoingEdge.distance;
                    if (distanceThroughClosestNode < outgoingDistance.getDistanceTo()) {
                        outgoingDistance.setParent(closestDistance.getTarget());
                        outgoingDistance.setDistanceTo(distanceThroughClosestNode);
                    }
                }
            }
        }
        if (distances.get(finish) == null) {
            return null;
        }
        LinkedList<T> route = new LinkedList<>();
        route.addFirst(finish);
        T currentNode = finish;
        while (!currentNode.equals(start)) {
            currentNode = distances.get(currentNode).getParent();
            route.addFirst(currentNode);
        }
        return route;
    }

    /**
     * Finds closest not yet optimized node.
     *
     * @param distances Map where the key is the node and the value is the distance to that node.
     * @return Distance to a node that is not yet optimized and that has a minimal distance among others or
     * null if no unoptimized nodes have left.
     */
    @Nullable
    private <T> Distance<T> findNextNode(@Nonnull Map<T, Distance<T>> distances) {
        Distance<T> closestDistance = null;
        for (Distance<T> currentDistance : distances.values()) {
            boolean isCloser = closestDistance == null
                    || currentDistance.getDistanceTo() < closestDistance.getDistanceTo();
            if (!currentDistance.isOptimal() && isCloser) {
                closestDistance = currentDistance;
            }
        }
        return closestDistance;
    }

    /**
     * Represents edge from one vertex of a graph to another.
     *
     * @param distance Distance between vertices.
     * @param target   Edge target.
     */
    public record Edge<T>(double distance, @Nonnull T target) {
    }

    /**
     * Represents optimized distance between to a vertex.
     */
    private static class Distance<T> {

        @Nonnull
        private final T target;
        private double distanceTo;
        private boolean optimal;
        @Nonnull
        private T parent;

        /**
         * Creates an instance.
         *
         * @param target     Target vertex.
         * @param parent     Parent vertex.
         * @param distanceTo Distance to target vertex from start.
         */
        public Distance(@Nonnull T target, @Nonnull T parent, double distanceTo) {
            this.target = target;
            this.parent = parent;
            this.distanceTo = distanceTo;
            optimal = false;
        }

        /**
         * Gets distance between start and target vertices.
         *
         * @return Distance that possibly has not yet been optimized.
         */
        public double getDistanceTo() {
            return distanceTo;
        }

        /**
         * Sets distance between start and target vertices.
         *
         * @param distanceTo Distance.
         */
        public void setDistanceTo(double distanceTo) {
            this.distanceTo = distanceTo;
        }

        /**
         * Gets if this distance has been optimized.
         *
         * @return true if this distance has been marked as optimized via {@link #markOptimal()}.
         */
        public boolean isOptimal() {
            return optimal;
        }

        /**
         * Marks this distance as optimized.
         */
        public void markOptimal() {
            optimal = true;
        }

        /**
         * Gets parent vertex in closest route from start.
         *
         * @return Parent vertex.
         */
        @Nonnull
        public T getParent() {
            return parent;
        }

        /**
         * Sets parent vertex in closest route from start.
         *
         * @param parent Parent vertex.
         */
        public void setParent(@Nonnull T parent) {
            this.parent = parent;
        }

        /**
         * Gets target vertex.
         *
         * @return target vertex.
         */
        @Nonnull
        public T getTarget() {
            return target;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Distance<?> distance = (Distance<?>) o;
            return target.equals(distance.target);
        }

        @Override
        public int hashCode() {
            return Objects.hash(target);
        }
    }

}

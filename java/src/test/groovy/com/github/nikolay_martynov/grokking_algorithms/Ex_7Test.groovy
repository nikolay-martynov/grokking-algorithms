package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

class Ex_7Test extends Specification {
    def "can find a route from start to finish"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [start : [new Ex_7.Edge<>(1, 'middle')],
                                                      middle: [new Ex_7.Edge<>(1, 'finish')],
                                                      finish: [],]
        String start = 'start'
        String finish = 'finish'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == ['start', 'middle', 'finish']
    }

    def "selects shortest route"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [start : [new Ex_7.Edge<>(6, 'A'),
                                                               new Ex_7.Edge<>(2, 'B'),],
                                                      A     : [new Ex_7.Edge<>(1, 'finish')],
                                                      B     : [new Ex_7.Edge<>(3, 'A'),
                                                               new Ex_7.Edge<>(5, 'finish'),],
                                                      finish: [],]
        String start = 'start'
        String finish = 'finish'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == ['start', 'B', 'A', 'finish']
    }

    def "start connects to finish"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [start: [new Ex_7.Edge<>(1, 'finish')],]
        String start = 'start'
        String finish = 'finish'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == ['start', 'finish']
    }

    def "start is finish"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [start: []]
        String start = 'start'
        String finish = 'start'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == ['start']
    }

    def "no route to finish"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [start : [new Ex_7.Edge<>(1, 'middle')],
                                                      middle: [],
                                                      finish: [],]
        String start = 'start'
        String finish = 'finish'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == null
    }

    def "missing value means no edges"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [start  : [new Ex_7.Edge<>(1, 'middle1'),
                                                                new Ex_7.Edge<>(2, 'middle2'),
                                                                new Ex_7.Edge<>(3, 'middle3'),],
                                                      middle2: [new Ex_7.Edge<>(1, 'finish')],]
        String start = 'start'
        String finish = 'finish'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == ['start', 'middle2', 'finish']
    }

    def "graph is empty and start is finish"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [:]
        String start = 'start'
        String finish = 'start'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == ['start']
    }

    def "graph is empty and start is not finish"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [:]
        String start = 'start'
        String finish = 'finish'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == null
    }

    def "7.1 A"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [start: [new Ex_7.Edge<>(5, 'a'),
                                                              new Ex_7.Edge<>(2, 'd'),],
                                                      a    : [new Ex_7.Edge<>(4, 'b'),
                                                              new Ex_7.Edge<>(2, 'c'),],
                                                      b    : [new Ex_7.Edge<>(3, 'finish'),
                                                              new Ex_7.Edge<>(6, 'c'),],
                                                      c    : [new Ex_7.Edge<>(1, 'finish'),],
                                                      d    : [new Ex_7.Edge<>(8, 'a'),
                                                              new Ex_7.Edge<>(7, 'c'),],

        ]
        String start = 'start'
        String finish = 'finish'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == ['start', 'a', 'c', 'finish']
    }

    def "7.1 B"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [start: [new Ex_7.Edge<>(10, 'a'),],
                                                      a    : [new Ex_7.Edge<>(20, 'b'),],
                                                      b    : [new Ex_7.Edge<>(30, 'finish'),
                                                              new Ex_7.Edge<>(1, 'c'),],
                                                      c    : [new Ex_7.Edge<>(1, 'a'),],]
        String start = 'start'
        String finish = 'finish'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == ['start', 'a', 'b', 'finish']
    }

    def "7.1 C"() {
        given:
        Map<String, List<Ex_7.Edge<String>>> graph = [start: [new Ex_7.Edge<>(2, 'a'),
                                                              new Ex_7.Edge<>(2, 'c'),],
                                                      a    : [new Ex_7.Edge<>(2, 'finish'),
                                                              new Ex_7.Edge<>(2, 'b'),],
                                                      b    : [new Ex_7.Edge<>(2, 'finish'),
                                                              new Ex_7.Edge<>(-1, 'c'),],
                                                      c    : [new Ex_7.Edge<>(2, 'a'),],]
        String start = 'start'
        String finish = 'finish'
        when:
        List<String> route = new Ex_7().findClosestRoute(graph, start, finish)
        then:
        route == ['start', 'a', 'finish']
    }
}

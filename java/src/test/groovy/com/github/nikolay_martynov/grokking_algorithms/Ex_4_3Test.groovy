package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

class Ex_4_3Test extends Specification {
    def "empty leads to null"() {
        given:
        List<Integer> input = []
        when:
        Integer result = new Ex_4_3().max(input)
        then:
        result == null
    }

    def "one element"() {
        given:
        List<Integer> input = [2]
        when:
        Integer result = new Ex_4_3().max(input)
        then:
        result == 2
    }

    def "two elements"() {
        given:
        List<Integer> input = [2, 3]
        when:
        Integer result = new Ex_4_3().max(input)
        then:
        result == 3
    }

    def "many elements random order"() {
        given:
        List<Integer> input = [-1, 1, 0, -2, 2, -3]
        when:
        Integer result = new Ex_4_3().max(input)
        then:
        result == 2
    }
}

package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

class Ex_4_1Test extends Specification {
    def "when empty then zero"() {
        given:
        List<Integer> input = []
        when:
        int result = new Ex_4_1().sum(input)
        then:
        result == 0
    }

    def "one element is self"() {
        given:
        List<Integer> input = [9]
        when:
        int result = new Ex_4_1().sum(input)
        then:
        result == 9
    }

    def "two elements"() {
        given:
        List<Integer> input = [2, 1]
        when:
        int result = new Ex_4_1().sum(input)
        then:
        result == 3
    }

    def "many elements"() {
        given:
        List<Integer> input = [3, 2, 1]
        when:
        int result = new Ex_4_1().sum(input)
        then:
        result == 6
    }
}

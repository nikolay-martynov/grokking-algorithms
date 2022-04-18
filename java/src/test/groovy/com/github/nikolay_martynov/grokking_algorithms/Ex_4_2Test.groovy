package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

class Ex_4_2Test extends Specification {
    def "when empty then zero"() {
        given:
        List<Integer> input = []
        when:
        int result = new Ex_4_2().count(input)
        then:
        result == 0
    }

    def "one"() {
        given:
        List<Integer> input = [6]
        when:
        int result = new Ex_4_2().count(input)
        then:
        result == 1
    }

    def "many"() {
        given:
        List<Integer> input = [0, 2, 4]
        when:
        int result = new Ex_4_2().count(input)
        then:
        result == 3
    }
}

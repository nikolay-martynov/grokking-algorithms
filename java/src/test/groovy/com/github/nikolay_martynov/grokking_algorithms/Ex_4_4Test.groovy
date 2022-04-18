package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

class Ex_4_4Test extends Specification {
    def "empty"() {
        given:
        List<Integer> input = []
        int target = 6
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        !result
    }

    def "one other element"() {
        given:
        List<Integer> input = [5]
        int target = 6
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        !result
    }

    def "one target element"() {
        given:
        List<Integer> input = [6]
        int target = 6
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        result
    }

    def "two elements missing left"() {
        given:
        List<Integer> input = [1, 2]
        int target = 0
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        !result
    }

    def "two elements contains left"() {
        given:
        List<Integer> input = [1, 2]
        int target = 1
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        result
    }

    def "two elements contains right"() {
        given:
        List<Integer> input = [1, 2]
        int target = 2
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        result
    }

    def "two elements missing right"() {
        given:
        List<Integer> input = [1, 2]
        int target = 3
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        !result
    }

    def "two elements missing middle"() {
        given:
        List<Integer> input = [1, 3]
        int target = 2
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        !result
    }

    def "odd elements contains middle"() {
        given:
        List<Integer> input = [1, 2, 3, 4, 5]
        int target = 3
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        result
    }

    def "odd elements contains left"() {
        given:
        List<Integer> input = [1, 2, 3, 4, 5]
        int target = 1
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        result
    }

    def "odd elements contains right"() {
        given:
        List<Integer> input = [1, 2, 3, 4, 5]
        int target = 5
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        result
    }

    def "odd elements missing left"() {
        given:
        List<Integer> input = [1, 2, 3, 4, 5]
        int target = 0
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        !result
    }

    def "odd elements missing right"() {
        given:
        List<Integer> input = [1, 2, 3, 4, 5]
        int target = 6
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        !result
    }

    def "odd elements missing middle"() {
        given:
        List<Integer> input = [1, 2, 3, 5, 6]
        int target = 4
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        !result
    }

    def "even elements contain"() {
        given:
        List<Integer> input = [1, 2, 3, 4, 5, 6]
        int target = 4
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        result
    }

    def "even elements missing"() {
        given:
        List<Integer> input = [1, 2, 4, 5, 6, 7]
        int target = 3
        when:
        boolean result = new Ex_4_4().contains(input, target)
        then:
        !result
    }
}

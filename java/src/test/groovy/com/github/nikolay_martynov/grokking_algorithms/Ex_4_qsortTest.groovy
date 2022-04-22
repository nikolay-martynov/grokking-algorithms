package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

class Ex_4_qsortTest extends Specification {

    static record Element(int weight, String value) {}

    static class WeightComparator implements Comparator<Element> {
        @Override
        int compare(Element o1, Element o2) {
            return o1.weight() - o2.weight()
        }
    }

    def "empty"() {
        given:
        List<Element> input = new LinkedList<>(Arrays.asList())
        when:
        new Ex_4_qsort().quickSort(input, new WeightComparator())
        then:
        input.isEmpty()
    }

    def "one element"() {
        given:
        List<Element> input = new LinkedList<>(Arrays.asList(
                new Element(1, "one"),
        ))
        when:
        new Ex_4_qsort().quickSort(input, new WeightComparator())
        then:
        input == Arrays.asList(
                new Element(1, "one"),
        )
    }

    def "two elements"() {
        given:
        List<Element> input = new LinkedList<>(Arrays.asList(
                new Element(2, "two"),
                new Element(1, "one"),
        ))
        when:
        new Ex_4_qsort().quickSort(input, new WeightComparator())
        then:
        input == Arrays.asList(
                new Element(1, "one"),
                new Element(2, "two"),
        )
    }

    def "many even elements"() {
        given:
        List<Element> input = new LinkedList<>(Arrays.asList(
                new Element(6, "six"),
                new Element(5, "five"),
                new Element(4, "four"),
                new Element(3, "three"),
                new Element(2, "two"),
                new Element(1, "one"),
        ))
        when:
        new Ex_4_qsort().quickSort(input, new WeightComparator())
        then:
        input == Arrays.asList(
                new Element(1, "one"),
                new Element(2, "two"),
                new Element(3, "three"),
                new Element(4, "four"),
                new Element(5, "five"),
                new Element(6, "six"),
        )
    }

    def "many odd elements"() {
        given:
        List<Element> input = new LinkedList<>(Arrays.asList(
                new Element(6, "six"),
                new Element(5, "five"),
                new Element(4, "four"),
                new Element(3, "three"),
                new Element(2, "two"),
                new Element(1, "one"),
                new Element(7, "seven"),
        ))
        when:
        new Ex_4_qsort().quickSort(input, new WeightComparator())
        then:
        input == Arrays.asList(
                new Element(1, "one"),
                new Element(2, "two"),
                new Element(3, "three"),
                new Element(4, "four"),
                new Element(5, "five"),
                new Element(6, "six"),
                new Element(7, "seven"),
        )
    }

    def "sort is stable"() {
        given:
        List<Element> input = new LinkedList<>(Arrays.asList(
                new Element(3, "3.1"),
                new Element(2, "2.1"),
                new Element(1, "1.1"),
                new Element(1, "1.2"),
                new Element(3, "3.2"),
                new Element(2, "2.2"),
        ))
        when:
        new Ex_4_qsort().quickSort(input, new WeightComparator())
        then:
        input == Arrays.asList(
                new Element(1, "1.1"),
                new Element(1, "1.2"),
                new Element(2, "2.1"),
                new Element(2, "2.2"),
                new Element(3, "3.1"),
                new Element(3, "3.2"),
        )
    }

}

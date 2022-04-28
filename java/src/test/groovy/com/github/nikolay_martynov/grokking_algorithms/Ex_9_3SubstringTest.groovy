package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

class Ex_9_3SubstringTest extends Specification {

    def "9.3"() {
        given:
        String a = 'blue'
        String b = 'clues'
        when:
        List<Ex_9_3_substring.CommonSubstring> substrings = new Ex_9_3_substring().findCommonSubstrings(a, b)
        then:
        substrings ==~ [new Ex_9_3_substring.CommonSubstring(1, 1, 3)]
    }

    def "empty a"() {
        given:
        String a = ''
        String b = 'b'
        when:
        List<Ex_9_3_substring.CommonSubstring> substrings = new Ex_9_3_substring().findCommonSubstrings(a, b)
        then:
        substrings.empty
    }

    def "empty b"() {
        given:
        String a = 'a'
        String b = ''
        when:
        List<Ex_9_3_substring.CommonSubstring> substrings = new Ex_9_3_substring().findCommonSubstrings(a, b)
        then:
        substrings.empty
    }

    def "equal one symbol"() {
        given:
        String a = 'c'
        String b = 'c'
        when:
        List<Ex_9_3_substring.CommonSubstring> substrings = new Ex_9_3_substring().findCommonSubstrings(a, b)
        then:
        substrings ==~ [new Ex_9_3_substring.CommonSubstring(0, 0, 1)]
    }

    def "equal two symbols"() {
        given:
        String a = 'cc'
        String b = 'cc'
        when:
        List<Ex_9_3_substring.CommonSubstring> substrings = new Ex_9_3_substring().findCommonSubstrings(a, b)
        then:
        substrings ==~ [new Ex_9_3_substring.CommonSubstring(0, 0, 2)]
    }

    def "overlap middle"() {
        given:
        String a = 'ac'
        String b = 'cb'
        when:
        List<Ex_9_3_substring.CommonSubstring> substrings = new Ex_9_3_substring().findCommonSubstrings(a, b)
        then:
        substrings ==~ [new Ex_9_3_substring.CommonSubstring(1, 0, 1)]
    }

    def "same edge"() {
        given:
        String a = 'ca'
        String b = 'bc'
        when:
        List<Ex_9_3_substring.CommonSubstring> substrings = new Ex_9_3_substring().findCommonSubstrings(a, b)
        then:
        substrings ==~ [new Ex_9_3_substring.CommonSubstring(0, 1, 1)]
    }

    def "long common"() {
        given:
        String a = '12233355555'
        String b = '0223334444666666'
        when:
        List<Ex_9_3_substring.CommonSubstring> substrings = new Ex_9_3_substring().findCommonSubstrings(a, b)
        then:
        substrings ==~ [new Ex_9_3_substring.CommonSubstring(1, 1, 5)]
    }

    def "multiple common"() {
        given:
        String a = '0123456789'
        String b = '124678'
        when:
        List<Ex_9_3_substring.CommonSubstring> substrings = new Ex_9_3_substring().findCommonSubstrings(a, b)
        then:
        substrings ==~ [new Ex_9_3_substring.CommonSubstring(1, 0, 2),
                        new Ex_9_3_substring.CommonSubstring(4, 2, 1),
                        new Ex_9_3_substring.CommonSubstring(6, 3, 3),]
    }
}

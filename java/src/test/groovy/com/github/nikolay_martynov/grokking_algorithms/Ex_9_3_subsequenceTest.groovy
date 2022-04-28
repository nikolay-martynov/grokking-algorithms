package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

class Ex_9_3_subsequenceTest extends Specification {

    def "9.3"() {
        given:
        String a = 'blue'
        String b = 'clues'
        when:
        int[][] sequence = new Ex_9_3_subsequence().findCommonSubsequence(a, b)
        then:
        sequence == [[1, 2, 3] as int[],
                     [1, 2, 3] as int[],] as int[][]
    }

    def "empty a"() {
        given:
        String a = ''
        String b = 'b'
        when:
        int[][] sequence = new Ex_9_3_subsequence().findCommonSubsequence(a, b)
        then:
        sequence == [[] as int[],
                     [] as int[],] as int[][]
    }

    def "empty b"() {
        given:
        String a = 'a'
        String b = ''
        when:
        int[][] sequence = new Ex_9_3_subsequence().findCommonSubsequence(a, b)
        then:
        sequence == [[] as int[],
                     [] as int[],] as int[][]
    }

    def "equal one symbol"() {
        given:
        String a = 'c'
        String b = 'c'
        when:
        int[][] sequence = new Ex_9_3_subsequence().findCommonSubsequence(a, b)
        then:
        sequence == [[0] as int[],
                     [0] as int[],] as int[][]
    }

    def "equal two symbols"() {
        given:
        String a = 'cc'
        String b = 'cc'
        when:
        int[][] sequence = new Ex_9_3_subsequence().findCommonSubsequence(a, b)
        then:
        sequence == [[0, 1] as int[],
                     [0, 1] as int[],] as int[][]
    }

    def "overlap middle"() {
        given:
        String a = 'ac'
        String b = 'cb'
        when:
        int[][] sequence = new Ex_9_3_subsequence().findCommonSubsequence(a, b)
        then:
        sequence == [[1] as int[],
                     [0] as int[],] as int[][]
    }

    def "same edge"() {
        given:
        String a = 'ca'
        String b = 'bc'
        when:
        int[][] sequence = new Ex_9_3_subsequence().findCommonSubsequence(a, b)
        then:
        sequence == [[0] as int[],
                     [1] as int[],] as int[][]
    }

    def "example from javadoc"() {
        given:
        String a = 'ABCEF'
        String b = 'ACDFG'
        when:
        int[][] sequence = new Ex_9_3_subsequence().findCommonSubsequence(a, b)
        then:
        sequence == [[0, 2, 4] as int[],
                     [0, 1, 3] as int[],] as int[][]
    }

}

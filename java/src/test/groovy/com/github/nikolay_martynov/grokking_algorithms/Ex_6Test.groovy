package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

import java.util.function.Predicate

class Ex_6Test extends Specification {

    def "mango seller"() {
        given:
        Map<String, List<String>> graph = ['you'   : ['alice', 'bob', 'claire'],
                                           'bob'   : ['anuj', 'peggy'],
                                           'alice' : ['peggy'],
                                           'claire': ['thom', 'jonny'],
                                           'anuj'  : [],
                                           'peggy' : [],
                                           'thom'  : [],
                                           'jonny' : [],]
        Predicate<String> personIsSeller = { String name -> name.endsWith('m') }
        String start = 'you'
        when:
        String result = new Ex_6().greedySearch(graph, start, personIsSeller)
        then:
        result == 'thom'
    }

    def 'morning tasks'() {
        given:
        Map<String, List<String>> graph = ['awake'        : ['exercise', 'brush teethes', 'pack lunch'],
                                           'exercise'     : ['shower'],
                                           'brush teethes': ['breakfast'],
                                           'shower'       : ['dress'],]
        List<String> tasks = []
        Predicate<String> collectTasks = { String name ->
            tasks.add(name)
            false
        }
        String start = 'awake'
        when:
        String result = new Ex_6().greedySearch(graph, start, collectTasks)
        then:
        !result
        tasks == ['awake', 'exercise', 'brush teethes', 'pack lunch', 'shower', 'breakfast', 'dress']
    }

    def 'no route'() {
        given:
        Map<String, List<String>> graph = ['start'   : ['step 1', 'step 2', 'step 3'],
                                           'finish'  : [],
                                           'step 1'  : ['step 1 1', 'step 1 2', 'step 1 3'],
                                           'step 2'  : ['step 2 1', 'step 2 2', 'step 2 3'],
                                           'step 3'  : ['step 3 1', 'step 3 2', 'step 3 3'],
                                           'step 2 1': ['dead-end'],
                                           'step 2 2': ['dead-end'],
                                           'step 2 3': ['dead-end'],
                                           'step 3 1': ['dead-end'],
                                           'step 3 2': ['dead-end'],
                                           'step 3 3': ['dead-end'],]
        Predicate<String> finished = { String name -> name == 'finish' }
        String start = 'start'
        when:
        String result = new Ex_6().greedySearch(graph, start, finished)
        then:
        result == null
    }

    def 'has route'() {
        given:
        Map<String, List<String>> graph = ['start'   : ['step 1', 'step 2', 'step 3'],
                                           'finish'  : [],
                                           'step 1'  : ['step 1 1', 'step 1 2', 'step 1 3'],
                                           'step 2'  : ['step 2 1', 'step 2 2', 'step 2 3'],
                                           'step 3'  : ['step 3 1', 'step 3 2', 'step 3 3'],
                                           'step 2 1': ['dead-end'],
                                           'step 2 2': ['dead-end'],
                                           'step 2 3': ['dead-end'],
                                           'step 3 1': ['step 4'],
                                           'step 3 2': ['dead-end'],
                                           'step 3 3': ['dead-end'],
                                           'step 4'  : ['finish'],]
        Predicate<String> finished = { String name -> name == 'finish' }
        String start = 'start'
        when:
        String result = new Ex_6().greedySearch(graph, start, finished)
        then:
        result == 'finish'
    }

}

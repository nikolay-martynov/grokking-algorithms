package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

class Ex_9Test extends Specification {
    def "9"() {
        given:
        Map<String, Ex_9.ItemInfo> inventory = ['tape player': new Ex_9.ItemInfo(3000.0, 4),
                                                laptop       : new Ex_9.ItemInfo(2000.0, 3),
                                                guitar       : new Ex_9.ItemInfo(1500.0, 1),]
        int bagSize = 4
        when:
        Set<String> result = new Ex_9().optimizeBagDynamic(inventory, bagSize)
        then:
        result ==~ ['laptop', 'guitar']
    }

    def "9.1"() {
        given:
        Map<String, Ex_9.ItemInfo> inventory = ['tape player': new Ex_9.ItemInfo(3000.0, 4),
                                                laptop       : new Ex_9.ItemInfo(2000.0, 3),
                                                guitar       : new Ex_9.ItemInfo(1500.0, 1),
                                                iphone       : new Ex_9.ItemInfo(2000.0, 1),
                                                'mp3 player' : new Ex_9.ItemInfo(1000.0, 1),]
        int bagSize = 4
        when:
        Set<String> result = new Ex_9().optimizeBagDynamic(inventory, bagSize)
        then:
        result ==~ ['guitar', 'iphone', 'mp3 player']
    }

    def "9.2"() {
        given:
        Map<String, Ex_9.ItemInfo> inventory = [water : new Ex_9.ItemInfo(10.0, 3),
                                                book  : new Ex_9.ItemInfo(3.0, 1),
                                                food  : new Ex_9.ItemInfo(9.0, 2),
                                                jacket: new Ex_9.ItemInfo(5.0, 2),
                                                camera: new Ex_9.ItemInfo(6.0, 1),]
        int bagSize = 6
        when:
        Set<String> result = new Ex_9().optimizeBagDynamic(inventory, bagSize)
        then:
        result ==~ ['water', 'food', 'camera']
    }

    def "tour"() {
        given:
        Map<String, Ex_9.ItemInfo> pointsOfInterest = [Westminster        : new Ex_9.ItemInfo(7.0, 12),
                                                       'The Globe Theatre': new Ex_9.ItemInfo(6.0, 12),
                                                       'National gallery' : new Ex_9.ItemInfo(9.0, 24),
                                                       'British museum'   : new Ex_9.ItemInfo(9.0, 48),
                                                       'Saint Paul`s'     : new Ex_9.ItemInfo(8.0, 12),]
        int timeBudget = 48
        when:
        Set<String> tour = new Ex_9().optimizeBagDynamic(pointsOfInterest, timeBudget)
        then:
        tour ==~ ['Westminster', 'National gallery', 'Saint Paul`s']
    }

    def "exact"() {
        given:
        Map<String, Ex_9.ItemInfo> inventory = [a: new Ex_9.ItemInfo(1.0, 1)]
        int bagSize = 1
        when:
        Set<String> result = new Ex_9().optimizeBagDynamic(inventory, bagSize)
        then:
        result ==~ ['a']
    }

    def "bag too small"() {
        given:
        Map<String, Ex_9.ItemInfo> inventory = [a: new Ex_9.ItemInfo(1.0, 2)]
        int bagSize = 1
        when:
        Set<String> result = new Ex_9().optimizeBagDynamic(inventory, bagSize)
        then:
        result ==~ []
    }

    def "empty inventory"() {
        given:
        Map<String, Ex_9.ItemInfo> inventory = [:]
        int bagSize = 4
        when:
        Set<String> result = new Ex_9().optimizeBagDynamic(inventory, bagSize)
        then:
        result ==~ []
    }

    def "only one fits"() {
        given:
        Map<String, Ex_9.ItemInfo> inventory = [a: new Ex_9.ItemInfo(1.0, 2),
                                                b: new Ex_9.ItemInfo(2.0, 1),
                                                c: new Ex_9.ItemInfo(3.0, 4),]
        int bagSize = 2
        when:
        Set<String> result = new Ex_9().optimizeBagDynamic(inventory, bagSize)
        then:
        result ==~ ['b']
    }

    def "two fits exact"() {
        given:
        Map<String, Ex_9.ItemInfo> inventory = [a: new Ex_9.ItemInfo(1.0, 1),
                                                b: new Ex_9.ItemInfo(2.0, 2),
                                                c: new Ex_9.ItemInfo(2.5, 3),]
        int bagSize = 3
        when:
        Set<String> result = new Ex_9().optimizeBagDynamic(inventory, bagSize)
        then:
        result ==~ ['a', 'b']
    }

    def "two fits some space left"() {
        given:
        Map<String, Ex_9.ItemInfo> inventory = [a: new Ex_9.ItemInfo(1.0, 3),
                                                b: new Ex_9.ItemInfo(2.0, 5),
                                                c: new Ex_9.ItemInfo(2.5, 7),]
        int bagSize = 9
        when:
        Set<String> result = new Ex_9().optimizeBagDynamic(inventory, bagSize)
        then:
        result ==~ ['a', 'b']
    }
}

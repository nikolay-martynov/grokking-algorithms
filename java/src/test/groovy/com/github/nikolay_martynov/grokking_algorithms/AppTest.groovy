/*
 * This Spock specification was generated by the Gradle 'init' task.
 */
package com.github.nikolay_martynov.grokking_algorithms

import spock.lang.Specification

class AppTest extends Specification {
    def "application has a greeting"() {
        setup:
        def app = new App()

        when:
        def result = app.greeting

        then:
        result != null
    }
}

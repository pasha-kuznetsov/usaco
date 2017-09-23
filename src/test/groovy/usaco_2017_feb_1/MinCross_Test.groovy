package usaco_2017_feb_1

import spock.lang.Specification
import spock.lang.Unroll

class MinCross_Test extends Specification {
    @Unroll
    def "test #input"() {
        expect:
        MinCross.minCrossingPairs(input) == expectedOutput

        where:
        input | expectedOutput
        [5, 5, 4, 1, 3, 2, 1, 3, 2, 5, 4] | 0
    }
}

package usaco_2017_feb_1

import spock.lang.Specification
import spock.lang.Unroll

class MergeCount_Test extends Specification {
    @Unroll
    def "test #input"() {
        def expectedSorted = input as int[]
        Arrays.sort(expectedSorted)

        when:
        def sorted = input as int[]
        def inversions = new MergeCount().countInversions(sorted)

        then:
        sorted == expectedSorted
        inversions == expectedInversions

        where:
        input                           | expectedInversions
        [0, 2, 1, 4, 3]                 | 2
        [0, 2, 1, 2, 4, 3]              | 2
        [2, 0, 2, 1, 2, 4, 3]           | 4
        [3, 1, 6, 5, 2, 4]              | 7
        [5, 2, 10, 8, 1, 9, 4, 3, 6, 7] | 22
    }
}

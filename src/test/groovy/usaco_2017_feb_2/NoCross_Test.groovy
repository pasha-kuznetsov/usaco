package usaco_2017_feb_2

import spock.lang.Specification
import spock.lang.Unroll
import testutils.TestOutput

class NoCross_Test extends Specification {
    @Unroll
    def "test #expectedOutput"() {
        def fields = input.split()
        int n = fields.size() / 2
        def inputStream = new StringReader((n + '\n' + fields.join('\n')))
        def output = new TestOutput()

        when:
        NoCross.main(inputStream, output.print)

        then:
        output.string == expectedOutput

        where:
        input                        | expectedOutput
        '''1 2 3 4 5 6
           6 5 4 3 2 1''' | '5'
    }
}

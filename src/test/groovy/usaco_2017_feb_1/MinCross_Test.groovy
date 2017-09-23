package usaco_2017_feb_1

import spock.lang.Specification
import spock.lang.Unroll

import java.nio.charset.StandardCharsets

class MinCross_Test extends Specification {
    @Unroll
    def "test #input"() {
        when:
        def io = new InputOutput(input)
        MinCross.main(io.input, io.print)

        then:
        io.output() == expectedOutput

        where:
        input | expectedOutput
        '5 5 4 1 3 2 1 3 2 5 4' | '0'
    }

    static class InputOutput {
        Scanner input
        OutputStream output = new ByteArrayOutputStream()
        PrintStream print = new PrintStream(output, true)

        InputOutput(String input) {
            this.input = new Scanner(new StringReader(input))
        }

        String output() {
            return output.toString()
        }
    }
}

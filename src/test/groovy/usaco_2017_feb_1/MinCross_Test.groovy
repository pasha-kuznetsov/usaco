package usaco_2017_feb_1

import spock.lang.Specification
import spock.lang.Unroll
import testutils.ResourceDir

class MinCross_Test extends Specification {
    @Unroll
    def "test #expectedOutput"() {
        def fields = input.split()
        int n = fields.size() / 2
        def inputStream = new StringReader((n + '\n' + fields.join('\n')))
        def output = new Output()

        when:
        MinCross.main(inputStream, output.print)

        then:
        output.string == expectedOutput

        where:
        input                     | expectedOutput
        '''1 3 2 5 4
           5 4 1 3 2'''   | '0'
        // 1 3 2 5 4    << 2

        '''1 2 3 5 4
           2 3 4 5 1'''   | '1'
        // 1 2 3 4 5    << 4

        '''1 2 3 4 5 6
           6 5 1 3 2 4''' | '2'
        // 1 3 2 4 6 5  << 2

        '''2 3 4 5 6 1
           6 5 1 3 2 4''' | '2'
        // 3 2 4 6 5 1  << 3

        '''2 3 4 5 6 1
           6 5 1 3 2 4''' | '2'
        // 3 2 4 6 5 1  << 3
    }

    @Unroll
    def "test data #dataFiles"() {
        def expectedOutput = new Scanner(dataFiles.output).nextLong()
        def input = new FileReader(dataFiles.input)
        def output = new Output()

        when:
        MinCross.main(input, output.print)

        then:
        output.string as long == expectedOutput

        where:
        dataFiles << new ResourceDir(this.class.name)
    }

    static class Output {
        OutputStream stream = new ByteArrayOutputStream()
        PrintStream print = new PrintStream(stream, true)
        String getString() { return stream.toString() }
    }
}

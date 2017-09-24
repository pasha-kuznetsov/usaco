package testutils

class TestOutput {
    OutputStream stream = new ByteArrayOutputStream()
    PrintStream print = new PrintStream(stream, true)
    String getString() { return stream.toString() }
}

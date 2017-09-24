package testutils

class DataFiles {
    final File input
    final File output

    DataFiles(File input, File output) {
        this.input = input
        this.output = output
    }

    @Override
    public String toString() { return input.name.replace('.in', '') }
}

package testutils

class ResourceDir implements Iterable<DataFiles> {
    String dirName
    DataFilesIterator iterator

    ResourceDir(String dirName) { this.dirName = dirName }

    @Override
    Iterator<DataFiles> iterator() { return this.iterator = new DataFilesIterator() }

    class DataFilesIterator implements Iterator<DataFiles> {
        Queue<DataFiles> inputFiles = new ArrayDeque<>()

        DataFilesIterator() {
            ClassLoader loader = getClass().getClassLoader()
            for (URL url : loader.getResources(dirName.replace('.', '/'))) {
                if (!url.file.contains('/resources/')) continue
                for (File input : new File(url.file).listFiles()) {
                    if (!input.path.endsWith('.in')) continue
                    File output = new File(input.path.replace('.in', '.out'))
                    inputFiles.add(new DataFiles(input, output))
                }
            }
        }

        @Override boolean hasNext() { !inputFiles.isEmpty() }
        @Override DataFiles next() { inputFiles.poll() }
    }
}

package usaco_2017_feb_2;

import java.io.FileReader;
import java.io.PrintStream;
import java.io.Reader;

public class NoCross {
    public static void main(String [] args) throws Exception {
        try (PrintStream out = new PrintStream("nocross.out")) {
            try {
                try (Reader in = new FileReader("nocross.in")) {
                    main(in, out);
                }
            } catch (Exception ex) {
                ex.printStackTrace(out);
            }
        }
    }

    static void main(Reader in, PrintStream out) {
    }
}

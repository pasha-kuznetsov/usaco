package usaco_2017_feb_1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinCross {
    public static void main(String [] args) throws FileNotFoundException {
        main(new Scanner("mincross.in"), new PrintStream("mincross.out"));
    }

    static void main(Scanner in, PrintStream out) {
        int n = in.nextInt();
        List<Integer> fields1 = readFields(in, n);
        List<Integer> fields2 = readFields(in, n);
        out.print(minCrossingPairs(fields1, fields2));
    }

    private static List<Integer> readFields(Scanner in, int n) {
        List<Integer> fields = new ArrayList<>(n);
        for (int i = 0; i < n; ++i)
            fields.add(in.nextInt());
        return fields;
    }

    static int minCrossingPairs(List<Integer> fields1, List<Integer> fields2) {
        return 0;
    }
}

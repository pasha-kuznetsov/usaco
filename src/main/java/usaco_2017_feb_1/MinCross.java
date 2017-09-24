package usaco_2017_feb_1;

import java.io.*;
import java.util.HashMap;

public class MinCross {
    public static void main(String [] args) throws Exception {
        try (PrintStream out = new PrintStream("mincross.out")) {
            try {
                try (Reader in = new FileReader("mincross.in")) {
                    main(in, out);
                }
            } catch (Exception ex) {
                ex.printStackTrace(out);
            }
        }
    }

    static void main(Reader in, PrintStream out) throws Exception {
        try (BufferedReader buf = new BufferedReader(in)) {
            int n = nextInt(buf);
            MinCross minCross1 = new MinCross(n);
            for (int i1 = 0; i1 < n; ++i1) minCross1.add1(i1, nextInt(buf));
            for (int i2 = 0; i2 < n; ++i2) minCross1.add2(i2, nextInt(buf));
            long min1 = minCross1.minPairs(minCross1.pos1by2);
            long min2 = minCross1.minPairs(minCross1.pos2by1);
            out.print(Math.min(min1, min2));
        }
    }

    private static int nextInt(BufferedReader buf) throws Exception {
        return Integer.parseInt(buf.readLine().trim());
    }

    private final HashMap<Integer, Integer> pos1Map = new HashMap<>();
    private final int[] pos1by2;
    private final int[] pos2by1;

    private MinCross(int n) {
        this.pos1by2 = new int[n];
        this.pos2by1 = new int[n];
    }

    private void add1(int i1, int field) {
        pos1Map.put(field, i1);
    }

    private void add2(int i2, int field) {
        int i1 = pos1Map.get(field);
        pos1by2[i2] = i1;
        pos2by1[i1] = i2;
    }

    private long minPairs(int[] positions) {
        long bestShift = 0, shift = 0;
        for (int pos : positions) {                // moving pos to the back:
            shift += positions.length - pos - 1;   // adds this many inversions
            shift -= pos;                          // removes this many inversions
            if (shift < bestShift) bestShift = shift;
        }
        return new MergeCount().countInversions(positions) + bestShift;
    }
}

class MergeCount {
    private long inversions;

    long countInversions(int[] array) {
        sort(array, 0, array.length);
        return inversions;
    }

    private void sort(int[] array, int begin, int end) {
        int n = end - begin;
        if (n < 2) return;
        int m = begin + n / 2;
        sort(array, begin, m);
        sort(array, m, end);
        merge(array, begin, m, end);
    }

    private void merge(int[] arr, int begin, int m, int end) {
        int[] out = new int[end - begin];
        for (int l = begin, r = m, i = 0; l < m || r < end;) {
            while (l < m && (r == end || arr[l] <= arr[r])) out[i++] = arr[l++];
            while (r < end && (l == m || arr[r] >= arr[l])) out[i++] = arr[r++];
            while (r < end && (l == m || arr[r] < arr[l])) { out[i++] = arr[r++]; inversions += m - l; }
        }
        System.arraycopy(out, 0, arr, begin, out.length);
    }
}

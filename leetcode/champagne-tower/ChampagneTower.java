import java.util.ArrayList;
import java.util.List;

public class ChampagneTower {
    public static void main(String[] args) {
        int poured = 100000009;
        int query_row = 33;
        int query_glass = 17;

        System.out.println(champagneTower(poured, query_row, query_glass));

        poured = 2;
        query_row = 1;
        query_glass = 1;
        System.out.println(champagneTower(poured, query_row, query_glass));
    }

    private static double champagneTower(int poured, int query_row, int query_glass) {
        List<List<Double>> allRows = new ArrayList<>();

        List<Double> currRow = new ArrayList<>();
        currRow.add((double) poured);
        allRows.add(currRow);

        for (int i = 1; i <= query_row; i++) {
            List<Double> prevRow = allRows.get(i - 1);
            currRow = new ArrayList<>();

            currRow.add(Math.max(0d, (prevRow.get(0) - 1)) / 2.0);

            // this loop will run for (row_len + 1) to (row_len - 1)
            for (int j = 1; j < i; j++) {
                double champagneFromLeft = Math.max(0d, (prevRow.get(j - 1) - 1) / 2.0);
                double champagneFromRight = Math.max(0d, (prevRow.get(j) - 1) / 2.0);

                currRow.add(champagneFromLeft + champagneFromRight);
            }

            currRow.add(Math.max(0d, (prevRow.get(i - 1) - 1) / 2.0));

            allRows.add(currRow);
        }

        return Math.min(1d, allRows.get(query_row).get(query_glass));
    }
}

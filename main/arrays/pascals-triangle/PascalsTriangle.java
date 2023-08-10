import java.util.ArrayList;
import java.util.List;

/**
 * NOTES:<br>
 * Each row is built using sum of prev row's ith and (i-1)th element Since prev row is one element
 * less than curr row in size, therefore last element of curr row would be (0 +
 * last_element_of_prev_row), as implemented
 * <br>
 * <br>
 * One better way of writing it will be, add 1 for zeroth and last idx of each element
 * <pre>
 *  if (idx == 0 || idx == currRow.len) {
 *     currRow.add(1);
 *  }
 * </pre>
 */

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(List.of(1));

        for (int j = 1; j < numRows; j++) {
            List<Integer> prevList = result.get(j - 1);
            List<Integer> tempList = new ArrayList<>();

            tempList.add(1);

            for (int i = 1; i < prevList.size() + 1; i++) {
                int a = prevList.get(i - 1);
                int b = i < prevList.size() ? prevList.get(i) : 0;

                tempList.add(a + b);
            }

            result.add(new ArrayList<>(tempList));
        }

        return result;
    }
}

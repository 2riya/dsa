import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NQueens {
    public static void main(String[] args) {
        int input = 2;
        System.out.println(solveNQueens(input));

        input = 3;
        System.out.println(solveNQueens(input));

        input = 1;
        System.out.println(solveNQueens(input));
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<char[]> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] boardRow = new char[n];
            Arrays.fill(boardRow, '.');
            board.add(boardRow);
        }

        return solve(board, 0, n);

    }

    private static List<List<String>> solve(List<char[]> board, int currQueen, int n) {
        List<List<String>> result = new ArrayList<>();

        if (currQueen == n) {
            result.add(board.stream().map(String::new).collect(Collectors.toList()));
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (canPlace(board, currQueen, i)) {
                // place queen
                board.get(currQueen)[i] = 'Q';

                // call for other queens
                result.addAll(solve(board, currQueen + 1, n));

                // backtrack
                board.get(currQueen)[i] = '.';
            }
        }

        return result;
    }

    private static boolean canPlace(List<char[]> board, int row, int col) {
        // up
        for (int i = row; i >= 0; i--) {
            if (board.get(i)[col] == 'Q') {
                return false;
            }
        }

        // diagonally up
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i)[j] == 'Q') {
                return false;
            }
        }

        // antidiagonally up
        for (int i = row, j = col; i >= 0 && j < board.size(); i--, j++) {
            if (board.get(i)[j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}

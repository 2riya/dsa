import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] m = new int[][] {{1,1,1},{1,0,1},{1,1,1}};
        int[][] m2 = new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        setMatrixZeroes(m);
        setMatrixZeroes(m2);
    }

    private static void setMatrixZeroes(int[][] m) {
        boolean row = false;
        boolean col = false;

        for (int i = 0; i < m[0].length; i++) {
            if (m[0][i] == 0) {
                row = true;
                break;
            }
        }

        for (int j = 0; j < m.length; j++) {
            if (m[j][0] == 0) {
                col = true;
                break;
            }
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    m[i][0] = m[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][0] == 0 || m[0][j] == 0) {
                    m[i][j] = 0;
                }
            }
        }

        if (row) {
            Arrays.fill(m[0], 0);
        }

        if (col) {
            for (int j = 0; j < m.length; j++) {
                m[j][0] = 0;
            }
        }
    }
}


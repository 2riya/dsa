public class Candy {
    public static void main(String[] args) {
        int[] ratings = {8, 4, 2, 1, 3, 6, 7, 9, 5};
        int result = candiesLinear(ratings);
        result = candiesQuadraticTC(ratings);
    }

    private static int candiesQuadraticTC(int[] ratings) {
        int[] candies = new int[ratings.length];

        candies[0] = 1;

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }

            int j = i;
            // backtrack to check if condition is being met for prev neighbors
            while (j > 0 && ratings[j - 1] > ratings[j]) {
                candies[j - 1] = Math.max(candies[j - 1], candies[j] + 1);
                j--;
            }
        }

        int totalCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            totalCandies += candies[i];
        }

        return totalCandies;
    }

    private static int candiesLinear(int[] ratings) {
        int[] candies = new int[ratings.length];

        candies[0] = 1;
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }

        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int totalCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            totalCandies += candies[i];
        }

        return totalCandies;
    }

    private int candiesSpaceOptimized(int[] rankings) {
        return -1;
    }
}

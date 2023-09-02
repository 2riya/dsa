import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinTapsToWaterGarden {
    public static void main(String[] args) {
        minTaps(9, new int[]{0,5,0,3,3,3,1,4,0,4});
        minTaps(4, new int[]{0,0,0,0});
        minTaps(5, new int[]{3,4,1,1,0,0});

    }

    private static int minTaps(int n, int[] ranges) {
        /* create intervals */
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            int leftRange = i - ranges[i] < 0 ? 0 : i - ranges[i];
            int rightRange = i + ranges[i] > n ? n : i + ranges[i];
            intervals.add(new int[]{leftRange, rightRange});
        }

        /* sort intervals */
        Collections.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

        /*traverse to find valid intervals*/
        List<int[]> result = new ArrayList<>();

        /* add first interval */
        result.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            int len = result.size() - 1;

            int currLeft = intervals.get(i)[0];
            int currRight = intervals.get(i)[1];

            /* if curr start and prev interval's start is same,
             skip curr interval
             as due to sorting,
             greater range will be of prev interval's right*/
            if (currLeft == result.get(len)[0]) {
                continue;
            }

            /* check if there's a gap between last int and current int */
            if (result.get(len)[1] < currLeft) {
                return -1;
            }

            /* if prev right is lesser than curr right, it means range can be expanded */
            if (result.get(len)[1] < currRight) {
                while (len > 0 /* 2 intervals should exist, 0 because n represents indices */
                    && result.get(len)[1] < currRight /* prev right is lesser than curr right */
                    && currLeft <= result.get(len - 1)[1] /* ensure that there exists an interval in res that overlaps currLeft */
                ) {
                    result.remove(len);
                    len = result.size() - 1;
                }

                result.add(intervals.get(i));
            }
        }

        return result.size();
    }
}

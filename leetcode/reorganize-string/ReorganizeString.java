import java.util.PriorityQueue;
import java.util.Random;

public class ReorganizeString {
    public static void main(String[] args) {
        String input = "baaba";

        int choice = Math.abs(new Random().nextInt() % 2);
        String result = switch (choice) {
            case 0 -> maxHeapImpl(input);
            case 1 -> evenOdd(input);
            default -> "";
        };

        System.out.println(result);
    }

    private static String maxHeapImpl(String input) {
        int n = input.length();
        int[] ht = new int[26];

        char[] str = input.toCharArray();

        for (char c : str) {
            ht[c - 'a']++;

            // if any character is majority element, i.e., appears more than ceil(len/2), there will be at least 1 consecutive occurrence of it
            if (ht[c - 'a'] > (n + 1) / 2) {
                return "";
            }
        }

        // max heap to store chars by their frequency
        PriorityQueue<Character> pq = new PriorityQueue<>((o1, o2) -> ht[o2 - 'a'] - ht[o1 - 'a']);

        // add characters to max heap
        for (int i = 0; i < ht.length; i++) {
            if (ht[i] != 0) {
                pq.add((char) (i + 'a'));
            }
        }

        StringBuilder res = new StringBuilder();

        while (pq.size() > 1) {
            // poll 2 top most frequent chars
            char f = pq.poll();
            char s = pq.poll();

            res.append(f);
            res.append(s);

            ht[f - 'a']--;
            ht[s - 'a']--;

            // re-insert into heap if all chars have not been consumed yet
            if (ht[f - 'a'] > 0) {
                pq.add(f);
            }

            if (ht[s - 'a'] > 0) {
                pq.add(s);
            }
        }

        // for odd no. of chars, there might be 1 char remaining in the end (since we were initially polling in pairs)
        if (!pq.isEmpty()) {
            res.append(pq.poll());
        }

        return res.toString();
    }

    private static String evenOdd(String input) {
        int n = input.length();
        int[] ht = new int[26];

        char[] str = input.toCharArray();

        int maxFreq = 0;
        int maxFreqChar = '0';

        for (char c : str) {
            ht[c - 'a']++;

            // if any character is majority element, i.e., appears more than ceil(len/2), there will be at least 1 consecutive occurrence of it
            if (ht[c - 'a'] > (n + 1) / 2) {
                return "";
            }

            // capture max frequency and its corresponding char
            if (ht[c - 'a'] > maxFreq) {
                maxFreq = ht[c - 'a'];
                maxFreqChar = c - 'a';
            }
        }


        char[] res = new char[str.length];

        // populate most frequent char first
        int idx = 0;
        while (ht[maxFreqChar] > 0) {
            res[idx] = (char) (maxFreqChar + 'a');
            idx += 2;
            ht[maxFreqChar]--;
        }

        int i = 0; // hash table iterator

        // iterate over hash table to populate other chars to result
        while (i < ht.length) {
            if (ht[i] == 0) {
                i++;
                continue;
            }

            if (idx >= res.length) {
                idx = 1;
            }

            res[idx] = (char) (i + 'a');
            idx += 2;
            ht[i]--;
        }


        return new String(res);
    }
}

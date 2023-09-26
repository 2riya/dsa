import java.util.ArrayDeque;

public class RemoveDuplicateLettersLex {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bbcaac"));
    }

    public static String removeDuplicateLetters(String s) {
        int[] charFrequency = new int[26];

        boolean[] visited = new boolean[26];

        // monotonically increasing stack
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            charFrequency[ch - 'a']++;
        }

        for (char ch : s.toCharArray()) {
            if (!visited[ch - 'a']) {
                while (!stack.isEmpty() && stack.peekLast() > ch && charFrequency[stack.peekLast() - 'a'] > 0) {
                    visited[stack.pollLast() - 'a'] = false;
                }

                stack.add(ch);
                visited[ch - 'a'] = true;
            }

            charFrequency[ch - 'a']--; // done outside `if` for consecutive occurrence of same char, e.g.: `b` in "bbcaac"
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}

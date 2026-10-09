import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int count = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                String word = q.poll();

                if (word.equals(endWord)) return count;

                char[] ch = word.toCharArray();

                for (int i = 0; i < ch.length; i++) {
                    char old = ch[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        ch[i] = c;
                        String next = new String(ch);

                        if (set.contains(next)) {
                            q.offer(next);
                            set.remove(next);
                        }
                    }

                    ch[i] = old;
                }
            }

            count++;
        }

        return 0;
    }
}

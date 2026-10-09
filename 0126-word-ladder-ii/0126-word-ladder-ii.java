import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord)) return ans;

        Map<String, List<String>> parents = new HashMap<>();
        Set<String> level = new HashSet<>();
        level.add(beginWord);

        boolean found = false;

        while (!level.isEmpty() && !found) {
            dict.removeAll(level);
            Set<String> nextLevel = new HashSet<>();

            for (String word : level) {
                char[] ch = word.toCharArray();

                for (int i = 0; i < ch.length; i++) {
                    char old = ch[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;

                        ch[i] = c;
                        String next = new String(ch);

                        if (dict.contains(next)) {
                            nextLevel.add(next);

                            parents.computeIfAbsent(next, k -> new ArrayList<>())
                                   .add(word);

                            if (next.equals(endWord)) found = true;
                        }
                    }

                    ch[i] = old;
                }
            }

            level = nextLevel;
        }

        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            dfs(endWord, beginWord, parents, path, ans);
        }

        return ans;
    }

    private void dfs(String word, String beginWord,
                     Map<String, List<String>> parents,
                     List<String> path,
                     List<List<String>> ans) {

        if (word.equals(beginWord)) {
            List<String> result = new ArrayList<>(path);
            Collections.reverse(result);
            ans.add(result);
            return;
        }

        for (String parent : parents.getOrDefault(word, Collections.emptyList())) {
            path.add(parent);
            dfs(parent, beginWord, parents, path, ans);
            path.remove(path.size() - 1);
        }
    }
}

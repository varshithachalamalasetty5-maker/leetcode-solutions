class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode();

        // Build Trie
        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        List<String> result = new ArrayList<>();

        // Search in board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j,
                     TrieNode node, List<String> result) {

        char c = board[i][j];

        if (c == '#' || node.children[c - 'a'] == null) {
            return;
        }

        node = node.children[c - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';

        if (i > 0)
            dfs(board, i - 1, j, node, result);

        if (j > 0)
            dfs(board, i, j - 1, node, result);

        if (i < board.length - 1)
            dfs(board, i + 1, j, node, result);

        if (j < board[0].length - 1)
            dfs(board, i, j + 1, node, result);

        board[i][j] = c;
    }
}
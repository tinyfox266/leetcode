public class Solution {
    LinkedList<String> rst = new LinkedList<String>();
    public List<String> findWords(char[][] board, String[] words) {
        List<String> existWords = new LinkedList<String>();
        if (board==null || board.length == 0
                || board[0]==null || board[0].length == 0
                || words == null || words.length == 0)
            return existWords;

        Trie trie = new Trie();
        for (String word:words) {
            trie.insert(word);
        }
        boolean [][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i < board.length; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i=0; i < board.length; i++) {
            for (int j=0; j < board[0].length; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }

        return rst;

    }

    public void dfs(char[][]board, boolean [][] visited, String str, int x, int y, Trie trie) {
        if (x<0 || x>=board.length || y < 0 || y >= board[0].length)
            return;
        if (visited[x][y])
            return;
        str += board[x][y];
        if (!trie.startsWith(str))
            return;

        if (trie.search(str)) {
            if (!rst.contains(str))
                rst.add(str);
        }
        visited[x][y] = true;
        dfs(board, visited, str, x,y-1, trie);
        dfs(board, visited, str, x,y+1, trie);
        dfs(board, visited, str, x-1,y, trie);
        dfs(board, visited, str, x+1,y, trie);
        visited[x][y] = false;
    }
}

class TrieNode {
    char val;
    TrieNode [] sons;
    boolean isEnd;

    public TrieNode() {
        sons = new TrieNode[26];
        isEnd = false;
    }
}

class Trie{
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        TrieNode node = root;
        for (int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            int pos = c-'a';
            if (node.sons[pos] == null)
                node.sons[pos] = new TrieNode();
            node.sons[pos].val = c;
            node = node.sons[pos];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        TrieNode node = root;
        for (int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            int pos = c-'a';
            if (node.sons[pos] == null)
                return false;
            node = node.sons[pos];
        }
        if (node.isEnd)
            return true;

        return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0)
            return false;
        TrieNode node = root;
        for (int i=0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int pos = c-'a';
            if (node.sons[pos] == null)
                return false;
            node = node.sons[pos];
        }

        return true;
    }
}

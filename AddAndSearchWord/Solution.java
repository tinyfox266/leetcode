public class WordDictionary {

    Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        trie.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchFromNode(word, trie.root);
    }

    public boolean searchFromNode(String word, TrieNode node) {
        if (word.length() == 0)
            return node.isEnd;
        char [] letters = word.toCharArray();
        if (letters[0] != '.') {
            int pos = letters[0] - 'a';
            if (node.son[pos] == null)
                return false;
            if (node.son[pos].val != letters[0])
                return false;
            return searchFromNode(word.substring(1, word.length()), node.son[pos]);
        } else {
            for (int j=0; j < 26; j++) {
                if (node.son[j] != null) {
                    boolean r = searchFromNode(word.substring(1, word.length()), node.son[j]);
                    if (r == true)
                        return true;
                }
            }
        }


        return false;
    }
}

class TrieNode {
    // Initialize your data structure here.
    public TrieNode [] son;
    public boolean isEnd;
    public char val;
    public TrieNode() {
        son = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word == null || word.length() == 0)
            return;
        TrieNode node = root;
        char [] letters = word.toCharArray();
        for (int i=0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) {
                node.son[pos] = new TrieNode();
                node.son[pos].val = letters[i];
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
        char [] letters = word.toCharArray();
        TrieNode node = root;
        for (int i=0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null)
                return false;
            node = node.son[pos];
        }

        return node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0)
            return false;
        char [] letters = prefix.toCharArray();
        TrieNode node = root;
        for (int i=0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null)
                return false;
            node = node.son[pos];
        }

        return true;
    }
}


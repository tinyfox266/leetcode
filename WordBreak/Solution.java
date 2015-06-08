public class Solution {
    private Set<String> unmatch = new HashSet<String>();
    
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s==null || s.length() == 0)
            return false;

        return wordBreak_(s, wordDict);
    }
    public boolean wordBreak_(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0)
            return true;
        
        if (unmatch.contains(s))
            return false;

        for (String word: wordDict) {
            if (s.length() < word.length())
                continue;
            if (word.equals(s.substring(0, word.length()))) {
                boolean r = wordBreak_(s.substring(word.length()), wordDict);
                if (r == true)
                    return true;
            }
        }
        unmatch.add(s);
        return false;
    }
}

public class Solution {
    public HashMap<String, List<String>> breaks = new HashMap<String, List<String>>();

    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (breaks.get(s) != null)
            return breaks.get(s);

        List<String> res = new LinkedList<String>();

        for (String word: wordDict) {
            if (s.length() < word.length())
                continue;

            if (s.equals(word)) {
                res.add(s);
            } else if (s.startsWith(word)) {
                List<String> subRes = wordBreak(s.substring(word.length()), wordDict);
                for (String subSentence: subRes) {
                    res.add(word + " " + subSentence);
                }
            }

        }

        breaks.put(s, res);

        return res;
    }
}


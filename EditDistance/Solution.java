public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0)
            return word2.length();
        if (word2 == null || word2.length() == 0)
            return word1.length();
        int [][] dist = new int [word1.length()+1][word2.length()+1];

        for (int i=0; i < word1.length()+1; i++) {
            dist[i][0] = i;
        }

        for (int j=0; j < word2.length()+1; j++) {
            dist[0][j] = j;
        }

        for (int i=0; i < word1.length(); i++) {
            for (int j=0; j < word2.length(); j++) {
                char c1 = word1.charAt(i);
                char c2 = word2.charAt(j);
                if (c1 == c2) {
                    dist[i+1][j+1] = dist[i][j];
                } else {
                    dist[i+1][j+1] = Math.min(dist[i][j+1], dist[i+1][j]);
                    dist[i+1][j+1] = Math.min(dist[i+1][j+1], dist[i][j]) + 1;
                }
            }
        }

        return dist[word1.length()][word2.length()];
    }
}

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        Set<String> resSet = new HashSet<String>();


        if (s == null || s.length() < 10)
            return res;

        HashSet<Integer> exists = new HashSet<Integer>();


        for (int i=0; i < s.length()-9; i++) {
            String sub = s.substring(i,i+10);
            int n = toInt(sub);
            if (exists.contains(n)) {
                resSet.add(sub);
            } else {
                exists.add(n);
            }
        }
        
        res.addAll(resSet);
        
        return res;

    }

    private int toInt(String s) {
        int sum=0;
        for (int i=0; i < s.length(); i++) {
            char c= s.charAt(i);
            switch (c) {
                case 'A': sum=sum*4+0;
                    break;
                case 'G': sum=sum*4+1;
                    break;
                case 'T': sum=sum*4+2;
                    break;
                case 'C': sum=sum*4+3;
                    break;
            }
        }

        return sum;
    }
}

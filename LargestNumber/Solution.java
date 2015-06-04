public class Solution {
    public String largestNumber(int[] nums) {
        String largest = new String();
        if (nums.length == 0)
            return largest;

        List<String> numsStr = new LinkedList<String>();
        for (int n:nums) {
            numsStr.add(Integer.toString(n));
        }
        Collections.sort(numsStr, new Comparator<String>() {
            @Override
            public int compare(String s, String s2) {
                if (s.startsWith(s2)) {
                    if (s.length() > s2.length()) {
                        return this.compare(s.substring(s2.length()),s2);
                    }
                    return 0;
                }
                if (s2.startsWith(s)) {
                    if (s2.length() > s.length()) {
                        return this.compare(s, s2.substring(s.length()));
                    }
                    return 0;
                }

                return s.compareTo(s2);
            }
        });
        int flag=0;
        for (int i=numsStr.size()-1; i >= 0; i--) {
            String num = numsStr.get(i);
            if (Integer.parseInt(num) == 0 && flag == 0)
                continue;
            flag = 1;
            largest += numsStr.get(i);
        }

        if (largest.equals(""))
            return "0";
        return largest;
    }
}

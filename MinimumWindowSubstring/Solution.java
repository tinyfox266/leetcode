public class Solution {
    public String minWindow(String s, String t) {
        Set<Character> targets = new HashSet<Character>();
        if (t == null || t.length() == 0)
            return "";

        if (t.length() == 1) {
            for (int i=0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(0))
                    return t;
            }
            return "";
        }

        HashMap<Character, Integer> targetTimes = new HashMap<Character, Integer>();

        for (int i=0; i < t.length(); i++) {
            char c = t.charAt(i);
            targets.add(c);
            if (targetTimes.get(c) == null) {
                targetTimes.put(c, 1);
            } else {
                targetTimes.put(c, targetTimes.get(c)+1);
            }
        }

        List<Integer> targetInWin = new LinkedList<Integer>();
        Set<Character> targetCharsInWin = new HashSet<Character>();
        int start=-1, end=0;
        HashMap<Integer, Integer> next = new HashMap<Integer, Integer>();
        HashMap<Character, Integer> times = new HashMap<Character, Integer>();

        boolean found=false;

        outer:
        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!found) {
                // the first window is not found
                if (targets.contains(c)) {
                    if (start == -1)
                        start = i;
                    if (!targetInWin.isEmpty()) {
                        next.put(targetInWin.get(targetInWin.size()-1),i);
                    }
                    targetInWin.add(i);
                    targetCharsInWin.add(c);
                    if (times.get(c) == null) {
                        times.put(c, 1);
                    } else {
                        times.put(c, times.get(c)+1);
                    }

                    // judge if window is found
                    for (char targetc: targets) {
                        if (times.get(targetc) == null)
                            continue outer;
                        if (times.get(targetc) < targetTimes.get(targetc))
                            continue outer;

                    }


                    found = true;
                    end = i;

                    // shorten the window
                    int endTmp = i;
                    int startTmp = start;

                    char c1 = s.charAt(startTmp);
                    while (times.get(c1) > targetTimes.get(c1)) {
                        times.put(c1, times.get(c1)-1);
                        startTmp = next.get(targetInWin.get(0));
                        targetInWin.remove(0);
                        c1 = s.charAt(startTmp);
                    }
                    if (endTmp - startTmp < end - start) {
                        start = startTmp;
                        end = endTmp;
                    }

                }
            } else {
                // at least one valid window is found 
                if (targets.contains(c)) {
                    if (c == s.charAt(targetInWin.get(0))) {
                        // shorten the window
                        next.put(targetInWin.get(targetInWin.size()-1),i);
                        targetInWin.add(i);
                        int endTmp = i;
                        int startTmp = next.get(targetInWin.get(0));
                        targetInWin.remove(0);
                        char c1 = s.charAt(startTmp);
                        while (times.get(c1) > targetTimes.get(c1)) {
                            times.put(c1, times.get(c1)-1);
                            startTmp = next.get(targetInWin.get(0));
                            targetInWin.remove(0);
                            c1 = s.charAt(startTmp);
                        }
                        if (endTmp - startTmp < end - start) {
                            start = startTmp;
                            end = endTmp;
                        }
                    } else {
                        times.put(c, times.get(c)+1);
                        next.put(targetInWin.get(targetInWin.size()-1),i);
                        targetInWin.add(i);
                    }
                }
            }
        }

        if (!found)
            return "";

        return s.substring(start, end+1);
    }
}



public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<String>();
        if (words == null || words.length == 0) {
            if (maxWidth == 0) {
                res.add("");
            }
            return res;
        }

        if (maxWidth < 0) {
            return res;
        }
        List<List<String>> lines = new LinkedList<List<String>>();

        List<String> curLine = new LinkedList<String>();
        int curWidth=0;
        String word=null;
        for (int i=0; i < words.length; i++) {
            word = words[i];
            if (curWidth + word.length() <= maxWidth) {
                curWidth += word.length()+1;
                curLine.add(word);
                if (i == words.length-1) {
                    lines.add(curLine);
                }
            } else {
                lines.add(new LinkedList<String>(curLine));
                curLine.clear();
                curWidth = 0;
                i--;
            }
        }




        return pad(lines, maxWidth);

    }

    private List<String> pad(List<List<String>> lines, int maxWidth) {
        List<String> res = new LinkedList<String>();
        for (int i=0; i < lines.size(); i++) {
            List<String> line = lines.get(i);

            int num = charNum(line);

            if (maxWidth == num) {
                for (String s: line) {
                    res.add(s);
                }
                continue;
            }

            if (i == lines.size()-1) {
                String finalLine = "";
                for (String s: line) {
                    finalLine += s + " ";
                }
                finalLine = finalLine.substring(0, finalLine.length()-1);

                for (int j=0; j < maxWidth-num-line.size()+1; j++) {
                    finalLine = finalLine + " ";
                }

                res.add(finalLine);
                continue;
            }



            for (int j=0; j < maxWidth-num; j++) {
                if (line.size() == 1) {
                    String s = line.get(0);
                    line.set(0, s + " ");
                    continue;
                }

                int index = j%(line.size()-1);
                String s = line.get(index);
                line.set(index, s + " ");
            }


            String finalList = "";

            for (String s: line) {
                finalList += s;
            }

            res.add(finalList);

        }

        return res;
    }

    private int charNum(List<String> line) {
        int num=0;
        for (String s: line) {
            num += s.length();
        }

        return num;
    }
}


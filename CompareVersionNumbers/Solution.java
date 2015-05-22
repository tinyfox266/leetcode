public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");
        int i;
        for (i = 0; i < versionArray1.length && i < versionArray2.length; i++) {
            int n1 = Integer.parseInt(versionArray1[i]);
            int n2 = Integer.parseInt(versionArray2[i]);
            if (n1 < n2)
                return -1;
            if (n1 > n2)
                return 1;
        }

        if (versionArray1.length < versionArray2.length) {
            for (int j = i; j < versionArray2.length; j++) {
                if (Integer.parseInt(versionArray2[j]) > 0)
                    return -1;
            }
            return 0;

        } else if (versionArray1.length > versionArray2.length) {
            for (int j = i; j < versionArray1.length; j++) {
                if (Integer.parseInt(versionArray1[j]) > 0)
                    return 1;
            }

            return 0;
        }
        else
            return 0;

    }
}

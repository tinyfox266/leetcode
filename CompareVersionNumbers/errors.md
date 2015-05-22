# Compare Version Numbers
------------------------------------------
------------------------------------------
## Error
Wrong Answer

Input:  "01", "1"

Output: -1

Expected:   0

## Submitted Code

    public class Solution {
        public int compareVersion(String version1, String version2) {
            String [] versionArray1 = version1.split("\\.");
            String [] versionArray2 = version2.split("\\.");
            String high1 = versionArray1[0];
            String high2 = versionArray2[0];
            if (high1.compareTo(high2) > 0)
                return 1;
            else if (high1.compareTo(high2) < 0)
                return -1;
            else {
                if (versionArray1.length > 1 && versionArray1.length <=1) {
                    return 1;
                } else if (versionArray1.length <=1 && versionArray2.length >1) {
                    return -1;
                } else if (versionArray1.length == 1 && versionArray2.length == 1) {
                    return 0;
                } else {
                    return high1.compareTo(high2);
                }
            }

        }
    }

------------------------------------------
------------------------------------------

## Error
Wrong Answer

Input:  "1.0", "1.1"

Output: 0

Expected:   -1

## Submitted Code

    public class Solution {
        public int compareVersion(String version1, String version2) {
            String [] versionArray1 = version1.split("\\.");
            String [] versionArray2 = version2.split("\\.");
            int high1 = Integer.parseInt(versionArray1[0]);
            int high2 = Integer.parseInt(versionArray2[0]);

            if (high1 > high2)
                return 1;
            else if (high1 < high2)
                return -1;
            else {
                if (versionArray1.length > 1 && versionArray1.length <=1) {
                    return 1;
                } else if (versionArray1.length <=1 && versionArray2.length >1) {
                    return -1;
                } else if (versionArray1.length == 1 && versionArray2.length == 1) {
                    return 0;
                } else {
                    if (high1 > high2)
                        return 1;
                    else if (high1 < high2)
                        return -1;
                    else
                        return 0;
                }
            }

        }
    }

------------------------------------------
------------------------------------------

## Error
Wrong Answer

Input:  "10.6.5", "10.6"

Output: 0

Expected:   1

## Submitted Code
    public class Solution {
       public int compareVersion(String version1, String version2) {
            String [] versionArray1 = version1.split("\\.");
            String [] versionArray2 = version2.split("\\.");
            int high1 = Integer.parseInt(versionArray1[0]);
            int high2 = Integer.parseInt(versionArray2[0]);

            if (high1 > high2)
                return 1;
            else if (high1 < high2)
                return -1;
            else {
                if (versionArray1.length > 1 && versionArray2.length <=1) {
                    if (Integer.parseInt(versionArray1[1]) == 0)
                        return 0;

                    return 1;
                } else if (versionArray1.length <=1 && versionArray2.length >1) {
                    if (Integer.parseInt(versionArray2[1]) == 0)
                        return 0;

                    return -1;
                } else if (versionArray1.length == 1 && versionArray2.length == 1) {
                    return 0;
                } else {
                    int low1 = Integer.parseInt(versionArray1[1]);
                    int low2 = Integer.parseInt(versionArray2[1]);
                    if (low1 > low2)
                        return 1;
                    else if (low1 < low2)
                        return -1;
                    else
                        return 0;
                }
            }

        }
    }

------------------------------------------
------------------------------------------

## Error
Compile Error

Line 3: error: illegal start of expression

## Submitted Code
    public class Solution {
       public int compareVersion(String version1, String version2) {
        public int compareVersion(String version1, String version2) {
            String [] versionArray1 = version1.split("\\.");
            String [] versionArray2 = version2.split("\\.");
            for (int i=0; i < versionArray1.length && i < versionArray2.length; i++) {
                int n1 = Integer.parseInt(versionArray1[i]);
                int n2 = Integer.parseInt(versionArray2[i]);
                if (n1 < n2)
                    return -1;
                if (n1 > n2)
                    return 1;
            }

            if (versionArray1.length < versionArray2.length) {
                return -1;
            } else if (versionArray1.length > versionArray2.length)
                return 1;
            else
                return 0;

        }
    }

------------------------------------------
------------------------------------------

## Error
Wrong Answer

Input:  "1.0", "1"

Output: 1

Expected:   0

## Submitted Code
    public class Solution {
       public int compareVersion(String version1, String version2) {
            String [] versionArray1 = version1.split("\\.");
            String [] versionArray2 = version2.split("\\.");
            for (int i=0; i < versionArray1.length && i < versionArray2.length; i++) {
                int n1 = Integer.parseInt(versionArray1[i]);
                int n2 = Integer.parseInt(versionArray2[i]);
                if (n1 < n2)
                    return -1;
                if (n1 > n2)
                    return 1;
            }

            if (versionArray1.length < versionArray2.length) {
                return -1;
            } else if (versionArray1.length > versionArray2.length)
                return 1;
            else
                return 0;

        }
    }

------------------------------------------
------------------------------------------

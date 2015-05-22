# Factorial Trailing Zeroes
-----------------------------------------
-----------------------------------------
## Error
Time Limit Exceeded

Last executed input:    1808548329

## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {
            int fiveCount = 0;
            for (int i=1; i <=n; i++ ){
                fiveCount += (i%5==0)?i/5:0;
            }
            return fiveCount;
        }
    }

------------------------------------------
------------------------------------------

## Error
Wrong Answer

Input:  10

Output: 3

Expected:   2

## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {
            int fiveCount = 0;
            for (int i=1; i <=n/5; i++ ){
                fiveCount += i;
            }
            return fiveCount;
        }
    }

------------------------------------------
------------------------------------------

## Error
Wrong Answer

Input:  5

Output: 0

Expected:   1

## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {
            int fiveCount = 0;
            for (int i=1; i <n/5; i++ ){
                fiveCount += i;
            }
            return fiveCount;
        }
    }

------------------------------------------
------------------------------------------

## Error
Wrong Answer

Input:  5

Output: 0

Expected:   1

## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {
            if (n<5)
                return 0;
            int fiveCount = 0;
            for (int i=1; i <n/5; i++ ){
                fiveCount += i;
            }
            return fiveCount;
        }
    }

------------------------------------------
------------------------------------------

## Error
Time Limit Exceeded

Last executed input:    1808548329

## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {

            int fiveCount = 0;
            for (int i=1; i <=n/5; i++ ){
                fiveCount += Math.floor(Math.log(5*i)/Math.log(5));
            }
            return fiveCount;
        }
    }

------------------------------------------
------------------------------------------

## Error
Time Limit Exceeded

Last executed input:    0

## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {

            int fiveCount = 0;
            int maxFive = (int) (Math.log(n)/Math.log(5));
            for (int i=1; i< maxFive; i++) {
                fiveCount += i*4;
            }
            int maxDiv = (int)Math.pow(5,maxFive);
            for (int i=1; i*maxDiv <= n; i++) {
                fiveCount += maxFive;
            }

            return fiveCount;
        }
    }

------------------------------------------
------------------------------------------

## Error
Time Limit Exceeded

Last executed input:    2147483647

## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {
            
            if (n<5)
                return 0;

            int fiveCount = 0;
            int maxFive = (int) (Math.log(n)/Math.log(5));
            for (int i=1; i< maxFive; i++) {
                fiveCount += i*4;
            }
            int maxDiv = (int)Math.pow(5,maxFive);
            for (int i=1; i*maxDiv <= n; i++) {
                fiveCount += maxFive;
            }

            return fiveCount;
        }
    }

------------------------------------------
------------------------------------------

## Error
Time Limit Exceeded

Last executed input:    0
## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {

            int fiveCount = 0;
            int maxFive = (int) (Math.log(n)/Math.log(5));
            for (int i=1; i< maxFive; i++) {
                fiveCount += i*4;
            }
            long maxDiv = (long)Math.pow(5,maxFive);
            for (int i=1; i*maxDiv <= n; i++) {
                fiveCount += maxFive;
            }

            return fiveCount;
        }
    }

------------------------------------------
------------------------------------------

## Error
Compile Error

Line 5: error: incompatible types: missing return value

## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {

            if (n<5)
                return;
            int fiveCount = 0;
            int maxFive = (int) (Math.log(n)/Math.log(5));
            for (int i=1; i< maxFive; i++) {
                fiveCount += i*4;
            }
            long maxDiv = (long)Math.pow(5,maxFive);
            for (int i=1; i*maxDiv <= n; i++) {
                fiveCount += maxFive;
            }

            return fiveCount;
        }
    }

------------------------------------------
------------------------------------------

## Error 
Wrong Answer

Input:  30

Output: 6

Expected:   7

## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {

            if (n<5)
                return 0;
            int fiveCount = 0;
            int maxFive = (int) (Math.log(n)/Math.log(5));
            for (int i=1; i< maxFive; i++) {
                fiveCount += i*4;
            }
            long maxDiv = (long)Math.pow(5,maxFive);
            for (int i=1; i*maxDiv <= n; i++) {
                fiveCount += maxFive;
            }

            return fiveCount;
        }
    }

------------------------------------------
------------------------------------------

## Error 
Compile Error

Line 4: error: illegal start of expression

## Submitted Code 
    public class Solution {
        public int trailingZeroes(int n) {

        public int trailingZeroes(int n) {
            int fiveCount=0;
            long maxFive = (long) (Math.log(n)/Math.log(5));

            for (int i=1; i <= maxFive; i++) {
                fiveCount += (int) (n/Math.pow(5,i));
            }


            return fiveCount;
        }
    }
    
------------------------------------------
------------------------------------------

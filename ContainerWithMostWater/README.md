# Container With Most Water

Given n non-negative integers a1, a2, ..., an, where each represents a point at
coordinate (i, ai). n vertical lines are drawn such that the two endpoints of
line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis
forms a container, such that the container contains the most water.

# Note
* You may not slant the container.

# Idea
Assume that the leftest line is l1 and the rightest line is ln, then if
height[1] is less than height[n], then the max area must be between l1 and ln 
or between l2 and ln. Because for each 2<=i<n, the area between l1 and li must
be less than  the area between l1 and ln.
height[1] is greater than height[n], then the max area must be between l1 and ln 
or between l1 and l(n-1).

For example,
<pre>

        |   |    
        |   |   |
    |   |   |   |
________________________________
    1   2   3   4
</pre>
The area between 1 and 2, 1 and 3 must be less than the area between 1 and 4.
 

# Scramble String 
Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":
<pre>
    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
</pre>
To scramble the string, we may choose any non-leaf node and swap its two children.

# For example 
if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
<pre>
    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
</pre>
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
<pre>
    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
</pre>
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

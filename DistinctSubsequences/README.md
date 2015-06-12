# Distinct Subsequences 
Given a string S and a string T, count the number of distinct subsequences of T
in S.

A subsequence of a string is a new string which is formed from the original
string by deleting some (can be none) of the characters without disturbing the
relative positions of the remaining characters. (ie, "ACE" is a subsequence of
"ABCDE" while "AEC" is not).

# Here is an example
S = "rabbbit", T = "rabbit"

Return 3.

# 解读
S删除有限个字符转换为T的方法数

# Note
* 动态规划数组的维度分别为m+1和n+1, 因为i的取值范围为0..m，j
    的取值范围为0..n

# The Skyline Problem 

A city's skyline is the outer contour of the silhouette formed by all the
buildings in that city when viewed from a distance. Now suppose you are given
the locations and height of all the buildings as shown on a cityscape photo
(Figure A), write a program to output the skyline formed by these buildings
collectively (Figure B).

<img alt="cityscape photo" src="images/1.jpg" width="300"/>
<img alt="skyline photo" src="images/2.jpg" width="300"/>

The geometric information of each building is represented by a triplet of
integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and
right edge of the ith building, respectively, and Hi is its height. It is
guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You
may assume all buildings are perfect rectangles grounded on an absolutely flat
surface at height 0.

For instance, the dimensions of all buildings in Figure A are recorded as: [ [2
9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .

The output is a list of "key points" (red dots in Figure B) in the format of [
[x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point
is the left endpoint of a horizontal line segment. Note that the last key point,
where the rightmost building ends, is merely used to mark the termination of the
skyline, and always has zero height. Also, the ground in between any two
adjacent buildings should be considered part of the skyline contour.

For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15],
[7 12], [12 0], [15 10], [20 8], [24, 0] ].

# Note:
* The number of buildings in any input list is guaranteed to be in the range [0,
10000].
* The input list is already sorted in ascending order by the left x position Li.
* The output list must be sorted by the x position.
* There must be no consecutive horizontal lines of equal height in the output
skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not
acceptable; the three lines of height 5 should be merged into one in the final
output as such: [...[2 3], [4 5], [12 7], ...]

* 边界条件
    * activeBuilding为空的情况
        * 应该返回高度为0，所以增加了一个虚拟的Building={0,0,0}，保证activeBuilding
        为空时，返回activeBuilding中的最高高度为0.
    * 一个building进入的横坐标和另一个building离开的横坐标一致
        * building的进入事件优先，否则如果离开的building是activeBuilding中的最后一个，
        那么当前高度会被设为0，假设当前的横坐标为x,另一个building离开的纵坐标为h,
        那么(x,0)和(x,h)都会被记录到skyline中，实际上，只需要记录(x,h)就可以了。
    * 一个building进入的横坐标和另一个building进入的横坐标一致
        * 高度高的优先，假设两个building进入的坐标分别为(x,h1)和(x,h2)且h1<h2，
        如果h1排在前面，那么(x,h1)和(x,h2)都会被记录到Skyline中，实际上只需要记录
        (x,h2)就可以了。


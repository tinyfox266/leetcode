# Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

* push(x) -- Push element x onto stack.
* pop() -- Removes the element on top of the stack.
* top() -- Get the top element.
* getMin() -- Retrieve the minimum element in the stack.

# Note
* 因为stack pop只能按照顺序依次删除，所以只需要记录一个区间段上最小的值即可。

    如stack的内容为2 3 4 1 5 6, 那么2 3 4区间内的最小值始终是2，因为2不可能在3 4
    之前出站， 2 3 4 1 5
    6区间内的最小值是1，所以在1出站前，其始终是最小值。所以，只需要记录2,1即可。
    
    注意，相同的最小值要记录两次。

class MyStack {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (q1.isEmpty())
            return;
        while (q1.size() > 1) {
            int n = q1.poll();
            q2.add(n);
        }
        q1.poll();
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
    }

    // Get the top element.
    public int top() {
        if (q1.isEmpty())
            return 0;
        int n=0;
        while (!q1.isEmpty()) {
            n = q1.poll();
            q2.add(n);
        }
        Queue<Integer> t = q1;
        q1 = q2;
        q2 = t;
        return n;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}

package linearPopConstantPush;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> q;
    private int top;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        this.top = x;
        q.add(this.top);
    }

    public int pop() {
        int currSize = q.size();
        for (int i = currSize - 1; i > 0; i--) {
            this.top = q.poll();
            q.add(this.top);
        }

        return q.poll();
    }

    public int top() {
        return this.top;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}

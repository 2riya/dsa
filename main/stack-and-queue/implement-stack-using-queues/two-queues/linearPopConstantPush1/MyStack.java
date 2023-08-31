package linearPopConstantPush1;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        int size = q1.size() - 1;
        for (int i = 0; i < size; i++) {
            q2.add(q1.poll());
        }
        int polled = q1.poll();
        Queue<Integer> qTemp = q1;
        q1 = q2;
        q2 = qTemp;
        return polled;
    }

    public int top() {
        int polled = -1;
        int size = q1.size();
        for (int i = 0; i < size; i++) {
            polled = q1.poll();
            q2.add(polled);
        }
        Queue<Integer> qTemp = q1;
        q1 = q2;
        q2 = qTemp;
        return polled;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

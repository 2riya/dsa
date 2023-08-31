package linearPopConstantPush2;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> fq;
    private Queue<Integer> sq;
    private int top;

    public MyStack() {
        fq = new LinkedList<>();
        sq = new LinkedList<>();
    }

    public void push(int x) {
        this.top = x;
        if (fq.isEmpty()) {
            sq.add(x);
        } else {
            fq.add(x);
        }
    }

    public int pop() {
        if (fq.isEmpty()) {
            return transferContentsAndReturnLast(sq, fq);
        } else {
            return transferContentsAndReturnLast(fq, sq);
        }
    }

    private int transferContentsAndReturnLast(Queue<Integer> from, Queue<Integer> to) {
        for (int i = from.size(); i > 1; i--) {
            this.top = from.poll();
            to.add(this.top);
        }

        return from.poll();
    }

    public int top() {
        return this.top;
    }

    public boolean empty() {
        return fq.isEmpty() && sq.isEmpty();
    }
}

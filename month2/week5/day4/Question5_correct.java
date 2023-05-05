package month2.week5.day4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列模拟一个栈
 *
 * @Author MinjieZhang
 * @Date 2023-04-06 21:55
 */
public class Question5_correct {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack.peek());
        System.out.println(stack);
    }
}

// 使用队列模拟一个栈
class MyStack<T> {

    //内部是队列在存储数据
    //队列1 是主队列
    Queue<Integer> queue1;
    //用来入栈，排在后面
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    public int pop() {
        return queue1.poll();
    }
    public int peek() {
        return queue1.peek();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "queue1=" + queue1 +
                ", queue2=" + queue2 +
                '}';
    }
}
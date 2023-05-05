package month2.week5.day4;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 使用栈模拟一个队列
 * // 使用栈模拟一个队列
 * class MyQueue<T> {
 * //内部是栈在存储数据
 * public boolean offer();
 * public T poll();
 * public T peek();
 * }
 *
 * @Author MinjieZhang
 * @Date 2023-04-06 14:48
 */
public class Question4_correct {
    public static void main(String[] args) {

        MyQueue<String> queue = new MyQueue<>();
        queue.push("a");
        queue.push("b");
        queue.push("c");
        queue.push("d");
        queue.push("e");
        System.out.println(queue);
        queue.pop();
        queue.pop();
        System.out.println(queue.peek());
        System.out.println(queue);

    }
}
// 使用栈模拟一个队列
class MyQueue<T> {

    //内部是栈在存储数据
    Deque<T> stack1; // 栈1:  栈顶对应队尾,  栈底对应队头
    Deque<T> stack2; // 栈2:  栈顶对应队头,  栈底对应队尾

    public MyQueue() {
        stack1 = new ArrayDeque<T>();
        stack2 = new ArrayDeque<T>();
    }

    public void push(T x) {

        stack1.push(x);
    }

    public T pop() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public T peek() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }
}
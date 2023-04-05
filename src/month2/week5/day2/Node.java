package month2.week5.day2;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-03-28 21:05
 */
public class Node {
    String value; // 值域
    Node next; // 指针

    //构造器
    public Node(String value) {
        this.value = value;
    }

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }
}

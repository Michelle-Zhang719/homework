package month2.week5.day2;

/**
 * 1,如果存在一个单链表, 我们只拥有单链表的头结点,
 * 实现一个方法, 判断链表中是否有环 (即: 这个单链表的尾结点, 它下一个指向, 指向链表中的另外一个结点, 构成一个环)
 *
 * @Author MinjieZhang
 * @Date 2023-03-28 20:54
 */
public class Question1 {
    public static void main(String[] args) {
        // a --> b --> c --> d --> e
        Node e = new Node("e");
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);

        // a --> b --> c --> d --> e --> c --> d --> e --> ...
        e.next = c;

        boolean bool = hasCircle(a);
        System.out.println(bool);
    }

    /**
     * 判断链表是否有环
     * 判断条件：两个指针再一次指向同一个对象时，代表有环
     *
     * @param head : 头结点
     * @return : 是否有环
     */
    private static boolean hasCircle(Node head) {
        Node fast = head; // 快指针
        Node later = head; // 慢指针

        // f后面还有内容 --> 向后遍历 fast指针遍历为null的可能性大
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            later = later.next;

            if (fast == later) {
                // 快慢指针相遇 --> 有环, f快指针在环内绕回来了
                return true;
            }
        }
        return false;
    }
}

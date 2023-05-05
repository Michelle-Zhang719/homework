package month2.week5.day2;

/**
 * 1, 如果存在一个单链表,实现一个方法, 给定这个单链表的头结点, 获得这个链表经过反序之后链表的头结点
 *
 * @Author MinjieZhang
 * @Date 2023-03-28 21:21
 */
public class Question2 {
    public static void main(String[] args) {
        // 翻转链表
        // a --> b --> c --> d --> e
        Node e = new Node("e");
        Node d = new Node("d", e);
        Node c = new Node("c", d);
        Node b = new Node("b", c);
        Node a = new Node("a", b);

        // e  --> d  -->  c  --> b  --> a
        Node newLinked = reLinked(a);

        System.out.println(newLinked.value);
    }

    /**
     * 翻转链表
     *
     * @param head : 原链表头结点
     * @return : 经过翻转链表的头结点
     */
    private static Node reLinked(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node left = null;
        Node mid = head;
        Node right = head.next;

        while (true) {
            //原地反转
            left = mid.next;
            if (right == null) {
                //到最后了
                break;
            }
            //整体向后移一位
            left = mid;
            mid = right;
            right = right.next;
        }
        //逆序完成，头指针的位置是mid的位置
        head = mid;
        return head;
    }
}



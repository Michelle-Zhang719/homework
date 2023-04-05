package month2.week5.day1.Question1;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-03-27 21:28
 */
public class Question1_correct {
    public static void main(String[] args) {
        //两个大小有序的单链表
        LinkList link1 = new LinkList();
        link1.add(1);
        link1.add(2);
        link1.add(5);
        link1.add(6);

        LinkList link2 = new LinkList();
        link2.add(2);
        link2.add(4);
        link2.add(7);

        //开始合并
        Question1_correct thisObject = new Question1_correct();
        thisObject.mergeLinked(link1.getHead(), link2.getHead());

    }

    /**
     * 合并两个有序链表
     * linked1: 有序链表1
     * linked2: 有序链表2
     *
     * @return month2.week5.day1.utils.Node 合并链表的头结点
     * @date 2023/03/27 20:10
     */
    public Node mergeLinked(Node linked1, Node linked2) {
        Node head = new Node();// 设置一个临时头结点
        Node end = head; // 定义一个临时尾结点

        while (linked1 != null && linked2 != null) {
            if (linked1.value <= linked2.value) {
                // linked1的当前头结点更小一些
                end.next = linked1;
                linked1 = linked1.next;
            } else {
                // linked2的当前头结点更小一些
                end.next = linked2;
                linked2 = linked2.next;
            }

            // 尾标记后移
            end = end.next;
        }
        // 上述循环结束, 必定意味着, 有一个链表遍历完成
        // 把其中一个没有遍历完的结点, 拼接到尾部之后
        end.next = linked1 != null ? linked1 : linked2;

        return head.next;
    }
}
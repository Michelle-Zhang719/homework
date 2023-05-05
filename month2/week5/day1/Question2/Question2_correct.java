package month2.week5.day1.Question2;

/**
 * @Description
 * @Author MinjieZhang
 * @Date 2023-03-27 21:22
 */
public class Question2_correct {
    public static void main(String[] args) {
        //创建一个链表 2--->5--->3--->7--->null
        LinkList linkList = new LinkList();
        linkList.add("zs");
        linkList.add("ls");
        linkList.add("wu");
        linkList.add("zl");

        Question2_correct thisQ2 = new Question2_correct();
        //获取这个链表的倒数第3个结点内容
        System.out.println(thisQ2.getValue(linkList.getHead(), 3));

    }

    /**
     * 根据一个单链表的头结点, 或得链表倒数第x位置的结点存储内容
     *
     * @param head:单链表的头结点
     * @param x:           数第x位置
     * @return: 数第x位置存储的内容
     */

    public String getValue(Node head, int x){

        Node later = head;   // 后行结点
        Node forward = head; // 先行结点

        // 先让先行结点向后移动x步
        while (x != 0){
            forward = forward.next;
            x--;
        }

        //此时, 先行结点和后行结点差x步

        // 同时单步后移
        while (forward != null){
            forward = forward.next;
            later = later.next;
        }

        //先行节点为null时，后行节点是倒数第x个结点

        return later.value;
    }
}
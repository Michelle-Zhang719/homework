package week5.day1.Question2;


/**
 * @Description 实现一个方法, 接收一个链表的头结点, 和int类型值x; 获取这个链表的倒数第x个结点内容
 * @Author MinjieZhang
 * @Date 2023-03-27 20:47
 */
public class Question2 {
    public static void main(String[] args) {
        //创建一个链表 2--->5--->3--->7--->null
        LinkList linkList = new LinkList();
        linkList.add("zs");
        linkList.add("ls");
        linkList.add("wu");
        linkList.add("zl");

        Question2 thisQ2 = new Question2();
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

    public String getValue(Node head, int x) {
        if (head == null) {
            return "empty LinkList";
        }
        //遍历用节点
        Node mid = head;
        //获取此单链表长度
        int size = 0;
        while (true) {
            if (mid == null) {
                break;
            }
            mid = mid.next;
            size++;
        }
        //数值不合法
        int target = size - x;
        if (target < 0) {
            return "false";
        }
        mid = head;
        String targetValue = null;
        for (int i = 0; i < size; i++) {
            if (i == target) {
                targetValue = mid.value;
            }
            mid = mid.next;
        }
        return targetValue;
    }
}


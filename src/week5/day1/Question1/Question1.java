package week5.day1.Question1;

/**
 * 假设有两个大小有序的单链表, 合并两个有序链表, 合并后链表也是有序的
 * 链表1: 1 -> 2 -> 5 --> 6 --> null
 * 链表2: 2 --> 4 --> 7 --> null
 * 合并结果: 1 --> 2 --> 2 --> 4 --> 5 --> 6 --> 7 --> null
 *
 * @Author MinjieZhang
 * @Date 2023-03-27 19:34
 */
public class Question1 {
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
        Question1 thisObject = new Question1();
        Node node = thisObject.mergeLinked(link1.getHead(), link2.getHead());

    }

    /**
     * 合并两个有序链表
     * linked1: 有序链表1
     * linked2: 有序链表2
     *
     * @return week5.day1.utils.Node 合并链表的头结点
     * @date 2023/03/27 20:10
     */
    public Node mergeLinked(Node linked1, Node linked2) {
        LinkList newLinkList = new LinkList(); // 排序后的新链表
        Node temp1 = linked1; //用于遍历有序链表1的临时结点
        Node temp2 = linked2; //用于遍历有序链表2的临时结点

        while (true) {
            if (temp1 == null) {
                //链表2所有的节点练到新链表上
                while (true) {
                    if (temp2 == null) {
                        break;
                    }
                    newLinkList.add(temp2.value);
                    temp2 = temp2.next;

                }
                break;
            }
            if (temp2 == null) {
                //链表2所有的节点练到新链表上
                while (true) {
                    if (temp1 == null) {
                        break;
                    }
                    newLinkList.add(temp1.value);
                    temp1 = temp1.next;

                }
                break;
            }
            //比较过程
            if (temp1.value < temp2.value) {
                //链表1的值较小，排入新链表中
                newLinkList.add(temp1.value);
                //指针后移
                temp1 = temp1.next;
            } else {
                newLinkList.add(temp2.value);
                temp2 = temp2.next;
            }
        }

        printLinkList(newLinkList);


        return newLinkList.getHead();
    }

    private void printLinkList(LinkList linkList) {
        //获得头节点
        Node mid = linkList.getHead();
        for (int i = 0; i < linkList.getSize(); i++) {
            System.out.println(mid.value);
            mid = mid.next;
        }
    }
}

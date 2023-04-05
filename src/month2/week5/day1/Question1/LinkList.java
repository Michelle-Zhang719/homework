package month2.week5.day1.Question1;

//单链表的结点
class Node {
    int value; // 值域
    Node next; // 指针

    //构造器

    public Node(int value) {
        this.value = value;
    }

    public Node() {

    }
}

/**
 * @Description 链表类
 * @Author MinjieZhang
 * @Date 2023-03-27 19:46
 */
class LinkList {
    private Node head; //头指针
    private int size; // 链表中数据的个数

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    //添加
    public boolean add(int n) {
        // 判空
        if (isEmpty()) {
            // 若链表为空，写头节点
            head = new Node(n);
            size++;
            return true;
        }

        // 核心逻辑: 从链表的头部遍历到尾部, 把数据创建一个新的结点添加到尾部
        Node mid = head; // 定义了一个临时结点

        // mid.next != null: 说明这个mid在向后移动的过程中, 后面还有结点, 还没有到尾部
        // 接着向后移动
        while (mid.next != null) {
            mid = mid.next;
        }

        // 上述循环走完: mid.next == null  , 也就意味着mid在链表的尾部

        // 创建一个新结点
        Node node = new Node(n);
        // 让新的结点, 作为原本尾结点的下一个结点(新的尾结点)
        mid.next = node;
        size++;

        return true;
    }

    private boolean isEmpty() {
        return size == 0;
    }

}

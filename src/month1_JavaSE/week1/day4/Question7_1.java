package month1_JavaSE.week1.day4;

/**
 * 首先，请你先手写一遍，课堂上手写数组遍历的过程。
 * 合并一起处理长度为0和null数组,给出一个友好提示
 *
 * @Author MinjieZhang
 * @Date 2023-03-02 20:02
 */
public class Question7_1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        traverse(arr);
    }

    public static void traverse(int[] arr) {
        // 处理特殊数组传入的情况
        // 标准格式,固定格式
        if (arr == null || arr.length == 0) {
            System.out.println("您输入的数组有误,请重新输入!");
            return;
        }

        System.out.print("[");
        for (int elem : arr) {
            System.out.print(elem + ", ");
        }
        System.out.println("\b\b]");
    }
}

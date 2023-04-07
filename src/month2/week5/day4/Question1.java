package month2.week5.day4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * 假如我有一个ArrayList对象存储了一些数据, 如果我们想遍历这些数据, 可以通过哪些循环或者迭代来做
 *
 * @Author MinjieZhang
 * @Date 2023-04-06 9:03
 */
public class Question1 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("zs");
        list.add("ls");
        list.add("wu");
        list.add("zl");


        //Object[] toArray()
        Object[] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //<T> T[]  toArray(T[] a)
        String[] strs = new String[list.size()];
        String[] resStrs = list.toArray(strs);
        for (int i = 0; i < resStrs.length; i++) {
            System.out.println(resStrs[i]);
        }


        //Iterator<E> iterator()
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //ListIterator<E> listIterator()
        ListIterator<String> iterator1 = list.listIterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        //foreach/增强for/加强for循环
        for (String str : list) {
            System.out.println(str);
        }

        //fori
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

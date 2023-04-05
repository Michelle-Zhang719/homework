package month2.week5.day2;

import java.util.Collection;
import java.util.TreeSet;

/**
 * 1, 如果存在一个Collection中存储了多个User对象,其中有一些User数据是重复的.
 * 获得一个包含不重复User的Collection集合(假设只使用Collection定义的api)
 *
 * @Author MinjieZhang
 * @Date 2023-03-28 21:55
 */
public class Question3 {
    public static void main(String[] args) {
        // 父类引用指向子类实现
        Collection<String> collection = new TreeSet<>();
        collection.add("zs");
        collection.add("zs");
        collection.add("ls");
        collection.add("wu");
        collection.add("wu");
        System.out.println(collection);
    }
}

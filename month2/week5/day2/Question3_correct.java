package month2.week5.day2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * 1, 如果存在一个Collection中存储了多个User对象,其中有一些User数据是重复的.
 * 获得一个包含不重复User的Collection集合(假设只使用Collection定义的api)
 *
 * @Author MinjieZhang
 * @Date 2023-03-28 22:16
 */

public class Question3_correct {
    public static void main(String[] args) {

        Collection<User> collection = new ArrayList<>();
        //user : 集合存储的数据类型
        collection.add(new User("zs", 18));
        collection.add(new User("zs", 18));
        collection.add(new User("ls", 18));
        collection.add(new User("ls", 18));
        collection.add(new User("wu", 18));
        collection.add(new User("wu", 18));

        Collection<User> newCollection = new ArrayList<>();

        Iterator<User> iterator = collection.iterator();
        while (iterator.hasNext()) {
            //向后是否可以遍历
            User next = iterator.next();
            // 向后遍历
            if (!newCollection.contains(next)) {
                //判断某个数据是否存在
                //添加方法
                newCollection.add(next);
            }
        }

        System.out.println(newCollection);

    }
}

class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
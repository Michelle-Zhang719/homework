package month2.week5.day3;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 如果List中存储了多个User对象, 去除重复元素(多个重复元素仅保留一个)(假设主要使用List新定义的的api来做)
 *
 * @Author MinjieZhang
 * @Date 2023-04-04 9:14
 */
public class Question1 {
    public static void main(String[] args) {
        User u1 = new User("zs", 16);
        User u2 = new User("ls", 14);
        User u3 = new User("wu", 19);
        User u4 = new User("zl", 18);
        User u5 = new User("cf", 24);
        User u6 = new User("wu", 19);
        User u7 = new User("wu", 19);

        ArrayList<User> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        userList.add(u5);
        userList.add(u6);
        userList.add(u7);

        ArrayList<User> flagList = new ArrayList<>();
        System.out.println(userList);
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User next = iterator.next();
            if (flagList.size() == 0) {
                flagList.add(next);
                continue;
            }
            //flaglist里面有东西
            if (!flagList.contains(next)) {
                flagList.add(next);
            } else {
                iterator.remove();
            }

        }

        System.out.println(userList);
        System.out.println(flagList);

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

        if (age != user.age) return false;
        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

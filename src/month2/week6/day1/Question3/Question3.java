package month2.week6.day1.Question3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 有5个学生信息 (姓名，语文成绩，数学成绩，英语成绩)，并按照指定的格式，总分从高到低，输出到文件(输出一个文件出来)(Properties)。
 * <p>
 * //  参考:
 * Student s1 = new Student("zs", 100, 100, 100);
 * Student s2 = new Student("ls", 90, 90, 90);
 * Student s3 = new Student("wu", 90, 90, 90);
 * Student s4 = new Student("zl", 85, 85, 85);
 * Student s5 = new Student("cf", 100, 100, 100);
 *
 * @Author MinjieZhang
 * @Date 2023-04-03 20:56
 */
public class Question3 {
    public static void main(String[] args) throws IOException {
        Student s1 = new Student("zs", 100, 100, 100);
        Student s2 = new Student("ls", 90, 90, 90);
        Student s3 = new Student("wu", 90, 90, 90);
        Student s4 = new Student("zl", 85, 85, 85);
        Student s5 = new Student("cf", 100, 100, 100);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(s1);
        studentArrayList.add(s2);
        studentArrayList.add(s3);
        studentArrayList.add(s4);
        studentArrayList.add(s5);

        List<Student> stream = studentArrayList.stream()
                .sorted(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.calculateTotalScore() - o2.calculateTotalScore();
                    }
                })
                .collect(Collectors.toList());
//        System.out.println(stream);

        Properties properties = new Properties();
        for (int i = 0; i < stream.size(); i++) {
            properties.setProperty(String.valueOf(i), stream.get(i).toString());
        }


//        TreeMap<Student, Integer> map2 = new   TreeMap<>((a, b) -> {
//            int cmp = a.calculateTotalScore() - b.calculateTotalScore();
//            cmp = cmp != 0 ? cmp : a.getChinese() - b.getChinese();
//            cmp = cmp != 0 ? cmp : a.getMath() - b.getMath();
//            cmp = cmp != 0 ? cmp : a.getEnglish() - b.getEnglish();
//            cmp = cmp != 0 ? cmp : a.getName().compareTo(b.getName());
//            return cmp;
//        });
//        map2.put(s1, 1);
//        map2.put(s2, 2);
//        map2.put(s3, 3);
//        map2.put(s4, 4);
//        map2.put(s5, 5);
//
//
//        Properties properties = new Properties();
//
//        Set<Map.Entry<Student, Integer>> entries = map2.entrySet();
//        int i = 1;
//        for (Map.Entry<Student, Integer> entry : entries) {
//            properties.setProperty(i+"", entry.getKey().toString() );
//            i++;
//        }

        FileWriter out = new FileWriter("src/month2/week6/day1/Question3/io.properties");
        properties.store(out, "comm");
    }
}

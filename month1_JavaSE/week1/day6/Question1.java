package month1_JavaSE.week1.day6;

import java.util.Scanner;

/**
 * @Description 需求请看同级目录下的pdf
 * @Author MinjieZhang
 * @Date 2023-03-04 13:26
 */
public class Question1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] studentName = new String[5];
        studentName[0] = "张三";
        studentName[1] = "李四";
        studentName[2] = "王五";
        studentName[3] = "赵六";
//        studentName[4] = "路人";
        printMenu(sc, studentName);
    }

    public static void printMenu(Scanner sc, String[] studentName) {
        System.out.println();
        System.out.println("----------王道Java学生管理系统----------");
        System.out.println();
        System.out.println("            1.学 生 列 表");
        System.out.println("            2.增 加 学 生");
        System.out.println("            3.删 除 学 生");
        System.out.println("            4.修 改 学 生");
        System.out.println("            5.查 询 学 生");
        System.out.println("            6.退 出 系 统");

        while (true) {
            System.out.println();
            System.out.println("请选择功能(1-6):");
            int opt = sc.nextInt();
            sc.nextLine();
            switch (opt) {
                case 1:
                    printName(studentName);
                    break;
                case 2:
                    System.out.println("请输入新增学生的姓名：");
                    String newStudent = sc.nextLine();
                    create(studentName, newStudent);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("确认退出吗（1/2):");
                    int shut = sc.nextInt();
                    if (shut == 1) {
                        System.out.println("感谢使用本系统！");
                        return;
                    }
            }
        }
    }

    //1.学生列表，要求输出数组中的全部学生信息，注意null不能输出
    public static void printName(String[] studentName) {
        //记录数组中null的数量
        int count = 0;
        for (String elem : studentName) {
            if (elem == null) {
                count++;
            }
        }
        if (studentName.length == count) {
            System.out.println("学生列表目前为空哦！请先新增学生信息");
            return;
        }

        //学生数组不全为空时
        System.out.println("学生列表为");
        System.out.print("[");
        for (String elem : studentName) {
            if (elem == null) {
                continue;
            }
            System.out.print(elem + ", ");
        }
        System.out.println("\b\b]");
    }

    //2.增加学生，在数组null的位置新增学生信息，如果数组没有null，表示数组已满
    public static void create(String[] studentName, String target) {
        int count = 0;
        for (int i = 0; i < studentName.length; i++) {
            if (studentName[i] == null) {
                studentName[i] = target;
                System.out.println("新增学生信息成功");
                break;
            }
            count++;
            if (count == studentName.length) {
                System.out.println("数组已满，不能继续新增啦！");
            }
        }
    }
}
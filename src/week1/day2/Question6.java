package week1.day2;

import java.util.Scanner;

/**
 * 方法是Java代码中最常用的语法结构，这里对方法的语法做一下练习。
 * 在使用方法或者想要写一个方法时，首先要考虑的是方法需要的参数是什么数据类型，需要几个（形式参数），再考虑方法需要返回什么结果（返回值类型）。
 * 在调用方法时，需要搞清楚具体传入什么数值（实际参数）。
 * 实现以下需求：
 * 1.使用for循环遍历n以内的奇数，并计算所有的奇数的和并输出。
 * 2.打印倒三角形，并且行数（line）是可控制的。比如我想打印6行的倒三角形，则如下图：
 * ******
 * *****
 * ****
 * ***
 * **
 * *
 * 3.根据键盘录入打印nn乘法表，n是可变的。
 * 4.键盘录入一个int数字，判断它是奇数还是偶数。
 * 5.根据键盘录入打印n行m列井号，n和m是可变的。
 * 6.（扩展题）输出前n个数当中的所有素数，并统计个数。注：可以百度查一下如何求素数，该题作为扩展题，可以不做。
 *
 * @Author MinjieZhang
 * @Date 2023-02-28 19:13
 */
public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //1.使用for循环遍历n以内的奇数，并计算所有的奇数的和并输出。
        System.out.println("1.请输入一个正整数n:");
        int n1 = sc.nextInt();
        findOddAndSum(n1);

        //2.打印倒三角形，并且行数（line）是可控制的。
        System.out.println("2.输入想打印的倒三角的行数n:");
        int n2 = sc.nextInt();
        print(n2);

        //3.根据键盘录入打印nn乘法表，n是可变的。
        System.out.println("3.请输入想打印的nn乘法表中的n:");
        int n3 = sc.nextInt();
        printNN(n3);

        //4.键盘录入一个int数字，判断它是奇数还是偶数。
        System.out.println("4.请输入一个int类型的数字，用以判断奇偶:");
        int n4 = sc.nextInt();
        judgeOddOrEven(n4);

        //5.根据键盘录入打印n行m列井号，n和m是可变的。
        System.out.println("5.请输入用以打印n行m列井号的n:");
        int line = sc.nextInt();
        System.out.println("  请输入用以打印n行m列井号的m:");
        int column = sc.nextInt();
        printNM(line, column);

        //6.（扩展题）输出前n个数当中的所有素数，并统计个数。注：可以百度查一下如何求素数，该题作为扩展题，可以不做。
        System.out.println("6.请输入一个正整数n:");
        int n5 = sc.nextInt();
        printPrimeAndGetNum(n5);

    }

    //1.使用for循环遍历n以内的奇数，并计算所有的奇数的和并输出。
    public static void findOddAndSum(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 != 0) {
                sum += i;
                System.out.println(i);
            }
        }
        System.out.println("所有奇数和为：" + sum);
    }

    //2.打印倒三角形，并且行数（line）是可控制的。
    public static void print(int n) {
        for (int i = 0; i < n; i++) {
            //外层循环控制行数
            for (int j = n; j > i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //3.根据键盘录入打印nn乘法表，n是可变的。
    public static void printNN(int n) {
        for (int i = 1; i <= n; i++) {
            //外层循环控制行数
            int result = 0;
            for (int j = 1; j <= i; j++) {
                result = i * j;
                System.out.print(j + "x" + i + "=" + result + "\t");
            }
            System.out.println();
        }
    }

    //4.键盘录入一个int数字，判断它是奇数还是偶数。
    public static void judgeOddOrEven(int n) {
        if (n % 2 == 0) {
            System.out.println("此数为偶数");
        } else {
            System.out.println("此数为奇数");
        }
    }

    //5.根据键盘录入打印n行m列井号，n和m是可变的。
    public static void printNM(int line, int column) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    //6.（扩展题）输出前n个数当中的所有素数，并统计个数。注：可以百度查一下如何求素数，该题作为扩展题，可以不做。
    public static void printPrimeAndGetNum(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            //素数：只能被1和本身整除的称为素数；
            //外层循环遍历被除数i(因为1既不是素数也不是和数，所以直接从2开始遍历)
            int flag = 0;//0表素数
            for (int j = 2; j < i; j++) {
                //内层遍历除数j
                //判断是否存在j能整除i，余数为0整除，不是素数
                if (i % j == 0) {
                    flag = 1;//不是素数
                    break;
                }
            }
            if (flag == 0) {
                count++;
                System.out.print(i + " ");
            }
        }
        System.out.println("共有" + count + "个素数");
    }
}

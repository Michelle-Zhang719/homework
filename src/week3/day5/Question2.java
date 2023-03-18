package week3.day5;

import java.io.File;
import java.io.FileFilter;

/**
 * 带过滤器的listFiles方法练习
 * 自己做一个目录，里面放些一下文件，文件夹 用带过滤器的listFiles方法进行File对象的筛选
 * 条件一：仅留下文件夹名包括a的文件夹
 * 条件二：仅留下.txt结尾的文本文件
 * 条件三：仅留下以a开头的文件
 * 要求:使用Lambda表达式
 * 无需考虑多级目录
 *
 * @Author MinjieZhang
 * @Date 2023-03-17 21:26
 */
public class Question2 {
    public static void main(String[] args) {
        File f = new File("src\\week3\\day5\\test");
        File[] result = f.listFiles(new FilterRuler());
        for (File file : result) {
            System.out.println(file.getAbsolutePath());
        }
    }
}

class FilterRuler implements FileFilter {

    //重写过滤规则
    @Override
    public boolean accept(File pathname) {


        //仅留下.txt结尾的文本文件
        return (pathname.isFile() && pathname.getName().endsWith(".txt")) ||
                pathname.isFile() && pathname.getName().startsWith("a") ||
                pathname.isDirectory() && pathname.getName().contains("a");
    }
}

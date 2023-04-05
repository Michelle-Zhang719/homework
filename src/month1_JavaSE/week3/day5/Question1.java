package month1_JavaSE.week3.day5;

import java.io.File;

/**
 * 需求:递归删除目录与文件
 * 自己新建一个文件夹在文件夹当中自己放入一些文件,新建一些二级目录...
 * 然后使用递归的方式,将该目录里面的文件/文件夹全部删除
 * 注意:
 * 1.不要在C盘/系统盘里进行操作
 * 2.执行delete删除之前,一定要谨慎查看路径名,避免误删
 *
 * @Author MinjieZhang
 * @Date 2023-03-17 20:53
 */
public class Question1 {
    public static void main(String[] args) {
        File f = new File("src\\month1_JavaSE.week3\\day5\\test");

        recursiveDeleteDirectoryAndFile(f);
    }

    /*
        1.获取目标目录下的所有文件/文件夹
        如果是文件,直接删除
        如果是目录,此时就直接递归调用查找方法,去下一级目录查找删除文件
     */

    private static void recursiveDeleteDirectoryAndFile(File fileSrc) {
        // 判断是否是一个目录, 不是的话跳过, 直接删除; 如果是一个目录, 先将其内容清空.
        if (fileSrc.isDirectory()) {
            // 获取子文件/目录
            File[] subFiles = fileSrc.listFiles();
            // 遍历该目录
            for (File subFile : subFiles) {
                // 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除. 如果这是一个非空目录, 多次
                // 递归清空其内容后再删除
                recursiveDeleteDirectoryAndFile(subFile);
            }
        }
        // 删除空目录或文件
        fileSrc.delete();
    }
}


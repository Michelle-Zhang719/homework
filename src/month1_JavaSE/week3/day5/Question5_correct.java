package month1_JavaSE.week3.day5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description 改正我的catch问题！！
 * @Author MinjieZhang
 * @Date 2023-03-17 22:35
 */

public class Question5_correct {
    public static void main(String[] args) {
        String[] words = {"verb:eat", "verb:drink", "verb:sleep", "verb:play"
                , "noun:rice", "noun:meat", "noun:hand", "noun:hair"};

        String verb = "verb";
        String noun = "noun";
        /*
            这道题目说白了,就是将:
            一个仅装有动词的字符串序列写入一个文件
            以及另一个仅装有名词的字符串序列写入另一个文件
            所以首先要做的就是筛选出这两个字符串序列,这里就是纯粹的String API的使用了
            做法可能不唯一,以下实现仅供参考.
         */
        // 在已经学过可变字符串的今天，推荐使用可变字符串进行字符串拼接
        StringBuilder verbs = new StringBuilder();
        StringBuilder nouns = new StringBuilder();
        for (String word : words) {
            if (word.contains(verb)) {
                verbs.append(word);
                verbs.append("\n");
            }
            if (word.contains(noun)) {
                nouns.append(word);
                nouns.append("\n");
            }
        }
        File verbFile = new File("verb.txt");
        File nounFile = new File("noun.txt");
        FileOutputStream verbFileOutputStream = null;
        FileOutputStream nounFileOutputStream = null;
        try {
            //初始化输出流
            verbFileOutputStream = new FileOutputStream(verbFile);
            nounFileOutputStream = new FileOutputStream(nounFile);
            //获得字节数组
            byte[] verbBytes = verbs.toString().getBytes();
            byte[] nounBytes = nouns.toString().getBytes();
            //写入文件
            verbFileOutputStream.write(verbBytes);
            nounFileOutputStream.write(nounBytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源释放
            try {
                if (verbFileOutputStream != null) {
                    verbFileOutputStream.close();
                }
                if (nounFileOutputStream != null) {
                    nounFileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
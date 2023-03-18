package week3.day5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 定义一个String[] words数组，数组中每个字符串的格式为“词性:单词”
 * String[] words = {"verb:eat","verb:drink","verb:sleep","verb:play","noun:rice","noun:meat","noun:hand","noun:hair"};
 * 要求:
 * 根据单词性质动词verb全部存入verb.txt文件中,该文件中最终显示：
 * verb:eat
 * verb:drink
 * verb:sleep
 * verb:play
 * 根据单词性质名词noun全部存入noun.txt文件中,该文件中最终显示：
 * noun:rice
 * noun:meat
 * noun:hand
 * noun:hair
 *
 * @Author MinjieZhang
 * @Date 2023-03-17 22:16
 */
public class Question5 {
    public static void main(String[] args) throws IOException {
        String[] words = {"verb:eat","verb:drink","verb:sleep","verb:play","noun:rice","noun:meat","noun:hand","noun:hair"};

        //动词文件夹
        FileOutputStream outVerb = new FileOutputStream("src\\week3\\day5\\test\\verb.txt",true);
        //名词文件夹
        FileOutputStream outNoun = new FileOutputStream("src\\week3\\day5\\test\\noun.txt",true);

        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith("verb")){
                outVerb.write(words[i].getBytes());
                outVerb.write("\r\n".getBytes());
            }
            if (words[i].startsWith("noun")){
                outNoun.write(words[i].getBytes());
                outNoun.write("\r\n".getBytes());
            }
        }


    }
}

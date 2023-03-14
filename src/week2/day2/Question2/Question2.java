package week2.day2.Question2;

/**
 * 导包是很基本的操作，某些细节也需要注意，请完成以下练习：
 * 首先根据以下代码中注释，将三个类定义出来
 * 毫无疑问，直接执行Test中的main方法会输出的是b包，思考以下问题（独立的三个问题）：
 * 1.不改变Test类中main方法的基础上，让main方法运行之后输出“a包”，应该怎么做？
 * 2.不做任何导包操作的基础上，修改main方法，让main方法运行之后同时输出“a包”和“b包”，应该怎么做？
 * 3.在Test类中添加导包语句import com.cskaoyan.a.*，不修改任何代码，执行main方法，输出的是什么？为什么？
 *
 * @Author MinjieZhang
 * @Date 2023-03-07 20:33
 */
public class Question2 {
    //1.导包  import com.cskaoyan.a.MyClazz;
    //2.使用全限定类名
    //3.输出b包 原因：同包中已存在MyClazz类，再想通过智能导包导入别的包下的MyClazz类是无法完成的。
}





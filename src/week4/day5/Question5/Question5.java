package week4.day5.Question5;

/**
 * 配置文件与网络编程(UDP)结合练习
 * 自动回复机器人
 * 定义2个类 Sender,Receiver
 *     Sender向Receiver发送数据,并且接收Receiver的数据
 *     Receiver接收Sender的数据,并且根据Sender发的数据进行自动回复
 * 如何自动回复?
 *     新建一个properties配置文件,将Receiver可能的提问以及自动回复的消息以键值对存在配置文件中
 *     比如:
 *     Sender发送 "在吗"? Receiver回复 "在", 那么这个"在"就事先放到配置文件里面---->  在吗=在
 *     Receiver在收到Sender发送的消息的时候,去配置文件中去找相应的回答,如果没找到就回复 "我没听懂你在说什么"
 *     回复的内容可以自由发挥,都是以key=value的形式放在配置文件里就行
 * @Author MinjieZhang
 * @Date 2023-03-24 19:33
 */
public class Question5 {
}

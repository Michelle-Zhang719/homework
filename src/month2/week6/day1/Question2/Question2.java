package month2.week6.day1.Question2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2, 基于提供的三个参考类型: 实现
 * // 1.找出2011年发生的交易记录, 按照从低到高交易额排序
 * // 2.找出交易员都在哪些不同的城市工作过
 * // 3.查找来自北京的交易, 按交易员姓名排序
 * // 4.返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
 * // 5.判断有没有交易员在北京工作
 * // 6.打印所有发生在北京的交易记录金额
 * // 7.所有交易中最高的交易是多少
 * // 8.所有交易中, 交易最低的交易信息
 *
 * @Author MinjieZhang
 * @Date 2023-04-03 19:56
 */
public class Question2 {
    public static void main(String[] args) {
        List<Transaction> transactions = new TransactionRecord().transactions;

        // 1.找出2011年发生的交易记录, 按照从低到高交易额排序
        List<Transaction> stream = transactions.stream()
                .filter(a -> a.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(stream);

        // 2.找出交易员都在哪些不同的城市工作过的城市
        List<String> stream2 = transactions.stream()
                .map(a -> a.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(stream2);

        //3. 查找来自北京的交易, 按交易员姓名排序
        List<Transaction> stream3 = transactions.stream()
                .filter(a -> a.getTrader().getCity().equals("beijing"))
                .sorted(new Comparator<Transaction>() {
                            @Override
                            public int compare(Transaction o1, Transaction o2) {
                                return o1.getTrader().getName().hashCode() - o2.getTrader().getName().hashCode();
                            }
                        }
                )
                .collect(Collectors.toList());
        System.out.println(stream3);

        //4. 返回一个字符串包含所有交易员, 字符串的顺序按照姓名排序
        List<String> stream4 = transactions.stream()
                .sorted(new Comparator<Transaction>() {
                            @Override
                            public int compare(Transaction o1, Transaction o2) {
                                return o1.getTrader().getName().hashCode() - o2.getTrader().getName().hashCode();
                            }
                        }
                )
                .map(a -> a.getTrader().getName())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(stream4);

        //5. 判断有没有交易员在北京工作
        boolean stream5 = transactions.stream()
                .anyMatch(a -> a.getTrader().getCity().equals("beijing"));
        System.out.println(stream5);

        //6. 打印所有发生在北京的交易记录金额
        List<Integer> stream6 = transactions.stream()
                .filter(a -> a.getTrader().getCity().equals("beijing"))
                .map(a -> a.getValue())
                .collect(Collectors.toList());
        System.out.println(stream6);

        //7. 所有交易中最高的交易是多少
        List<Integer> stream7 = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .limit(1)
                .map(a -> a.getValue())
                .collect(Collectors.toList());
        System.out.println(stream7);

        //8. 所有交易中, 交易最低的交易信息
        List<Transaction> stream8 = transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(stream8);
    }
}

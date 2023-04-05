package month1_JavaSE.week4.day4;

/**
 * 参考课堂上给出的同步代码块实现的
 * 仓库容量为1,1个消费者,1个生产者的消费者生产者模型
 * 把它改造成用同步方法实现
 *
 * @Author MinjieZhang
 * @Date 2023-03-23 20:11
 */
public class Question5 {
    public static void main(String[] args) {
        //锁对象
        Warehouse warehouse = new Warehouse();

        new Thread(new Producer(warehouse), "生产者线程A").start();
        new Thread(new Consumer(warehouse), "消费者线程B").start();
    }
}

// 生产者模型
class Producer implements Runnable {
    private Warehouse warehouse;
    private static Phone[] phones = new Phone[4];

    static {
        phones[0] = new Phone("华为P60", 10000);
        phones[1] = new Phone("iPhone15", 6000);
        phones[2] = new Phone("小米15", 5000);
        phones[3] = new Phone("OPPO find n2", 7999);
    }

    public Producer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            warehouse.makePhone(phones);
        }
    }


}

//消费者模型
class Consumer implements Runnable {
    private Warehouse warehouse;

    public Consumer(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            warehouse.buyPhone();
        }
    }


}


// 手机,商品类
class Phone {
    private String name;
    private double price;

    public Phone(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

// 仓库类型,用于存储商品
class Warehouse {
    // 仓库就只存一台手机
    private Phone phone;

    // 将生产出来的手机存入仓库
    public void putPhone(Phone phone) {
        this.phone = phone;
    }

    public Phone getPhone() {
        return phone;
    }

    // 将生产出来的手机卖出去
    public void sellPhone() {
        phone = null;
    }

    public boolean isEmpty() {
        return phone == null;
    }

    synchronized void makePhone(Phone[] phones) {
//        warehouse.notify();
        notify();
        if (!isEmpty()) {
            // 已经有手机了,不能继续生产了,要wait自己
            try {
//                warehouse.wait();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // 不难把wait方法的调用当成return，它不是结束方法,而是阻塞,恢复后会继续往下执行方法
            // 仓库是空的,那就生产一台手机放入仓库
            int randomIndex = ((int) (Math.random() * phones.length));
            Phone phoneDuc = phones[randomIndex];
            System.out.println(Thread.currentThread().getName() + "生产了一台手机" + phoneDuc);
            putPhone(phoneDuc);
        }
    }

    public synchronized void buyPhone() {
//        warehouse.notify();
        notify();
        if (isEmpty()) {
            // 没有手机了,不能继续消费了,要wait自己
            try {
                //warehouse.wait();
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // 仓库是有手机的,那就消费一台仓库中的手机
            System.out.println(Thread.currentThread().getName() + "消费了一台手机" + getPhone());
            sellPhone();
        }
    }
}
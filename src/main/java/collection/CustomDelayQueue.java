package collection;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomDelayQueue {
    static AtomicInteger MESSAGE = new AtomicInteger(1);

    public static void main(String[] args) {

        DelayQueue<DelayElement> delayElements = new DelayQueue<>();
        producer(delayElements, "producer1");
        producer(delayElements, "producer2");
        concumer(delayElements);
    }

    private static void concumer(DelayQueue<DelayElement> delayElements) {
        new Thread(() -> {
            while (true) {
                DelayElement element;
                try {
                    element = delayElements.take();
                    System.out.println(element);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private static void producer(DelayQueue<DelayElement> delayElements, String producer1) {
        new Thread(() -> {
            while (true) {
                long time = 1000L * (new Random().nextInt(5) + 1);
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String message = String.format("%s 消息编号：%s 发送时间：%s 延迟：%s 秒", producer1, MESSAGE.getAndIncrement(),
                        DateFormat.getDateTimeInstance().format(new Date()), time);
                delayElements.put(new DelayElement(time, message));
            }

        }).start();
    }


    static class DelayElement implements Delayed {
        long delayTime = System.currentTimeMillis();
        String message;

        public DelayElement(long i, String message) {
            this.delayTime = (i + this.delayTime);
            this.message = message;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
                return 1;
            } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
                return -1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return message + DateFormat.getTimeInstance().format(new Date(delayTime));
        }
    }
}

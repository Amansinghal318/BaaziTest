package Baazi;

import java.util.LinkedList;

public class ProducerConsumerThread {
    public static void main(String[] args)
            throws InterruptedException
    {
        final ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    producerConsumer.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    producerConsumer.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
    public static class ProducerConsumer {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int capacity = 5;
        public void produce() throws InterruptedException
        {
            int value = 0;
            while (true) {
                synchronized (this)
                {
                    while (linkedList.size() == capacity)
                        wait();
                    System.out.println("Producer produced-"
                            + value);
                    linkedList.add(value++);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
        public void consume() throws InterruptedException
        {
            while (true) {
                synchronized (this)
                {
                    // is empty
                    while (linkedList.size() == 0)
                        wait();
                    int val = linkedList.removeFirst();

                    System.out.println("Consumer consumed-"
                            + val);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
}

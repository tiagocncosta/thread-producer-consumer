package ConsumerProducer;

import ConsumerProducer.Container.Container;

import java.util.Queue;

public class Producer implements Runnable {
    private final Container<Integer> queue;
    private final int limit;

    public Producer(Container<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (limit > 0) {
            int elem = (int) (Math.random() * 9);
            synchronized (queue) {
                queue.offer(elem);
                System.out.println(Thread.currentThread().getName() + "produced another plate");

                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(queue);

            }
            System.out.println("I'm done for the day see ya");

        }
    }
}

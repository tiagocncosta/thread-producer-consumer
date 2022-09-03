package ConsumerProducer;

import ConsumerProducer.Container.Container;

import java.util.Queue;

public class Consumer implements Runnable {
    private final Container<Integer> queue;
    private int limit;

    public Consumer(Container<Integer> queue, int limit) {
        this.queue = queue;
        this.limit = limit;
    }

    @Override
    public void run() {
        while (limit > 0) {
            synchronized (queue) {
                queue.poll();

                System.out.println(Thread.currentThread().getName() + "consumed another plate");
            }
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(queue);

            limit--;
        }
        System.out.println("Im fulll see ya tomorrow");
    }
}



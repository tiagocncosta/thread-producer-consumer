package Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {


        // CREATE A POOL OF 5 FIXED THREADS
        ExecutorService executorService = Executors.newCachedThreadPool();


        IntStream.rangeClosed(0, 50).forEach(
                (i) -> {
                    executorService.submit(() -> {
                        System.out.println(i + " running : " + Thread.currentThread().getName());
                    });
                }
        );

    }
}

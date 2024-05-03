package iobound_application;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IoBoundApplication {
    private static final int NUMBER_OF_TASKS = 10_000;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter to start");
        scanner.nextLine();
        System.out.printf("Runnning %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTasks();
        System.out.printf("Tasks took %dms to complete\n", System.currentTimeMillis() - start);
    }

    private static void performTasks() throws IOException {
        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executorService.submit(() -> blockingIoOperation());
            }
        }
    }

    //Simulates a long blocking IO operation
    private static void blockingIoOperation() {
        System.out.println("Executing a blocking task from thread: " + Thread.currentThread());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

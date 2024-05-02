package iobound_application;

import java.util.Scanner;

public class IoBoundApplication {
    private static final int NUMBER_OF_TASKS = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter to start");
        scanner.nextLine();
        System.out.printf("Runnning %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTasks();
        long end = System.currentTimeMillis();

        System.out.printf("Tasks took %dms to cmmplete\n", end - start);
    }

    //Simulates a long blocking IO operation
    private static void blockingIoOperation() {
        System.out.println("Executing a blocking task from thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

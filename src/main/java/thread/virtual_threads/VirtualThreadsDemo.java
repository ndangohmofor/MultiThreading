package thread.virtual_threads;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsDemo {
    private static final int NUMBER_OF_VIRTUAL_THREADS = 2;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> System.out.println("Inside thread: " + Thread.currentThread());

        List<Thread> virtualThreads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
            Thread thread = Thread.ofVirtual().unstarted(runnable);
            virtualThreads.add(thread);
        }

        for (Thread thread : virtualThreads) {
            thread.start();
        }

        for (Thread thread : virtualThreads) {
            thread.join();
        }
    }
}

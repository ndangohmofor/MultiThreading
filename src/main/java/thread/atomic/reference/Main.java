package thread.atomic.reference;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public class Main {
    public static void main(String[] args) {
    }

    public static class StandardStack<T> {
        private StackNode<T> head;
        private int counter = 0;

        public synchronized void push(T value) {
            StackNode<T> newHead = new StackNode<>(value);
            newHead.next = head;
            head = newHead;
            counter++;
        }

        public synchronized T pop() {
            if (head == null) {
                counter++;
                return null;
            }
            T value = head.value;
            head = head.next;
            counter++;
            return value;
        }

        public int getCounter() {
            return counter;
        }
    }

    public static class LockFreeStack<T>{
        private AtomicReference<StackNode<T>> head = new AtomicReference<>();

        public void push(T value){
            StackNode<T> newHeadNode = new StackNode<>(value);
             while (true){
                 StackNode<T> currentHeadNode = head.get();
                 newHeadNode.next = currentHeadNode;

                 if (head.compareAndSet(currentHeadNode, newHeadNode)){
                     break;
                 } else {
                     LockSupport.parkNanos(1);
                 }
             }
        }
    }

    private static class StackNode<T> {
        public T value;
        public StackNode<T> next;

        public StackNode(T value) {
            this.value = value;
            this.next = next;
        }
    }
}

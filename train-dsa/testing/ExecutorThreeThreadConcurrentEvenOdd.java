import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorThreeThreadConcurrentEvenOdd {

    private static final Object lock = new Object();
    private static int turn = 1;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> {
            for(int i = 1; i< 10; i+=3) {
                synchronized(lock) {
                    while(turn %3 != 1) {
                        try {
                            lock.wait();
                        }catch(InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(i);
                    lock.notifyAll();
                    turn++;
                }
            }
        });

        executor.submit(() -> {
            for(int i = 2; i < 10; i+=3) {
                synchronized(lock) {
                    while(turn%3 != 2) {
                        try {
                            lock.wait();
                        } catch(InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(i);
                    lock.notifyAll();
                    turn++;
                }
            }
        });

        executor.submit(() -> {
            for(int i = 3; i< 10; i+=3) {
                synchronized(lock) {
                    while(turn%3 != 0) {
                        try {
                            lock.wait();
                        } catch(InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(i);
                    lock.notifyAll();
                    turn++;
                }
            }
        });

        executor.shutdown();
    }
    
}

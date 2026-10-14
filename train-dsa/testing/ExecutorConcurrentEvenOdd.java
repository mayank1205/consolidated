import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorConcurrentEvenOdd {

    private static final Object lock = new Object();
    private static volatile boolean isOddTurn = true;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            for(int i = 1; i< 10; i+=2) {
                synchronized (lock) {
                    while(!isOddTurn) {
                        try {
                        lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(i);
                    isOddTurn = false;
                    lock.notifyAll();
                }
            }
        });

        executor.submit(() -> {
            for(int i = 2; i <= 10; i+=2){
                synchronized(lock) {
                    while(isOddTurn) {
                        try {
                            lock.wait();
                        } catch(InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println(i);
                    isOddTurn = true;
                    lock.notifyAll();
                }
            }
        });

        executor.shutdown();

    }
    
}

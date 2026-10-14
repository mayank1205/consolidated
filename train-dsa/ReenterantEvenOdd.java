import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterantEvenOdd {


    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();

    private static boolean isOddTurn = true;

    public static void main(String[] args) {

        final int MAX = 10;
        
        Thread oddThread = new Thread(() -> {
            for(int i = 1; i <= MAX; i += 2) {
                lock.lock();
                try {
                    while (!isOddTurn) {
                        condition.await();
                    }
                    System.out.println("Odd: " + i);
                    isOddTurn = false;
                    condition.signalAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for(int i = 2; i<=MAX; i += 2){
                lock.lock();
                try{
                    while(isOddTurn){
                        condition.await();
                    }
                    System.out.println("Even: " + i);
                    isOddTurn = true;
                    condition.signalAll();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        });

        oddThread.start();
        evenThread.start();
        
    }
    
}

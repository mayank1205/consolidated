import java.util.concurrent.locks.Lock;

public class ReenterantOddEven {

    public static Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    public static volatile boolean isOddTurn = true;

    public static void main(String[] args) {
        int MAX = 10;
        
        Thread oddFlow = new Thread(() -> {
            for(int i = 1; i<MAX; i+=2) {
                synchronized(lock) {
                    while(!isOddTurn) {
                        try{
                            lock.wait();
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("odd: "+i);
                    isOddTurn = false;
                    lock.notifyAll();
                }
            }
        });

        Thread evenFlow = new Thread(() -> {
            for(int i = 2; i<MAX; i+=2) {
                synchronized(lock) {
                    while(isOddTurn) {
                        try{
                            lock.wait();
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("even: "+ i);
                    isOddTurn = true;
                    lock.notifyAll();
                }
            }
        });
        oddFlow.start();
        evenFlow.start();

    }
    
}

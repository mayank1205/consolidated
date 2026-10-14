public class ConcurrentEvenOdd {
    private static Object lock = new Object();
    private static boolean isOddTurn = true;
    public static void main(String[] args) {
        final int MAX = 10;
        Thread odd = new Thread(() -> {
            for(int i = 1; i<= MAX; i+=2) {
                synchronized(lock) {
                    while(!isOddTurn) {
                        try {
                            lock.wait();
                        } catch(InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Odd: "+i);
                    isOddTurn = false;
                    lock.notifyAll();
                }
            }
        });
        Thread even = new Thread(() -> {
            for(int i = 2; i<= MAX; i+=2) {
                synchronized(lock) {
                    while(isOddTurn) {
                        try {
                            lock.wait();
                        }catch(InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Even: "+i);
                    isOddTurn = true;
                    lock.notifyAll();
                }
            }
        });

        odd.start();
        even.start();
    }
}
public class MultiThreadEvenOdd {

    private static final Object lock = new Object();
    private static boolean oddTurn = true;
    public static void main(String[] args) {

        final int MAX = 10;
        
        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= MAX; i += 2) {
                synchronized(lock) {
                    while(oddTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even: " + i);
                    oddTurn = true;
                    lock.notifyAll();
                }
            }
        });
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= MAX; i += 2) {
                synchronized(lock) {
                    while(!oddTurn){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Odd: " + i);
                    oddTurn = false;
                    lock.notifyAll();
                }
            }
        });

        evenThread.start();
        oddThread.start();
    }

}
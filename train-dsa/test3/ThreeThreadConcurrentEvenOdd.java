public class ThreeThreadConcurrentEvenOdd {
    private static final Object lock = new Object();
    private static int turn = 1;
    public static void main(String[] args) {
        final int MAX = 10;
        Thread first = new Thread(() -> {
            for(int i =1; i<=MAX; i+=3) {
                synchronized(lock) {
                    while(turn % 3 != 1) {
                        try {
                            lock.wait();
                        } catch(InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("first: "+i);
                    turn++;
                    lock.notifyAll();
                }
            }
        });

        Thread second = new Thread(() -> {
            for(int i = 2; i<=MAX; i+=3) {
                synchronized(lock) {
                    while(turn % 3 != 2) {
                        try {
                            lock.wait();
                        }catch(InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("second: "+ i);
                    turn++;
                    lock.notifyAll();
                }
            }

        });

        Thread third = new Thread(() -> {
            for(int i = 3; i<= MAX; i+=3) {
                synchronized(lock) {
                    while(turn % 3 != 0) {
                        try {
                            lock.wait();
                        }catch(InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Third: " + i);
                    turn++;
                    lock.notifyAll();
                }
            }
        });

        first.start();
        second.start();
        third.start();
    }
}

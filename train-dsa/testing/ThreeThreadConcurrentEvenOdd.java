public class ThreeThreadConcurrentEvenOdd {

    private static final Object lock = new Object();
    private static int turn = 1;
    public static void main(String[] args) {

        Thread one = new Thread(() -> {
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

        Thread two = new Thread(() -> {
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

        Thread three = new Thread(() -> {
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
        one.start();
        two.start();
        three.start();
    }
    
}

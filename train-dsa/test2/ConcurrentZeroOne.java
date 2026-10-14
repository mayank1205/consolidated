public class ConcurrentZeroOne {

    private static boolean isZeroTurn = true;
    private static Object lock = new Object();

    public static void main(String[] args) {
        Thread zero = new Thread(() -> {
            synchronized(lock) {
                while(!isZeroTurn) {
                    try {
                        lock.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int i =0;i<10;i++) {
                    System.out.println(0);
                    isZeroTurn = false;
                    lock.notifyAll();
                }
            }
        });
        
        Thread one = new Thread(() -> {
            synchronized(lock) {
                while(isZeroTurn) {
                    try {
                        lock.wait();
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int i =0;i<10;i++) {
                    System.out.println(1);
                    isZeroTurn = false;
                    lock.notifyAll();
                }
            }
        });
        zero.start();
        one.start();
    }
}

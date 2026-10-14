class ConcurrentOddEven {

    private static boolean isOddTurn = true;
    private static Object lock = new Object();
    public static void main(String[] args) {
        int MAX = 11;

        Thread oddThread = new Thread(() -> {
            for(int i =1;i<MAX; i+=2) {
                synchronized(lock) {
                    while(!isOddTurn) {
                        try {
                            lock.wait();
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Odd: "+i);
                    isOddTurn = false;
                    lock.notifyAll();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for(int i = 2; i< MAX; i+=2) {
                synchronized(lock) {
                    while(isOddTurn) {
                        try {
                            lock.wait();
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Even: "+i);
                    isOddTurn = true;
                    lock.notifyAll();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
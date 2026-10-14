public class OddEvenPrinter {

    private static int number = 1;
    private static final int MAX = 10;
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread oddThread = new Thread(() -> {
            while (number <= MAX) {
                synchronized (lock) {
                    while (number % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    if (number <= MAX) {
                        System.out.println("Odd : " + number++);
                    }

                    lock.notifyAll();
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            while (number <= MAX) {
                synchronized (lock) {
                    while (number % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    if (number <= MAX) {
                        System.out.println("Even: " + number++);
                    }

                    lock.notifyAll();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
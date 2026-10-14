import java.util.concurrent.atomic.AtomicInteger;

public class CheckNumberOfInstances {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            Employee e = new Employee();
            System.out.println(e.getCount());
        });

        Thread t2 = new Thread(() -> {
            Employee e1 = new Employee();
            System.out.println(e1.getCount());
        });

        Thread t3 = new Thread(() -> {
            Employee e2 = new Employee();
            System.out.println(e2.getCount());
        });
        
        Thread t4 = new Thread(() -> {
            Employee e3 = new Employee();
            System.out.println(e3.getCount());
        });
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        
    }
}

class Employee {

    private static AtomicInteger count = new AtomicInteger();

    Employee() {
        count.incrementAndGet();
    }

    public AtomicInteger getCount(){
        return count;
    }
}

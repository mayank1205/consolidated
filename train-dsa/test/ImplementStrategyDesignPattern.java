public class ImplementStrategyDesignPattern {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService(new CardPayment());
        paymentService.processPayment(Double.valueOf(100));
        
    }
}

interface PaymentStrategy {
    public abstract void pay(double amount);
}

class UpiPayment implements PaymentStrategy {
    @Override 
    public void pay(double amount) {
        System.out.println("do upi payment for: " + amount);
    }
}

class CardPayment implements PaymentStrategy {
    @Override 
    public void pay(double amount) {
        System.out.println("do card payment for: " + amount);
    }
}

class PaymentService {

    private PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}


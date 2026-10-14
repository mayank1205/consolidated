public class StrategyImplementation {

    private static PaymentService paymentService;

    public static void main(String[] args) {
        if(args == null || args.length < 1) {
            throw new IllegalArgumentException("Payment mode not provided");
        }
        String paymentType = args[0];
        paymentService = new PaymentService(PaymentFactory.getPaymentModeFactory(paymentType));
        paymentService.doPayment();
    }

    
}

class PaymentFactory {
    public static PaymentStrategy getPaymentModeFactory(String paymentMode) {
        if(paymentMode.equals("upi")) {
            return new UpiPayment();
        } else if(paymentMode.equals("card")){
            return new CardPayment();
        } else {
            throw new IllegalArgumentException("Invalid Payment mode");
        }
    }
}

class PaymentService {
    private PaymentStrategy paymentStrategy;

    PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void doPayment() {
        this.paymentStrategy.pay();
    }
}

interface PaymentStrategy {
    public void pay();
}

class UpiPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Doing UPI Payment");
    }
}

class CardPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Doing Card Payment");
    }
}
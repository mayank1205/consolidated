public class FactoryAndStrategyImpl {

    private static PaymentService paymentService;

    public static void main(String[] args) {
        if(args == null || args.length <1) {
            throw new IllegalArgumentException("payment selection not provided");
        }
        String paymentSelection = args[0];
        paymentService = new PaymentService(PaymentFactory.getPaymentStrategy(paymentSelection));
        paymentService.doPayment();
    }
}

class PaymentFactory {
    public static PaymentStrategy getPaymentStrategy(String paymentSelectionType) throws IllegalArgumentException {
        if("upi".equalsIgnoreCase(paymentSelectionType)) {
            return new UpiPayment();
        } else if("card".equalsIgnoreCase(paymentSelectionType)) {
            return new CardPayment();
        } else {
            throw new IllegalArgumentException("invalid payment selection type provided");
        }
    }
}

class PaymentService {
    PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
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
        System.out.println("UPI Payment selected");
    }
}

class CardPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Card Payment selected");
    }
}
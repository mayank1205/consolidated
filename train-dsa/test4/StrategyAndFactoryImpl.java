public class StrategyAndFactoryImpl {
    public static void main(String[] args) {
        if(args.length < 1) {
            throw new IllegalArgumentException("Please pass payment type");
        }
        PaymentService paymentService = new PaymentService(PaymentFactory.getPaymentInstance(args[0]));
        paymentService.doPayment();
    }
}

class PaymentFactory {
    public static PaymentStrategy getPaymentInstance(String paymentType) {
        if("upi".equalsIgnoreCase(paymentType)) {
            return UpiPayment.getUpiPaymentInstance();
        } else if("card".equalsIgnoreCase(paymentType)) {
            return CardPayment.getCardPaymentInstance();
        } else {
            throw new IllegalArgumentException("Invalid payment type");
        }
    }
}

class PaymentService {
    PaymentStrategy paymentStrategy;

    PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void doPayment() {
        paymentStrategy.pay();
    }
}

interface PaymentStrategy {
    public void pay();
}

class UpiPayment implements PaymentStrategy {

    private static UpiPayment upiPayment;

    public static UpiPayment getUpiPaymentInstance() {
        if(upiPayment == null) {
            upiPayment = new UpiPayment();
        }
        return upiPayment;
    }

    @Override
    public void pay() {
        System.out.println("Doing UPI Payment");
    }
}

class CardPayment implements PaymentStrategy {

    private static CardPayment cardPayment;

    public static CardPayment getCardPaymentInstance() {
        if(cardPayment == null) {
            cardPayment = new CardPayment();
        }
        return cardPayment;
    }
    @Override
    public void pay() {
        System.out.println("Doing Card Payment");
    }
}

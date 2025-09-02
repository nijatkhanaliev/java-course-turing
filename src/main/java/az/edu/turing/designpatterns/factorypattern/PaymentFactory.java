package az.edu.turing.designpatterns.factorypattern;

public class PaymentFactory {

    public static Payment getPayment(PaymentType payment) {
        return switch (payment) {
            case PAYPAL -> new PaypalPayment();
            case STRIPE -> new StripePayment();
        };
    }

}

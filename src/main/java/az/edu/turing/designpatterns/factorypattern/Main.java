package az.edu.turing.designpatterns.factorypattern;

public class Main {

    public static void main(String[] args) {
        Payment paypal = PaymentFactory.getPayment(PaymentType.PAYPAL);
        paypal.pay();

        Payment stripe = PaymentFactory.getPayment(PaymentType.STRIPE);
        stripe.pay();
    }

}

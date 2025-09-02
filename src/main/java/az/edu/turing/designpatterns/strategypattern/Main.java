package az.edu.turing.designpatterns.strategypattern;

public class Main {
    public static void main(String[] args) {

        PaymentStrategy paypalPayment = new PaypalPayment();
        PaymentStrategy stripePayment = new StripePayment();


        PaymentContext paymentContextStripe = new PaymentContext(stripePayment);
        paymentContextStripe.executePayment();


        PaymentContext paymentContextPaypal = new PaymentContext(paypalPayment);
        paymentContextPaypal.executePayment();


    }
}

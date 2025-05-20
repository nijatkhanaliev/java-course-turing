package az.edu.turing.module3.lesson09;

public class RegularPriceStrategy implements PriceService{
    @Override
    public double price(double basePrice) {
        return basePrice;
    }
}

package az.edu.turing.module3.lesson09.reportgenerator;

public class Product {
    @IncludeInReport
    private String name;

    private String description;

    @IncludeInReport
    private double price;

    @IncludeInReport
    private String category;



    public Product(String name, double price, String category,String description) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

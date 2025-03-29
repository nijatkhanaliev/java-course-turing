package az.edu.turing.module2.lesson05;

public class Laptop extends Computer{
    private String model;

    public Laptop() {

    }

    @Override
    public void code() {
        System.out.println("laptop");
    }

    public Laptop(String model, String name, Integer releaseYear) {
        super(name, releaseYear);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

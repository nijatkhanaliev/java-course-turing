package az.edu.turing.module2.lesson05;

public class Desktop extends Computer{
    private String model;

    public Desktop() {

    }

    public void code() {
        System.out.println("desktop");
    }

    public Desktop(String model,String name, Integer releaseYear) {
        super(name, releaseYear);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int sendRequest(){
        System.out.println("sended");

        return 5;
    }

}

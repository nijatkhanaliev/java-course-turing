package az.edu.turing.module2.lesson03;

public abstract sealed class Car permits Bmw,Mercedes,Hyundai {
    private String name;
    private String model;
    private String color;

    public abstract void start();
    public abstract void stop();

    public String getName(){
        return this.name;
    }

    public String getModel(){
        return this.model;
    }

    public String getColor(){
        return this.color;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

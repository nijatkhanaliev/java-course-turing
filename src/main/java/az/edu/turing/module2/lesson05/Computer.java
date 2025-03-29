package az.edu.turing.module2.lesson05;

public abstract class Computer {
    private String name;
    private Integer releaseYear;

    public Computer(){}

    public Computer(String name,Integer releaseYear){
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public abstract void code();

    public int sendRequest(){
        return 0;
    }

}

package az.edu.turing.module4.lesson01.model;

public class Project {
    private long id;
    private String name;
    private User user;
    private Category category;

    public Project() {
    }

    public Project(long id, String name, User user, Category category) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.category = category;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}

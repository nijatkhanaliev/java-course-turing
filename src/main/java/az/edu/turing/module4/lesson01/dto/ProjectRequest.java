package az.edu.turing.module4.lesson01.dto;

import az.edu.turing.module4.lesson01.model.Category;
import az.edu.turing.module4.lesson01.model.User;

public class ProjectRequest {
    private String name;
    private User user;
    private Category category;

    public ProjectRequest() {
    }

    public ProjectRequest(String name, User user, Category category) {
        this.name = name;
        this.user = user;
        this.category = category;
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
}

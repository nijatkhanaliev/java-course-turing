package az.edu.turing.module4.lesson01;

import az.edu.turing.module4.lesson01.dto.ProjectRequest;
import az.edu.turing.module4.lesson01.model.Category;
import az.edu.turing.module4.lesson01.model.Project;
import az.edu.turing.module4.lesson01.model.User;
import az.edu.turing.module4.lesson01.service.ProjectService;
import az.edu.turing.module4.lesson01.service.impl.ProjectServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        ProjectService projectService = new ProjectServiceImpl();
        List<Project> allProject = projectService.getAllProject();
        System.out.println(allProject);
//
        System.out.println(projectService.count());

        User user = new User();
        user.setId(1);

        Category category = new Category();
        category.setId(6);

        ProjectRequest projectRequest = new ProjectRequest("name finder",user,category);

        try {
//            projectService.addProject("llm system",user,category);
//             projectService.deleteProject(10);
            projectService.updateProject(projectRequest,5);

            System.out.println(projectService.getAllProject());
            System.out.println(projectService.count());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}

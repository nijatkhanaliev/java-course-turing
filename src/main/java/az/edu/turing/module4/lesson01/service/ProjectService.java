package az.edu.turing.module4.lesson01.service;

import az.edu.turing.module4.lesson01.dto.ProjectRequest;
import az.edu.turing.module4.lesson01.model.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectService {
    List<Project> getAllProject();
    Project getProjectById(int id);
    void addProject(ProjectRequest project) throws SQLException;
    void updateProject(ProjectRequest project,int id) throws SQLException;
    void deleteProject(int id) throws SQLException;
    long count();
}

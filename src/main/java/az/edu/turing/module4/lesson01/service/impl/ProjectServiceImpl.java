package az.edu.turing.module4.lesson01.service.impl;

import az.edu.turing.module4.lesson01.dao.ConnectionDao;
import az.edu.turing.module4.lesson01.dto.ProjectRequest;
import az.edu.turing.module4.lesson01.model.Category;
import az.edu.turing.module4.lesson01.model.Project;
import az.edu.turing.module4.lesson01.model.User;
import az.edu.turing.module4.lesson01.service.ProjectService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectServiceImpl extends ConnectionDao implements ProjectService {
    @Override
    public List<Project> getAllProject() {
        List<Project> projects = new ArrayList<>();

        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from projects");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Project project = getProject(resultSet, connection);
                projects.add(project);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Get all Project " + e.getMessage());
        }

        return projects;
    }

    @Override
    public Project getProjectById(int id) {
        Project project = null;

        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from project where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                project = getProject(resultSet, connection);
            }

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Get Project By ID: " + e.getMessage());
        }

        return project;
    }

    @Override
    public void addProject(ProjectRequest project) throws SQLException {
        Connection connection = null;
        try {
            connection = connect();

            String query = "insert into projects(name,user_id,category_id) values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, project.getName());
            preparedStatement.setInt(2, project.getUser().getId());
            preparedStatement.setInt(3, project.getCategory().getId());

            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            connection.rollback();
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }
    }

    @Override
    public void updateProject(ProjectRequest project, int id) throws SQLException {
        Connection connection = null;
        try {
            connection = connect();

            String query = "update projects set name=?,user_id=?,category_id=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, project.getName());
            preparedStatement.setInt(2, project.getUser().getId());
            preparedStatement.setInt(3, project.getCategory().getId());
            preparedStatement.setInt(4, id);

            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            connection.rollback();
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }

    }

    @Override
    public void deleteProject(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = connect();

            String query = "delete from projects where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException | ClassNotFoundException e) {
            connection.rollback();
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }
    }

    @Override
    public long count() {
        long count = 0;
        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select count(*) as project_count from projects");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                count = resultSet.getInt("project_count");
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Count: " + e.getMessage());
        }

        return count;
    }


    private Project getProject(ResultSet resultSet, Connection connection) throws SQLException {
        Project project = new Project();

        long id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        int user_id = resultSet.getInt("user_id");
        int category_id = resultSet.getInt("category_id");

        User user = getUser(connection, user_id);
        Category category = getCategory(connection, category_id);

        project.setId(id);
        project.setName(name);
        project.setUser(user);
        project.setCategory(category);

        return project;
    }

    private User getUser(Connection connection, int user_id) throws SQLException {
        String query = "select * from users where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, user_id);
        ResultSet userResultSet = preparedStatement.executeQuery();

        User user = new User();
        while (userResultSet.next()) {
            String name = userResultSet.getString("name");
            String surname = userResultSet.getString("surname");
            int age = userResultSet.getInt("age");

            user.setId(user_id);
            user.setName(name);
            user.setSurname(surname);
            user.setAge(age);
        }

        return user;
    }

    private Category getCategory(Connection connection, int category_id) throws SQLException {
        String query = "select * from category where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, category_id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Category category = new Category();
        while (resultSet.next()) {
            String name = resultSet.getString("name");

            category.setId(category_id);
            category.setName(name);
        }

        return category;
    }
}

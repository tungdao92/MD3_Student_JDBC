package rikkei.academy.Service;

import rikkei.academy.config.ConnectMySQL;
import rikkei.academy.model.Students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMLP implements IStudentService {

    private Connection connection = ConnectMySQL.getConnection();

    private static final String CREATE_STUDENT="INSERT INTO students (name, age) VALUES (?, ?);";
    private  static  final String LIST_STUDENT= "SELECT * FROM students;";

    private static final String STUDENT_BY_ID = "SELECT * FROM students WHERE id = ?;";

    private static final String UPDATE_STUDENT = "UPDATE students SET name = ?, age = ? WHERE id = ?;";

    private static final String DELETE_STUDENT = "DELETE FROM students WHERE id = ?;";
    public StudentServiceIMLP() throws SQLException {
    }

    @Override
    public List<Students> findAll() {
        List<Students> studentsList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(LIST_STUDENT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name= resultSet.getString("name");
                int age = resultSet.getInt("age");
                Students students = new Students(id, name, age);
                studentsList.add(students);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentsList;
    }

    @Override
    public void save(Students students) {
        try {
            if (findById(students.getId())== null) {
                PreparedStatement preparedStatement = connection.prepareStatement(CREATE_STUDENT);
                preparedStatement.setString(1,students.getName());
                preparedStatement.setInt(2,students.getAge());
                preparedStatement.executeUpdate();
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
                preparedStatement.setString(1,students.getName());
                preparedStatement.setInt(2,students.getAge());
                preparedStatement.setInt(3,students.getId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Students findById(int id) {
        Students students = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(STUDENT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                students = new Students(id, name, age);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public Students deleteById(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}

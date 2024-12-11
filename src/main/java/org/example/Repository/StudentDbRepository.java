package org.example.Repository;

import org.example.Domain.Entity;
import org.example.Domain.Student;
import org.example.Domain.Validator;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class StudentDbRepository implements Repository<Long, Student>{
    private final String url;
    private final String username;
    private final String password;
    private final Validator<Long,Student> validator;

    public StudentDbRepository(String url, String username, String password, Validator<Long, Student> validator) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.validator = validator;
    }

    @Override
    public Student findOne(Long id) {
        String sql="SELECT * from student where id = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String grupa = resultSet.getString("grupa");
                Double media = resultSet.getDouble("media");

                return new Student(nume,prenume,grupa,media);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Student> findbyName(String nume, String prenume) {
        return null;
    }

    @Override
    public int findId(String nume, String prenume, String grupa, Double media) {
        return 0;
    }

    @Override
    public Iterable<Student> findAll() {
        Set<Student> books = new HashSet<>();
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("SELECT * from student");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Long id = resultSet.getLong("id");
                String nume = resultSet.getString("nume");
                String prenume = resultSet.getString("prenume");
                String grupa = resultSet.getString("grupa");
                Double media = resultSet.getDouble("media");

               Student student=new Student(nume,prenume,grupa,media);
                student.setId(id);
                books.add(student);
            }
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public Student save(Student entity) {
        return null;
    }

    @Override
    public Student delete(Long mail) {
        return null;
    }

    @Override
    public Student update(Student entity) {
        return null;
    }
}

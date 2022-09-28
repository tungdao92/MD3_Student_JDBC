package rikkei.academy.Service;

import rikkei.academy.model.Students;

import java.util.List;

public interface IStudentService {
    List<Students> findAll();
    void save(Students students);
    Students findById(int id);
    Students deleteById(int id);

}

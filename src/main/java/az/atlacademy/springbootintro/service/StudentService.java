package az.atlacademy.springbootintro.service;

import az.atlacademy.springbootintro.dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1L,"Magsad","Novruzov","magsad@gmail.com","Xirdalan",1700.50));
        students.add(new Student(2L,"Feraset","Novruzov","feraset@gmail.com","Nerimanov",1500));
        students.add(new Student(3L,"Merdan","Novruzov","merdan@gmail.com","Samaxi",2100));

    }
    public List<Student> getList() {
        return students;
    }

    public Student getStudentById(Long id) {
        return students.stream().filter(s->s.getId().equals(id)).findFirst().get();
    }

    public Student create(Student student) {
        student.setId((long) Math.random()*100);
        students.add(student);
        return student;
    }

    public Student update(Student student) {
        Student forUpdate = getStudentById(student.getId());
        forUpdate.setId(student.getId());
        forUpdate.setName(student.getName());
        forUpdate.setSurname(student.getSurname());
        forUpdate.setEmail(student.getEmail());
        forUpdate.setAddress(student.getAddress());
        return forUpdate;
    }

    public Student delete(Student student) {
        Student forDelete = getStudentById(student.getId());
        students.remove(forDelete);
        return student;
    }

    public Student deleteById(Long id) {
        Student forDelete = getStudentById(id);
        students.remove(forDelete);
        return forDelete;
    }
}

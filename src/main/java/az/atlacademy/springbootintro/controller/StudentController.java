package az.atlacademy.springbootintro.controller;

import az.atlacademy.springbootintro.dto.Student;
import az.atlacademy.springbootintro.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getList());
    }

    @GetMapping(value = "/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @GetMapping(value = "/query")
    public ResponseEntity<Student> getStudentByIdQuery(@RequestParam ("id") Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping()//save-C/create-S/insert-Database
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.ok(studentService.create(student));
    }

    @PutMapping()
    public ResponseEntity<Student> update(@RequestBody Student student){
        return ResponseEntity.ok(studentService.update(student));
    }

    @DeleteMapping()
    public ResponseEntity<Student> delete(@RequestBody Student student){
        return ResponseEntity.ok(studentService.delete(student));
    }

    @DeleteMapping(value = "/{studentId}")
    public ResponseEntity<Student> deleteById(@PathVariable("studentId") Long id){
        return ResponseEntity.ok(studentService.deleteById(id));
    }

    @DeleteMapping(value = "/query{studentId}")
    public ResponseEntity<Student> deleteByIdQuery(@RequestParam("studentId") Long id){
        return ResponseEntity.ok(studentService.deleteById(id));
    }
}

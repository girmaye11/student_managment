package com.student.studregister.contoller;

import com.student.studregister.exception.resourcenotfoundexception;
import com.student.studregister.model.student;
import com.student.studregister.repository.studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin(origins="*")

@RestController
@RequestMapping("/api/v1")
public class studentController {

    @Autowired
    private studentrepository Studentrespository;
    public studentController(studentrepository Studentrespository) {
        super();
        this.Studentrespository = Studentrespository;
    }

@GetMapping("/students")
//get all students
    public List<student> getAllstudents() {
        return Studentrespository.findAll();

    }
    // create student rest api
    @PostMapping("/students")
    public student createEmployee(@RequestBody student Student) {
        return Studentrespository.save(Student);
    }
    // get student by id rest api
    @GetMapping("/students/{id}")
    public ResponseEntity<student> getStudentById(@PathVariable Long id) {
        student Student = Studentrespository.findById(id)
                .orElseThrow(() -> new resourcenotfoundexception("Student not exist with id :" + id));
        return ResponseEntity.ok(Student);
    }

    // delete student rest api


    @DeleteMapping("/students/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStudent(@PathVariable Long id) {
        student Student = Studentrespository.findById(id)
                .orElseThrow(() -> new resourcenotfoundexception("Student not exist with id :" + id));
        Studentrespository.delete(Student);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


// update Student rest api

    @PutMapping("/students/{id}")
    public ResponseEntity<student> updateStudent(@PathVariable Long id, @RequestBody student studentDetails){
        student Student = Studentrespository.findById(id)
                .orElseThrow(() -> new resourcenotfoundexception("Student not exist with id :" + id));

        Student.setFirstname(studentDetails.getFirstname());
        Student.setLastname(studentDetails.getLastname());
        Student.setEmail(studentDetails.getEmail());
        Student.setPhone(studentDetails.getPhone());

        student updatedStudent = Studentrespository.save(Student);
        return ResponseEntity.ok(updatedStudent);
    }


}







